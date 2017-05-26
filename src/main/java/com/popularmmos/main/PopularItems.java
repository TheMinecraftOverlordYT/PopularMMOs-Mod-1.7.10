package com.popularmmos.main;

import com.popularmmos.armor.FuriousArmor;
import com.popularmmos.items.Essence;
import com.popularmmos.items.largeWeight.ItemLargeWeight;
import com.popularmmos.items.pinkSword.ItemPinkSword;
import com.popularmmos.items.smallWeight.ItemSmallWeight;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class PopularItems {

    public static void PopularItems()
    {
        initThings();
        registerThings();
    }

    //=========================================Items==============================================//
    public static Item smallWeight;
    public static Item largeWeight;
    public static Item pinkSword;

    public static Item pinkEssence;
    public static Item furiousEssence;

    //============================================Armor===========================================//
    public static Item furiousHelm;
    public static Item furiousChest;
    public static Item furiousLegs;
    public static Item furiousBoots;

    //=========================================Creative Tabs======================================//

    public static final CreativeTabs popularTab = new CreativeTabs("popularTabs") {
        @Override
        public Item getTabIconItem() {
            return smallWeight;
        }
    };

    //=========================================Tool Materials=====================================//

    public static Item.ToolMaterial weightSmall = EnumHelper.addToolMaterial("weightSmall", 3, 1200, 5F, 10F, 15);
    public static Item.ToolMaterial weightLarge = EnumHelper.addToolMaterial("weightLarge",  3, -1, 5F, 15F, 15);
    public static Item.ToolMaterial swordPink = EnumHelper.addToolMaterial("pinkSword", 3, -1, 4F, 13F, 25);

    public static ItemArmor.ArmorMaterial furiousArmor = EnumHelper.addArmorMaterial("Furious", 35, new int[]{4, 9, 7, 4}, 15);

    public static void initThings()
    {
        smallWeight = new ItemSmallWeight(weightSmall).setUnlocalizedName("smallWeight").setTextureName("popular:SmallWeight").setCreativeTab(popularTab);
        largeWeight = new ItemLargeWeight(weightLarge).setUnlocalizedName("largeWeight").setTextureName("popular:LargeWeight").setCreativeTab(popularTab);
        pinkSword = new ItemPinkSword(swordPink).setUnlocalizedName("pinkSword").setTextureName("popular:PinkSword").setCreativeTab(popularTab);

        pinkEssence = new Essence().setUnlocalizedName("pinkEssence").setTextureName("popular:PinkEssence").setCreativeTab(popularTab);
        furiousEssence = new Essence().setUnlocalizedName("furiousEssence").setTextureName("popular:FuriousEssence").setCreativeTab(popularTab);

        furiousHelm = new FuriousArmor(furiousArmor, 5, 0).setUnlocalizedName("furiousHelm").setCreativeTab(popularTab);
        furiousChest = new FuriousArmor(furiousArmor, 5, 1).setUnlocalizedName("furiousChest").setCreativeTab(popularTab);
        furiousLegs = new FuriousArmor(furiousArmor, 5, 2).setUnlocalizedName("furiousLegs").setCreativeTab(popularTab);
        furiousBoots = new FuriousArmor(furiousArmor, 5,3 ).setUnlocalizedName("furiousBoots").setCreativeTab(popularTab);
    }

    public static void registerThings()
    {
        GameRegistry.registerItem(smallWeight, "smallWeight");
        GameRegistry.registerItem(largeWeight, "largeWeight");
        GameRegistry.registerItem(pinkSword, "pinkSword");

        GameRegistry.registerItem(pinkEssence, "pinkEssence");
        GameRegistry.registerItem(furiousEssence, "furiousEssence");

        GameRegistry.registerItem(furiousHelm, "furiousHelm");
        GameRegistry.registerItem(furiousChest, "furiousChest");
        GameRegistry.registerItem(furiousLegs, "furiousLegs");
        GameRegistry.registerItem(furiousBoots, "furiousBoots");
    }

}
