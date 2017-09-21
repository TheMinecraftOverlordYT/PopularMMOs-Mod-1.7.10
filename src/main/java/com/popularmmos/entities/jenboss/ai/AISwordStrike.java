package com.popularmmos.entities.jenboss.ai;

import com.popularmmos.PopularDamageSources;
import com.popularmmos.entities.jenboss.EntityJenBoss;
import net.minecraft.entity.EntityLivingBase;
import thehippomaster.AnimationAPI.AIAnimation;

public class AISwordStrike extends AIAnimation
{
    private EntityJenBoss entity;
    private EntityLivingBase attackTarget;

    public AISwordStrike(EntityJenBoss jen)
    {
        super(jen);
        entity = jen;
        attackTarget = null;
    }

    public int getAnimID()
    {
        return 1;
    }

    public boolean isAutomatic()
    {
        return true;
    }

    public int getDuration()
    {
        return 70;
    }

    public boolean continueExecuting()
    {
        return entity.animTick > 200 ? false : super.continueExecuting();
    }

    public void startExecuting()
    {
        super.startExecuting();
        attackTarget = (EntityLivingBase)entity.worldObj.getEntityByID(entity.getObject());
    }

    public void updateTask()
    {
        if(entity.getAnimTick() < 70 && attackTarget != null)
            entity.getLookHelper().setLookPositionWithEntity(attackTarget, 10F,10F);
        if((entity.getAnimTick() == 20 || entity.getAnimTick() == 35) && attackTarget != null)
        {
            attackTarget.attackEntityFrom(PopularDamageSources.swordSlice, 10);
        }
        else if(entity.getAnimTick() == 65)
        {
            attackTarget.attackEntityFrom(PopularDamageSources.downwardsSwordSlice, 15);
        }
        if(entity.getAnimTick() > 70)
            entity.setAnimID(0);
    }

}
