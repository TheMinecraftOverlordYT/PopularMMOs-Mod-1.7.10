package com.popularmmos.entities.pat.largeweight;

import com.popularmmos.PopularDamageSources;
import com.popularmmos.entities.pat.EntityPat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityLargeWeight extends EntityThrowable
{
    private static final String __OBFID = "CL_00001728";
    private static ResourceLocation texture = new ResourceLocation("popular:textures/models/largeWeight.png");


    public EntityLargeWeight(World p_i1773_1_)
    {
        super(p_i1773_1_);
        this.setSize(5, 2);
    }

    public EntityLargeWeight(World p_i1774_1_, EntityLivingBase p_i1774_2_)
    {
        super(p_i1774_1_, p_i1774_2_);

    }

    public EntityLargeWeight(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_)
    {
        super(p_i1775_1_, p_i1775_2_, p_i1775_4_, p_i1775_6_);
    }

    protected ResourceLocation getTexture()
    {
        return this.texture;
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition p_70184_1_)
    {
        if (p_70184_1_.entityHit != null)
        {
            byte b0 = 20;

            if (p_70184_1_.entityHit instanceof EntityPat)
            {
                b0 = 0;
            }

            p_70184_1_.entityHit.attackEntityFrom(PopularDamageSources.largeWeight(this, this.getThrower()), (float)b0);
        }

        for (int i = 0; i < 8; ++i)
        {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}