package com.popularmmos.particles;

import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;


public class EntityParticleFXPinkSparkle extends EntitySmokeFX
{
    public static ResourceLocation texture = new ResourceLocation("popular:textures/PopularParticles.png");


    public EntityParticleFXPinkSparkle(World p_i1209_1_, double p_i1209_2_, double p_i1209_4_, double p_i1209_6_, double p_i1209_8_, double p_i1209_10_, double p_i1209_12_)
    {
        super(p_i1209_1_, p_i1209_2_, p_i1209_4_, p_i1209_6_, p_i1209_8_, p_i1209_10_, p_i1209_12_);
        this.particleMaxAge = 20;
        this.particleRed = 1F;
        this.particleGreen = 0.07F;
        this.particleBlue = 0.57F;
        this.setParticleTextureIndex(6);
        this.noClip = true;
    }

    public void renderParticle(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_)
    {
        super.renderParticle(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
    }


}
