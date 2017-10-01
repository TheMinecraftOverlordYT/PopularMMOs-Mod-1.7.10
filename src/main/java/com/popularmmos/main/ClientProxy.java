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
import com.popularmmos.events.PopularEventHandler;
import com.popularmmos.explosions.EntityPinkTNTPrimed;
import com.popularmmos.explosions.RenderPinkTNTPrimed;
import com.popularmmos.items.largeWeight.RenderItemLargeWeight;
import com.popularmmos.items.pinkSword.RenderPinkSword;
import com.popularmmos.items.smallWeight.RenderItemSmallWeight;
import com.popularmmos.particles.EntityParticleFXPinkSparkle;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

public class ClientProxy extends CommonProxy
{

    public static int sphereIdOutside;
    public static int sphereIdInside;

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

        RenderingRegistry.registerEntityRenderingHandler(EntityPinkTNTPrimed.class, new RenderPinkTNTPrimed());
    }

    @Override
    public void generatePinkParticles(Entity theEntity)
    {
        double motionX = theEntity.worldObj.rand.nextGaussian() * 0.02D;
        double motionY = theEntity.worldObj.rand.nextGaussian() * 0.02D;
        double motionZ = theEntity.worldObj.rand.nextGaussian() * 0.02D;
        EntityFX particleMysterious = new EntityParticleFXPinkSparkle(theEntity.worldObj, theEntity.posX + theEntity.worldObj.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width,
                theEntity.posY + 0.5D + theEntity.worldObj.rand.nextFloat() * theEntity.height, theEntity.posZ + theEntity.worldObj.rand.nextFloat() * theEntity.width
                        * 2.0F - theEntity.width, motionX, motionY, motionZ);
        Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {

        setupSphere();
        RenderingRegistry.addNewArmourRendererPrefix("5");
        MinecraftForge.EVENT_BUS.register(new PopularEventHandler());
    }

    private void setupSphere()
    {
        Sphere sphere = new Sphere();
        //Set up parameters that are common to both outside and inside.

        //GLU_FILL as a solid.
        sphere.setDrawStyle(GLU.GLU_FILL);
        //GLU_SMOOTH will try to smoothly apply lighting
        sphere.setNormals(GLU.GLU_SMOOTH);

        //First make the call list for the outside of the sphere
        sphere.setOrientation(GLU.GLU_OUTSIDE);

        sphereIdOutside = GL11.glGenLists(1);
        //Create a new list to hold our sphere data.
        GL11.glNewList(sphereIdOutside, GL11.GL_COMPILE);
        //binds the texture
        ResourceLocation rL = new ResourceLocation("popular:textures/entities/PinkBeam.png");
        Minecraft.getMinecraft().getTextureManager().bindTexture(rL);
        //The drawing the sphere is automatically doing is getting added to our list. Careful, the last 2 variables
        //control the detail, but have a massive impact on performance. 32x32 is a good balance on my machine.s
        sphere.draw(0.5F, 48, 48);
        GL11.glEndList();

        //Now make the call list for the inside of the sphere
        sphere.setOrientation(GLU.GLU_INSIDE);
        sphereIdInside = GL11.glGenLists(1);
        //Create a new list to hold our sphere data.
        GL11.glNewList(sphereIdInside, GL11.GL_COMPILE);
        Minecraft.getMinecraft().getTextureManager().bindTexture(rL);
        sphere.draw(0.5F, 48, 48);
        GL11.glEndList();
    }

}
