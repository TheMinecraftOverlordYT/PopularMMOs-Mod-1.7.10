package com.popularmmos.main;

import com.popularmmos.entities.pat.EntityPat;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

import java.util.Iterator;
import java.util.List;

public class PopularEvents extends Gui
{

    private Minecraft mc = Minecraft.getMinecraft();
    private EntityPat pat;
    private static final ResourceLocation deathOverlay = new ResourceLocation("popular:textures/entities/ClosingScreenDeath.png");

    /*private Minecraft mc = Minecraft.getMinecraft();
    private EntityJenicorn pixelsus;

    public void renderFlightBar(RenderGameOverlayEvent.Pre event, int width, int height, EntityPlayer entityPlayer, World world)
    {
        pixelsus = new EntityJenicorn(world);
        System.out.println(entityPlayer.ridingEntity);
        if(entityPlayer.ridingEntity != null && entityPlayer.ridingEntity instanceof EntityJenicorn)
        {
            int flightTimer = pixelsus.getFlyTimer();
            int coolTimer = pixelsus.getCooldownTimer();
            int i = flightTimer * 10;

            if(flightTimer >= 0)
            {
                GL11.glDisable(GL11.GL_TEXTURE_2D);
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                GL11.glColor4f(0F, 0F, 0F, 0.3F);

                System.out.println(i);

                //Nitro Outline
                drawTexturedModalRect(5 - i, 16, 0, 0, 202, 12);
                GL11.glColor4f(0.0F, 1.0F, 1.0F, 0.5F);
                //Nitro Bar
                drawTexturedModalRect(6 - i, 4, 0, 0, (int) (flightTimer * 1.25F), 10);
                GL11.glColor4f(1F, 0F, 0F, 0.5F);
                GL11.glEnable(GL11.GL_TEXTURE_2D);
            }

        }

    }*/

    @SubscribeEvent
    public void popularDeathEvent(RenderGameOverlayEvent.Post e){
        int k = e.resolution.getScaledWidth();
        int l = e.resolution.getScaledHeight();
        this.mc.entityRenderer.setupOverlayRendering();
        GL11.glEnable(GL11.GL_BLEND);
        List list = mc.thePlayer.worldObj.getEntitiesWithinAABB(EntityPat.class, mc.thePlayer.boundingBox.expand(50D, 50D, 50D));
        EntityPat entityPat = null;
        double d0 = Double.MAX_VALUE;
        Iterator iterator = list.iterator();

        while(iterator.hasNext()){
            EntityPat entitypat1 = (EntityPat)iterator.next();
            double d1 = entitypat1.getDistanceSqToEntity(mc.thePlayer);
            if (d1 < d0)
            {
                d0 = d1;
                entityPat = entitypat1;
            }
        }
        this.pat = entityPat;
        if(mc.gameSettings.thirdPersonView == 0 && pat != null){
            if(pat.deathTicks > 0 && pat.deathTicks < 200){
                this.renderPopularDeath(k, l);
            }
        }
    }

    private void renderPopularDeath(int par1, int par2){
        float i = pat.getDistanceToEntity(mc.thePlayer);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        if(pat.deathTicks <= 200)
        {
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1F / i);
        }
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        this.mc.getTextureManager().bindTexture(deathOverlay);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, (double)par2, -90.0D, 0.0D, 1.0D);
        tessellator.addVertexWithUV((double)par1, (double)par2, -90.0D, 1.0D, 1.0D);
        tessellator.addVertexWithUV((double)par1, 0.0D, -90.0D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

}
