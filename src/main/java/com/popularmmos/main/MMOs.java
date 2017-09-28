package com.popularmmos.main;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

@Mod(modid = MMOs.MODID, version = MMOs.VERSION)
public class MMOs
{
    @SidedProxy(clientSide = "com.popularmmos.main.ClientProxy", serverSide = "com.popularmmos.main.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Metadata
    public static ModMetadata meta;

    public static final String MODID = "MMOs";
    public static final String VERSION = "1.0";

    public static Achievement beauty;
    public static Achievement pixelsus;
    public static Achievement popularmmos;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);

        beauty = addAchievement("achievement.smeltPink", "achievementPink", 0, 1, new ItemStack(PopularItems.pinkEssence), null);
        pixelsus = addAchievement("achievement.ridePixelsus", "achievementPixelsus", 3, 2, new ItemStack(PopularItems.pinkEssence), beauty);
        popularmmos = addAchievement("achievement.killPat", "achievementPopular", 0, -1, new ItemStack(PopularItems.furiousEssence), null);

        AchievementPage PopularAchievementPage = new AchievementPage("The PopularMMOS Mod", beauty, pixelsus, popularmmos);
        AchievementPage.registerAchievementPage(PopularAchievementPage);

        FMLCommonHandler.instance().bus().register(new AchievementHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

    public static void addAchievements()
    {
        beauty = addAchievement("achievement.smeltPink", "achievementPink", 2, 0, new ItemStack(PopularItems.pinkEssence), null);
        pixelsus = addAchievement("achievement.ridePixelsus", "achievementPixelsus", 3, 5, new ItemStack(PopularItems.pinkEssence), beauty);
        popularmmos = addAchievement("achievement.killPat", "achievementPopular", -2, 0, new ItemStack(PopularItems.furiousEssence), null);
    }

    private static Achievement addAchievement(String n, String id, int y, int x, ItemStack icon, Achievement a)
    {
        Achievement achievement = new Achievement(n, id, y, x, icon, a);
        achievement.registerStat();
        return achievement;
    }

}
