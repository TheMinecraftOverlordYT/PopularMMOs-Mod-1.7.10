package com.popularmmos.entities.jenboss.subsidiaries.beam;

import com.popularmmos.PopularDamageSources;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBeam extends EntityThrowable
{
    public EntityBeam(World p_i1776_1_)
    {
        super(p_i1776_1_);
        this.setSize(1F, 1F);
    }

    public EntityBeam(World p_i1774_1_, EntityLivingBase p_i1774_2_)
    {
        super(p_i1774_1_, p_i1774_2_);
    }

    public EntityBeam(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_)
    {
        super(p_i1775_1_, p_i1775_2_, p_i1775_4_, p_i1775_6_);
    }

    protected float getGravityVelocity()
    {
        return 0.0F;
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition p_70184_1_)
    {
        if (p_70184_1_.entityHit != null)
        {
            byte b0 = 10;

            p_70184_1_.entityHit.attackEntityFrom(PopularDamageSources.beam(this, this.getThrower()), (float)b0);
        }

        if (!this.worldObj.isRemote || this.ticksExisted >=100)
        {
            this.setDead();
        }
    }

}
