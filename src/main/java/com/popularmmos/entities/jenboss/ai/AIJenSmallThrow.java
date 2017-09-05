package com.popularmmos.entities.jenboss.ai;

import com.popularmmos.entities.jenboss.EntityJenBoss;
import com.popularmmos.entities.pat.smallweight.EntitySmallWeight;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.AIAnimation;

public class AIJenSmallThrow extends AIAnimation {

    private EntityJenBoss entity;
    private EntityLivingBase attackTarget;

    public AIJenSmallThrow(EntityJenBoss pat)
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
        attackTarget = entity.getAttackTarget();
    }

    public void updateTask()
    {
        if(entity.getAnimTick() < 14 && attackTarget != null)
            entity.getLookHelper().setLookPositionWithEntity(attackTarget, 20F,20F);
        if(entity.getAnimTick() == 45 && attackTarget != null)
        {
                EntitySmallWeight entitySmallWeight = new EntitySmallWeight(entity.worldObj, entity);
                double d0 = attackTarget.posX - entity.posX;
                double d1 = attackTarget.posY + (double)attackTarget.getEyeHeight() - 1.100000023841858D - entitySmallWeight.posY;
                double d2 = attackTarget.posZ - entity.posZ;
                float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
                entitySmallWeight.setThrowableHeading(d0, d1 + (double)f1, d2, 1.6F, 12.0F);
                entity.playSound("popular:PatWeightThrow", 1.0F, 1.0F / (entity.getRNG().nextFloat() * 0.4F + 0.8F));
                entity.worldObj.spawnEntityInWorld(entitySmallWeight);
        }

        if(entity.getAnimTick() > 50)
            entity.setAnimID(0);
    }

}
