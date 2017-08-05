package com.popularmmos.main;


import com.popularmmos.entities.jenboss.EntityJenBoss;
import com.popularmmos.entities.jenboss.ModelJenBoss;
import com.popularmmos.entities.jenboss.RenderJenBoss;
import com.popularmmos.entities.jenboss.subsidiaries.lightningPink.EntityLightningPink;
import com.popularmmos.entities.jenboss.subsidiaries.lightningPink.RenderLightningPink;
import com.popularmmos.entities.jenicorn.EntityJenicorn;
import com.popularmmos.entities.jenicorn.ModelJenicorn;
import com.popularmmos.entities.jenicorn.RenderJenicorn;
import com.popularmmos.entities.pat.EntityPat;
import com.popularmmos.entities.pat.ModelPat;
import com.popularmmos.entities.pat.RenderPat;
import com.popularmmos.entities.pat.largeweight.EntityLargeWeight;
import com.popularmmos.entities.pat.largeweight.RenderLargeWeight;
import com.popularmmos.entities.pat.smallweight.EntitySmallWeight;
import com.popularmmos.entities.pat.smallweight.RenderSmallWeight;
import com.popularmmos.items.largeWeight.RenderItemLargeWeight;
import com.popularmmos.items.pinkSword.RenderPinkSword;
import com.popularmmos.items.smallWeight.RenderItemSmallWeight;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy{

    public void registerRenderThings()
    {

        MinecraftForgeClient.registerItemRenderer(PopularItems.smallWeight, new RenderItemSmallWeight());
        MinecraftForgeClient.registerItemRenderer(PopularItems.largeWeight, new RenderItemLargeWeight());
        MinecraftForgeClient.registerItemRenderer(PopularItems.pinkSword, new RenderPinkSword());

        RenderingRegistry.registerEntityRenderingHandler(EntityPat.class, new RenderPat(new ModelPat(), 0));
        RenderingRegistry.registerEntityRenderingHandler(EntityJenicorn.class, new RenderJenicorn(new ModelJenicorn(), 0));
        RenderingRegistry.registerEntityRenderingHandler(EntityJenBoss.class, new RenderJenBoss(new ModelJenBoss(), 0));

        RenderingRegistry.registerEntityRenderingHandler(EntitySmallWeight.class, new RenderSmallWeight());
        RenderingRegistry.registerEntityRenderingHandler(EntityLargeWeight.class, new RenderLargeWeight());

        RenderingRegistry.registerEntityRenderingHandler(EntityLightningPink.class, new RenderLightningPink());

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        RenderingRegistry.addNewArmourRendererPrefix("5");
        MinecraftForge.EVENT_BUS.register(new PopularEvents());
    }

}
