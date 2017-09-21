package com.popularmmos.entities.jenboss;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


public class RenderJenBoss extends RenderLiving
{
    private Minecraft mc;
    private static final ResourceLocation mobTextures = new ResourceLocation("popular:textures/entities/JenBoss.png");
    private static final ResourceLocation beamTextures = new ResourceLocation("popular:textures/entities/PinkBeam.png");

    public ModelJenBoss jenBoss;
    private EntityJenBoss entityJen;

    public RenderJenBoss(ModelBase par1ModelBase, float par2) {
        super(par1ModelBase, par2);
        this.jenBoss = (ModelJenBoss)super.mainModel;
        this.setRenderPassModel(this.jenBoss);
    }

    protected ResourceLocation getEntityTexture(EntityJenBoss entity)
    {
        return mobTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntityJenBoss)entity);
    }

    protected void rotateCorpse(EntityJenBoss p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        super.rotateCorpse(p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
        GL11.glTranslatef(0F, .8F, 0F);
    }

    protected void rotateCorpse(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        this.rotateCorpse((EntityJenBoss) p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    public void doRender(EntityJenBoss p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        BossStatus.setBossStatus(p_76986_1_, true);
        super.doRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
        Tessellator tessellator = Tessellator.instance;
        this.bindTexture(beamTextures);
        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10497.0F);
        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10497.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDepthMask(true);
        OpenGlHelper.glBlendFunc(770, 1, 1, 0);
        float f2 = (float)p_76986_1_.worldObj.getTotalWorldTime() + p_76986_8_;
        float f3 = -f2 * 0.2F - (float) MathHelper.floor_float(-f2 * 0.1F);
        byte b0 = 1;
        double d3 = (double)f2 * 0.025D * (1.0D - (double)(b0 & 1) * 2.5D);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA(255, 255, 255, 32);
        double d5 = (double)b0 * 0.2D;
        double d7 = 0.5D + Math.cos(d3 + 2.356194490192345D) * d5;
        double d9 = 0.5D + Math.sin(d3 + 2.356194490192345D) * d5;
        double d11 = 0.5D + Math.cos(d3 + (Math.PI / 4D)) * d5;
        double d13 = 0.5D + Math.sin(d3 + (Math.PI / 4D)) * d5;
        double d15 = 0.5D + Math.cos(d3 + 3.9269908169872414D) * d5;
        double d17 = 0.5D + Math.sin(d3 + 3.9269908169872414D) * d5;
        double d19 = 0.5D + Math.cos(d3 + 5.497787143782138D) * d5;
        double d21 = 0.5D + Math.sin(d3 + 5.497787143782138D) * d5;
        double d23 = (double)(256.0F);
        double d25 = 0.0D;
        double d27 = 1.0D;
        double d28 = (double)(-1.0F + f3);
        double d29 = (double)(256.0F) * (0.5D / d5) + d28;
        tessellator.addVertexWithUV(p_76986_2_ + d7, p_76986_4_ + d23, p_76986_6_ + d9, d27, d29);
        tessellator.addVertexWithUV(p_76986_2_ + d7, p_76986_4_, p_76986_6_ + d9, d27, d28);
        tessellator.addVertexWithUV(p_76986_2_ + d11, p_76986_4_, p_76986_6_ + d13, d25, d28);
        tessellator.addVertexWithUV(p_76986_2_ + d11, p_76986_4_ + d23, p_76986_6_ + d13, d25, d29);
        tessellator.addVertexWithUV(p_76986_2_ + d19, p_76986_4_ + d23, p_76986_6_ + d21, d27, d29);
        tessellator.addVertexWithUV(p_76986_2_ + d19, p_76986_4_, p_76986_6_ + d21, d27, d28);
        tessellator.addVertexWithUV(p_76986_2_ + d15, p_76986_4_, p_76986_6_ + d17, d25, d28);
        tessellator.addVertexWithUV(p_76986_2_ + d15, p_76986_4_ + d23, p_76986_6_ + d17, d25, d29);
        tessellator.addVertexWithUV(p_76986_2_ + d11, p_76986_4_ + d23, p_76986_6_ + d13, d27, d29);
        tessellator.addVertexWithUV(p_76986_2_ + d11, p_76986_4_, p_76986_6_ + d13, d27, d28);
        tessellator.addVertexWithUV(p_76986_2_ + d19, p_76986_4_, p_76986_6_ + d21, d25, d28);
        tessellator.addVertexWithUV(p_76986_2_ + d19, p_76986_4_ + d23, p_76986_6_ + d21, d25, d29);
        tessellator.addVertexWithUV(p_76986_2_ + d15, p_76986_4_ + d23, p_76986_6_ + d17, d27, d29);
        tessellator.addVertexWithUV(p_76986_2_ + d15, p_76986_4_, p_76986_6_ + d17, d27, d28);
        tessellator.addVertexWithUV(p_76986_2_ + d7, p_76986_4_, p_76986_6_ + d9, d25, d28);
        tessellator.addVertexWithUV(p_76986_2_ + d7, p_76986_4_ + d23, p_76986_6_ + d9, d25, d29);
        tessellator.draw();
        GL11.glEnable(GL11.GL_BLEND);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glDepthMask(false);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA(255, 255, 255, 32);
        double d30 = 0.2D;
        double d4 = 0.2D;
        double d6 = 0.8D;
        double d8 = 0.2D;
        double d10 = 0.2D;
        double d12 = 0.8D;
        double d14 = 0.8D;
        double d16 = 0.8D;
        double d18 = (double)(256.0F);
        double d20 = 0.0D;
        double d22 = 1.0D;
        double d24 = (double)(-1.0F + f3);
        double d26 = (double)(256.0F) + d24;
        tessellator.addVertexWithUV(p_76986_2_ + d30, p_76986_4_ + d18, p_76986_6_ + d4, d22, d26);
        tessellator.addVertexWithUV(p_76986_2_ + d30, p_76986_4_, p_76986_6_ + d4, d22, d24);
        tessellator.addVertexWithUV(p_76986_2_ + d6, p_76986_4_, p_76986_6_ + d8, d20, d24);
        tessellator.addVertexWithUV(p_76986_2_ + d6, p_76986_4_ + d18, p_76986_6_ + d8, d20, d26);
        tessellator.addVertexWithUV(p_76986_2_ + d14, p_76986_4_ + d18, p_76986_6_ + d16, d22, d26);
        tessellator.addVertexWithUV(p_76986_2_ + d14, p_76986_4_, p_76986_6_ + d16, d22, d24);
        tessellator.addVertexWithUV(p_76986_2_ + d10, p_76986_4_, p_76986_6_ + d12, d20, d24);
        tessellator.addVertexWithUV(p_76986_2_ + d10, p_76986_4_ + d18, p_76986_6_ + d12, d20, d26);
        tessellator.addVertexWithUV(p_76986_2_ + d6, p_76986_4_ + d18, p_76986_6_ + d8, d22, d26);
        tessellator.addVertexWithUV(p_76986_2_ + d6, p_76986_4_, p_76986_6_ + d8, d22, d24);
        tessellator.addVertexWithUV(p_76986_2_ + d14, p_76986_4_, p_76986_6_ + d16, d20, d24);
        tessellator.addVertexWithUV(p_76986_2_ + d14, p_76986_4_ + d18, p_76986_6_ + d16, d20, d26);
        tessellator.addVertexWithUV(p_76986_2_ + d10, p_76986_4_ + d18, p_76986_6_ + d12, d22, d26);
        tessellator.addVertexWithUV(p_76986_2_ + d10, p_76986_4_, p_76986_6_ + d12, d22, d24);
        tessellator.addVertexWithUV(p_76986_2_ + d30, p_76986_4_, p_76986_6_ + d4, d20, d24);
        tessellator.addVertexWithUV(p_76986_2_ + d30, p_76986_4_ + d18, p_76986_6_ + d4, d20, d26);
        tessellator.draw();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDepthMask(true);
    }
    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probability, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityJenBoss)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);

    }
    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probability, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityJenBoss)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);

    }
    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probability, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityJenBoss)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);


    }

}
