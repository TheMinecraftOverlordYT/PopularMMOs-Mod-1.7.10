package com.popularmmos.entities.jenboss.ai;

import com.popularmmos.PopularDamageSources;
import com.popularmmos.entities.jenboss.EntityJenBoss;
import net.minecraft.entity.EntityLivingBase;
import thehippomaster.AnimationAPI.AIAnimation;

public class AIBeam extends AIAnimation {

    private EntityJenBoss entity;
    private EntityLivingBase attackTarget;

    public AIBeam(EntityJenBoss pat)
    {
        super(pat);
        entity = pat;
        attackTarget = null;
    }

    public int getAnimID()
    {
        return 2;
    }

    public boolean isAutomatic()
    {
        return true;
    }

    public int getDuration()
    {
        return 50;
    }

    public boolean continueExecuting()
    {
        return entity.animTick > 50 ? false : super.continueExecuting();
    }

    public void startExecuting()
    {
        super.startExecuting();
        attackTarget = (EntityLivingBase) entity.worldObj.getEntityByID(entity.getObject());
    }

    public void updateTask()
    {
        if(entity.getAnimTick() < 14 && attackTarget != null)
            entity.getLookHelper().setLookPositionWithEntity(attackTarget, 20F,20F);
        if(entity.getAnimTick() > 1 && attackTarget != null)
        {
                attackTarget.attackEntityFrom(PopularDamageSources.beam, .3F);
                attackTarget.hurtResistantTime = 7;
        }

        if(entity.getAnimTick() > 50)
            entity.setAnimID(0);
    }

}
