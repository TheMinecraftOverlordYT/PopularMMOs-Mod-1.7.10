package com.popularmmos.generation;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class PopularChestGenHooks extends ChestGenHooks{

    public static final String POPULAR = "popular";

    private static final HashMap<String, ChestGenHooks> chestInfo = new HashMap<String, ChestGenHooks>();
    private static boolean hasInit = false;

    static
    {
        init();
    }

    private static void init()
    {
        if (hasInit)
        {
            return;
        }

        hasInit = true;

        addInfo(POPULAR, Gym.popularChestContents, 3, 7);

        ItemStack book = new ItemStack(Items.enchanted_book, 1, 0);
        WeightedRandomChestContent tmp = new WeightedRandomChestContent(book, 1, 1, 1);
        getInfo(POPULAR).addItem(tmp);
    }

    static void addDungeonLoot(ChestGenHooks dungeon, ItemStack item, int weight, int min, int max)
    {
        dungeon.addItem(new WeightedRandomChestContent(item, min, max, weight));
    }

    /**
     * Retrieves, or creates the info class for the specified category.
     *
     * @param category The category name
     * @return A instance of ChestGenHooks for the specified category.
     */
    public static ChestGenHooks getInfo(String category)
    {
        if (!chestInfo.containsKey(category))
        {
            chestInfo.put(category, new ChestGenHooks(category));
        }
        return chestInfo.get(category);
    }

    /**
     * Generates an array of items based on the input min/max count.
     * If the stack can not hold the total amount, it will be split into
     * stacks of size 1.
     *
     * @param rand A random number generator
     * @param source Source item stack
     * @param min Minimum number of items
     * @param max Maximum number of items
     * @return An array containing the generated item stacks
     */
    public static ItemStack[] generateStacks(Random rand, ItemStack source, int min, int max)
    {
        int count = min + (rand.nextInt(max - min + 1));

        ItemStack[] ret;
        if (source.getItem() == null)
        {
            ret = new ItemStack[0];
        }
        else if (count > source.getMaxStackSize())
        {
            ret = new ItemStack[count];
            for (int x = 0; x < count; x++)
            {
                ret[x] = source.copy();
                ret[x].stackSize = 1;
            }
        }
        else
        {
            ret = new ItemStack[1];
            ret[0] = source.copy();
            ret[0].stackSize = count;
        }
        return ret;
    }

    //shortcut functions, See the non-static versions below
    public static WeightedRandomChestContent[] getItems(String category, Random rnd){ return getInfo(category).getItems(rnd); }
    public static int getCount(String category, Random rand){ return getInfo(category).getCount(rand); }
    public static void addItem(String category, WeightedRandomChestContent item){ getInfo(category).addItem(item); }
    public static void removeItem(String category, ItemStack item){ getInfo(category).removeItem(item); }
    public static ItemStack getOneItem(String category, Random rand){ return getInfo(category).getOneItem(rand); }

    private String category;
    private int countMin = 0;
    private int countMax = 0;
    private ArrayList<WeightedRandomChestContent> contents = new ArrayList<WeightedRandomChestContent>();

    public PopularChestGenHooks(String category)
    {
        super(category);
    }

    public PopularChestGenHooks(String category, WeightedRandomChestContent[] items, int min, int max)
    {
        this(category);
        for (WeightedRandomChestContent item : items)
        {
            contents.add(item);
        }
        countMin = min;
        countMax = max;
    }

    private static void addInfo(String category, WeightedRandomChestContent[] items, int min, int max)
    {
        chestInfo.put(category, new ChestGenHooks(category, items, min, max));
    }

    /**
     * Adds a new entry into the possible items to generate.
     *
     * @param item The item to add.
     */
    public void addItem(WeightedRandomChestContent item)
    {
        contents.add(item);
    }

    /**
     * Removes all items that match the input item stack, Only metadata and item ID are checked.
     * If the input item has a metadata of -1, all metadatas will match.
     *
     * @param item The item to check
     */
    public void removeItem(ItemStack item)
    {
        Iterator<WeightedRandomChestContent> itr = contents.iterator();
        while(itr.hasNext())
        {
            WeightedRandomChestContent cont = itr.next();
            if (item.isItemEqual(cont.theItemId) || (item.getItemDamage() == OreDictionary.WILDCARD_VALUE && item.getItem() == cont.theItemId.getItem()))
            {
                itr.remove();
            }
        }
    }

    /**
     * Gets an array of all random objects that are associated with this category.
     *
     * @return The random objects
     */
    public WeightedRandomChestContent[] getItems(Random rnd)
    {
        ArrayList<WeightedRandomChestContent> ret = new ArrayList<WeightedRandomChestContent>();

        for (WeightedRandomChestContent orig : contents)
        {
            Item item = orig.theItemId.getItem();

            if (item != null)
            {
                WeightedRandomChestContent n = item.getChestGenBase(this, rnd, orig);
                if (n != null)
                {
                    ret.add(n);
                }
            }
        }

        return ret.toArray(new WeightedRandomChestContent[ret.size()]);
    }
    /**
     * Gets a random number between countMin and countMax.
     *
     * @param rand A RNG
     * @return A random number where countMin <= num <= countMax
     */
    public int getCount(Random rand)
    {
        return countMin < countMax ? countMin + rand.nextInt(countMax - countMin) : countMin;
    }

    /**
     * Returns a single ItemStack from the possible items in this registry,
     * Useful if you just want a quick and dirty random Item.
     *
     * @param rand  A Random Number gen
     * @return A single ItemStack, or null if it could not get one.
     */
    public ItemStack getOneItem(Random rand)
    {
        WeightedRandomChestContent[] items = getItems(rand);
        WeightedRandomChestContent item = (WeightedRandomChestContent)WeightedRandom.getRandomItem(rand, items);
        ItemStack[] stacks = ChestGenHooks.generateStacks(rand, item.theItemId, item.theMinimumChanceToGenerateItem, item.theMaximumChanceToGenerateItem);
        return (stacks.length > 0 ? stacks[0] : null);
    }

    //Accessors
    public int getMin()
    {
        return countMin;
    }

    public int getMax()
    {
        return countMax;
    }

    public void setMin(int value)
    {
        countMin = value;
    }

    public void setMax(int value)
    {
        countMax = value;
    }
}