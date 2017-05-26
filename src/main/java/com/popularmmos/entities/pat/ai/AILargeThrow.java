package com.popularmmos.entities.pat.ai;

import com.popularmmos.entities.pat.EntityPat;
import com.popularmmos.entities.pat.largeweight.EntityLargeWeight;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.AIAnimation;

public class AILargeThrow extends AIAnimation {

    private EntityPat entity;
    private EntityLivingBase attackTarget;

    public AILargeThrow(EntityPat pat)
    {
        super(pat);
        entity = pat;
        attackTarget = null;
    }

    public int getAnimID()
    {
        return 3;
    }

    public boolean isAutomatic()
    {
        return true;
    }

    public int getDuration()
    {
        return 75;
    }

    public boolean continueExecuting()
    {
        return entity.animTick > 75 ? false : super.continueExecuting();
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
        if(entity.getAnimTick() == 41 && attackTarget != null)
        {
            EntityLargeWeight entityLargeWeight = new EntityLargeWeight(entity.worldObj, entity);
            double d0 = attackTarget.posX - entity.posX;
            double d1 = attackTarget.posY + (double)attackTarget.getEyeHeight() - 1.100000023841858D - entityLargeWeight.posY;
            double d2 = attackTarget.posZ - entity.posZ;
            float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
            entityLargeWeight.setThrowableHeading(d0, d1 + (double)f1, d2, 1.6F, 12.0F);
            entity.playSound("popular:PatWeightThrow", 1.0F, 1.0F / (entity.getRNG().nextFloat() * 0.4F + 0.8F));
            entity.worldObj.spawnEntityInWorld(entityLargeWeight);
        }
    }

}
