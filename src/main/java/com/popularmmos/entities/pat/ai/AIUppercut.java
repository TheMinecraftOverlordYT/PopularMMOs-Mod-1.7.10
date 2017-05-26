package com.popularmmos.entities.pat.ai;

import com.popularmmos.PopularDamageSources;
import com.popularmmos.entities.pat.EntityPat;
import net.minecraft.entity.EntityLivingBase;
import thehippomaster.AnimationAPI.AIAnimation;

public class AIUppercut extends AIAnimation {

    private EntityPat entity;
    private EntityLivingBase attackTarget;

    public AIUppercut(EntityPat pat)
    {
        super(pat);
        entity = pat;
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
        return 30;
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
        if(entity.getAnimTick() < 14 && attackTarget != null)
            entity.getLookHelper().setLookPositionWithEntity(attackTarget, 20F,20F);
        if(entity.getAnimTick() == 5 && attackTarget != null)
        {
            attackTarget.attackEntityFrom(PopularDamageSources.upperCut, 5);
            attackTarget.motionY += 0.8000000059604645D;
        }

            if(entity.getAnimTick() > 30)
            entity.setAnimID(0);
    }

}
