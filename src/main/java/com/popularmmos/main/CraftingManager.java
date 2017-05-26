package com.popularmmos.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CraftingManager
{
    public static void Popular()
    {
        addCraftingRecipes();
        addSmeltingRecipes();
    }

    public static void addCraftingRecipes()
    {

        GameRegistry.addShapedRecipe(new ItemStack(PopularItems.furiousHelm,1), new Object[] {"FFF", "F F", 'F', PopularItems.furiousEssence});
        GameRegistry.addShapedRecipe(new ItemStack(PopularItems.furiousChest,1), new Object[] {"F F", "FFF", "FFF", 'F', PopularItems.furiousEssence});
        GameRegistry.addShapedRecipe(new ItemStack(PopularItems.furiousLegs,1), new Object[] {"FFF", "F F", "F F", 'F', PopularItems.furiousEssence});
        GameRegistry.addShapedRecipe(new ItemStack(PopularItems.furiousBoots,1), new Object[] {"F F", "F F", 'F', PopularItems.furiousEssence});

        GameRegistry.addShapedRecipe(new ItemStack(PopularItems.pinkSword, 1), new Object[] {"P", "P", "S", 'P', PopularItems.pinkEssence, 'S', Items.nether_star});
        GameRegistry.addShapedRecipe(new ItemStack(PopularItems.smallWeight, 1), new Object[]{"FSF", 'F', PopularItems.furiousEssence, 'S', Items.stick});

        GameRegistry.addShapedRecipe(new ItemStack(PopularBlocks.patFace, 1), new Object[] {"FFF", "FFF", "FFF", 'F', PopularItems.furiousEssence});

    }

    public static void addSmeltingRecipes()
    {
        GameRegistry.addSmelting(PopularBlocks.pinkOre, new ItemStack(PopularItems.pinkEssence, 1), 10F);
    }

}
