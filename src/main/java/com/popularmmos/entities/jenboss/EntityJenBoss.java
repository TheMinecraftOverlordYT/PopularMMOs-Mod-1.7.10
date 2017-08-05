package com.popularmmos.entities.jenboss;

import com.popularmmos.entities.jenboss.ai.AISwordStrike;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityJenBoss extends EntityMob implements IBossDisplayData, IAnimatedEntity
{
    public int animTick;
    private int animID;
    public int ticksAlive;

    public EntityJenBoss(World world)
    {
        super(world);
        setSize(3.4F, 8.2F);
        isImmuneToFire = true;

        tasks.addTask(1, new AISwordStrike(this));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1200F);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(.002323D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(13F);
    }

    public void onLivingUpdate()
    {
        ticksAlive = ticksExisted;

        if(this.getAttackTarget() != null && this.animID == 0)
            switch(this.rand.nextInt(3))
            {
                case 0:
                    this.setAnimID(1);
                    AnimationAPI.sendAnimPacket(this, 1);
                    System.out.println("SwordStrike");
                    break;

//                case 1:
//                    this.setAnimID(2);
//                    AnimationAPI.sendAnimPacket(this, 2);
//                    System.out.println("Small Weight");
//                    break;
//
//                case 2:
//                    this.setAnimID(3);
//                    AnimationAPI.sendAnimPacket(this,3);
//                    System.out.println("Large Weight");
//                    break;

                default:
                    break;
            }

        if(this.getAttackTarget() != null)
        {
            this.getLookHelper().setLookPositionWithEntity(this.getAttackTarget(), 10F, 30F);
        }

        Entity entity = this.getAttackTarget();

        if (entity != null)
        {
            double d0 = entity.posX - this.posX;
            double d1 = entity.posZ - this.posZ;
            double d3 = d0 * d0 + d1 * d1;
            if ((d3 > 1.0D) && (this.animTick == 0))
            {
                double d5 = MathHelper.sqrt_double(d3);
                this.motionX += d0 / d5 * 0.0625D - this.motionX;
                this.motionZ += d1 / d5 * 0.0625D - this.motionZ;
            }
        }


    }

    public boolean isAIEnabled()
    {
        return true;
    }

    public float getShadowSize() {
        return this.height / 8F;
    }

    @Override
    public void setAnimID(int id) {
        animID = id;
    }

    @Override
    public void setAnimTick(int tick) {
        animTick = tick;
    }

    @Override
    public int getAnimID() {
        return animID;
    }

    @Override
    public int getAnimTick() {
        return animTick;
    }
}
