package com.popularmmos.entities.pat.smallweight;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ItemSmallWeight - Undefined
 * Created using Tabula 5.1.0
 */
public class ModelSmallWeight extends ModelBase {
    public ModelRenderer WeightBar;
    public ModelRenderer WeightSideL;
    public ModelRenderer WeightSideR;

    public ModelSmallWeight() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.WeightSideL = new ModelRenderer(this, 0, 0);
        this.WeightSideL.setRotationPoint(-6.0F, 1.6F, -6.0F);
        this.WeightSideL.addBox(0.0F, 2.0F, -5.0F, 6, 8, 8, 0.0F);
        this.setRotateAngle(WeightSideL, 0.742986662573986F, 0.0F, 0.0F);
        this.WeightSideR = new ModelRenderer(this, 0, 0);
        this.WeightSideR.setRotationPoint(20.0F, 1.0F, -5.8F);
        this.WeightSideR.addBox(0.0F, 2.0F, -5.0F, 6, 8, 8, 0.0F);
        this.setRotateAngle(WeightSideR, 0.7853981633974483F, 0.0F, 0.0F);
        this.WeightBar = new ModelRenderer(this, 0, 22);
        this.WeightBar.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WeightBar.addBox(0.0F, 4.0F, -5.0F, 20, 5, 5, 0.0F);
        this.WeightBar.addChild(this.WeightSideL);
        this.WeightBar.addChild(this.WeightSideR);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.WeightBar.render(f5);
    }

    public void render(float f)
    {
        this.WeightBar.render(f);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
