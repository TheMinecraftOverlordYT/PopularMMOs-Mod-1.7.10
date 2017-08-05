package com.popularmmos.entities.pat;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderPat extends RenderLiving
{

    private static final ResourceLocation largeWeight = new ResourceLocation("popular:textures/entities/PatLargeWeight.png");
    private static final ResourceLocation mobTextures = new ResourceLocation("popular:textures/entities/PatWeightless.png");
    private static final ResourceLocation smallWeight = new ResourceLocation("popular:textures/entities/PatSmallWeight.png");

    public ModelPat popularModel;

    public RenderPat(ModelBase par1ModelBase, float par2) {
        super(par1ModelBase, par2);
        this.popularModel = (ModelPat) super.mainModel;
        this.setRenderPassModel(this.popularModel);
    }

    protected void rotateCorpse(EntityPat p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        super.rotateCorpse(p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
        GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(.8F, .8F, .8F);
    }

    protected void rotateCorpse(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        this.rotateCorpse((EntityPat) p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    protected ResourceLocation getEntityTexture(EntityPat entity)
    {
        return (entity.getAnimID() == 3 && entity.animTick < 50) ? largeWeight : mobTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntityPat)entity);
    }

    public void doRender(EntityPat p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        BossStatus.setBossStatus(p_76986_1_, true);
        super.doRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probability, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityPat)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probability, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityPat)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probability, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityPat)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

}
