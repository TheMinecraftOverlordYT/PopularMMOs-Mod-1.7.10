package com.popularmmos.entities.jenboss.ai;

import com.popularmmos.entities.jenboss.EntityJenBoss;
import com.popularmmos.entities.jenboss.subsidiaries.beam.EntityBeam;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
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
                EntityBeam entityBeam = new EntityBeam(entity.worldObj, entity);
                double d0 = attackTarget.posX - entity.posX;
                double d1 = attackTarget.posY + (double)attackTarget.getEyeHeight() - 1.100000023841858D - entityBeam.posY;
                double d2 = attackTarget.posZ - entity.posZ;
                float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
                entityBeam.setThrowableHeading(d0, d1 + (double)f1, d2, 1.6F, 12.0F);
               // entity.playSound("popular:PatWeightThrow", 1.0F, 1.0F / (entity.getRNG().nextFloat() * 0.4F + 0.8F));
                entity.worldObj.spawnEntityInWorld(entityBeam);
        }

        if(entity.getAnimTick() > 50)
            entity.setAnimID(0);
    }

}
