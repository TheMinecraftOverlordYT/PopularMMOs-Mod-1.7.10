package com.popularmmos.entities.jenboss.subsidiaries.beam;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * BeaconBeam - Undefined
 * Created using Tabula 4.1.1
 */
public class ModelBeam extends ModelBase
{
    public ModelRenderer BeaconBeam;

    public ModelBeam() {
        this.textureWidth = 508;
        this.textureHeight = 508;
        this.BeaconBeam = new ModelRenderer(this, 256, 0);
        this.BeaconBeam.setRotationPoint(1.0F, 16.0F, -18.0F);
        this.BeaconBeam.addBox(0.0F, -962.0F, 0.0F, 16, 984, 16, -2.5F);
        this.setRotateAngle(BeaconBeam, 1.5707963267948966F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.BeaconBeam.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
    {
        this.BeaconBeam.rotateAngleY = p_78087_4_ / (float)(180 / Math.PI);
    }

}
