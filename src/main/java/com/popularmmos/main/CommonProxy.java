package com.popularmmos.main;


import com.popularmmos.generation.PopularWorldGen;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.entity.Entity;

public class CommonProxy
{
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {

        PopularItems.PopularItems();
        PopularEntities.Popular();
        PopularBlocks.Popular();
        CraftingManager.Popular();
        PopularWorldGen.Popular();

        registerRenderThings();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {

    }
    public void registerRenderThings() {}
    public void generatePinkParticles(Entity theEntity) {}
}
