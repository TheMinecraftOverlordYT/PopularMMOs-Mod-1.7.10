package com.popularmmos.entities.pat.largeweight;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelLargeWeight - Undefined
 * Created using Tabula 5.1.0
 */
public class ModelLargeWeight extends ModelBase {
    public ModelRenderer BenchWeightBar;
    public ModelRenderer BenchWeightL1;
    public ModelRenderer BenchWeightR1;
    public ModelRenderer BenchWeightL4;
    public ModelRenderer BenchWeightR4;
    public ModelRenderer BenchWeightL2;
    public ModelRenderer BenchWeightL3;
    public ModelRenderer BenchWeightR2;
    public ModelRenderer BenchWeightR3;
    public ModelRenderer BenchWeightL5;
    public ModelRenderer BenchWeightL6;
    public ModelRenderer BenchWeightR5;
    public ModelRenderer BenchWeightR6;

    public ModelLargeWeight() {
        this.textureWidth = 256;
        this.textureHeight = 126;
        this.BenchWeightL5 = new ModelRenderer(this, 50, 7);
        this.BenchWeightL5.setRotationPoint(0.0F, -2.0F, 4.0F);
        this.BenchWeightL5.addBox(0.0F, 0.0F, 0.0F, 2, 20, 9, 0.0F);
        this.BenchWeightL6 = new ModelRenderer(this, 50, 75);
        this.BenchWeightL6.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.BenchWeightL6.addBox(0.0F, 0.0F, 0.0F, 2, 9, 19, 0.0F);
        this.BenchWeightR4 = new ModelRenderer(this, 50, 39);
        this.BenchWeightR4.setRotationPoint(57.0F, -6.0F, -9.0F);
        this.BenchWeightR4.addBox(0.0F, 0.0F, 0.0F, 2, 15, 16, 0.0F);
        this.BenchWeightL2 = new ModelRenderer(this, 1, 86);
        this.BenchWeightL2.setRotationPoint(-1.0F, -24.0F, -29.0F);
        this.BenchWeightL2.addBox(0.0F, -4.0F, 9.0F, 2, 24, 12, 0.0F);
        this.BenchWeightL3 = new ModelRenderer(this, 1, 49);
        this.BenchWeightL3.setRotationPoint(-1.0F, -21.0F, -26.0F);
        this.BenchWeightL3.addBox(0.0F, 0.0F, 0.0F, 2, 11, 24, 0.0F);
        this.BenchWeightR1 = new ModelRenderer(this, 1, 7);
        this.BenchWeightR1.setRotationPoint(54.0F, 17.0F, 13.0F);
        this.BenchWeightR1.addBox(-1.0F, -26.0F, -24.0F, 2, 20, 20, 0.0F);
        this.BenchWeightL1 = new ModelRenderer(this, 1, 7);
        this.BenchWeightL1.setRotationPoint(8.0F, 17.0F, 13.0F);
        this.BenchWeightL1.addBox(-1.0F, -26.0F, -24.0F, 2, 20, 20, 0.0F);
        this.BenchWeightR3 = new ModelRenderer(this, 1, 49);
        this.BenchWeightR3.setRotationPoint(-1.0F, -21.0F, -26.0F);
        this.BenchWeightR3.addBox(0.0F, 0.0F, 0.0F, 2, 11, 24, 0.0F);
        this.BenchWeightR6 = new ModelRenderer(this, 50, 75);
        this.BenchWeightR6.setRotationPoint(0.0F, 3.0F, -2.0F);
        this.BenchWeightR6.addBox(0.0F, 0.0F, 0.0F, 2, 9, 20, 0.0F);
        this.BenchWeightL4 = new ModelRenderer(this, 50, 39);
        this.BenchWeightL4.setRotationPoint(3.0F, -6.0F, -9.0F);
        this.BenchWeightL4.addBox(0.0F, 0.0F, 0.0F, 2, 15, 16, 0.0F);
        this.BenchWeightR2 = new ModelRenderer(this, 1, 86);
        this.BenchWeightR2.setRotationPoint(-1.0F, -24.0F, -29.0F);
        this.BenchWeightR2.addBox(0.0F, -4.0F, 9.0F, 2, 24, 12, 0.0F);
        this.BenchWeightR5 = new ModelRenderer(this, 50, 7);
        this.BenchWeightR5.setRotationPoint(0.0F, -2.0F, 4.0F);
        this.BenchWeightR5.addBox(0.0F, 0.0F, 0.0F, 2, 20, 9, 0.0F);
        this.BenchWeightBar = new ModelRenderer(this, 0, 0);
        this.BenchWeightBar.setRotationPoint(-31.0F, 11.0F, 0.0F);
        this.BenchWeightBar.addBox(0.0F, 0.0F, -2.0F, 61, 3, 3, 0.0F);
        this.BenchWeightL4.addChild(this.BenchWeightL5);
        this.BenchWeightL4.addChild(this.BenchWeightL6);
        this.BenchWeightBar.addChild(this.BenchWeightR4);
        this.BenchWeightL1.addChild(this.BenchWeightL2);
        this.BenchWeightL1.addChild(this.BenchWeightL3);
        this.BenchWeightBar.addChild(this.BenchWeightR1);
        this.BenchWeightBar.addChild(this.BenchWeightL1);
        this.BenchWeightR1.addChild(this.BenchWeightR3);
        this.BenchWeightR4.addChild(this.BenchWeightR6);
        this.BenchWeightBar.addChild(this.BenchWeightL4);
        this.BenchWeightR1.addChild(this.BenchWeightR2);
        this.BenchWeightR4.addChild(this.BenchWeightR5);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.BenchWeightBar.render(f5);
    }

    public void render(float f)
    {
        this.BenchWeightBar.render(f);
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
