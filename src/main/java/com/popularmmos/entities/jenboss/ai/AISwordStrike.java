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
        return 90;
    }

    public boolean continueExecuting()
    {
        return entity.animTick > 30 ? false : super.continueExecuting();
    }

    public void startExecuting()
    {
        super.startExecuting();
        attackTarget = entity.getAttackTarget();
    }

    public void updateTask()
    {
        if(entity.getAnimTick() < 90 && attackTarget != null)
            entity.getLookHelper().setLookPositionWithEntity(attackTarget, 20F,20F);
        if((entity.getAnimTick() == 20 || entity.getAnimTick() == 25 || entity.getAnimTick() == 30) && attackTarget != null)
        {
            attackTarget.attackEntityFrom(PopularDamageSources.swordSlice, 5);
        }

        if(entity.getAnimTick() > 30)
            entity.setAnimID(0);
    }

}
