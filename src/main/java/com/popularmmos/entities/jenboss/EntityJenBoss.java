package com.popularmmos.entities.jenboss;

import com.popularmmos.entities.jenboss.ai.AIBeam;
import com.popularmmos.entities.jenboss.ai.AIJenLargeThrow;
import com.popularmmos.entities.jenboss.ai.AISwordStrike;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityJenBoss extends EntityMob implements IBossDisplayData, IAnimatedEntity, IMob
{
    public  EntityLivingBase attackTarget;
    public int animTick;
    public int deathTicks;
    private int animID;
    private Minecraft mc;
    public int ticksAlive;
    private final int index = 20;

    public EntityJenBoss(World world)
    {
        super(world);
        this.setHealth(this.getMaxHealth());
        this.setSize(3.4F, 8.2F);
        this.isImmuneToFire = true;

        tasks.addTask(1, new AISwordStrike(this));
        tasks.addTask(1, new AIBeam(this));
        tasks.addTask(1, new AIJenLargeThrow(this));
        tasks.addTask(2, new EntityAISwimming(this));
        tasks.addTask(3, new EntityAIWander(this, .8D));
        tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6F));
        tasks.addTask(5, new EntityAILookIdle(this));
        targetTasks.addTask(6, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 64, true));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 32F));
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(index, -1);
    }

    public void setObject(int newValue)
    {
        this.dataWatcher.updateObject(index, newValue);
    }

    public int getObject()
    {
        return this.dataWatcher.getWatchableObjectInt(index);
    }

    public void setAttackTarget(EntityLivingBase p_70624_1_)
    {
        this.attackTarget = p_70624_1_;
        ForgeHooks.onLivingSetAttackTarget(this, p_70624_1_);
        if(p_70624_1_ != null)
        this.setObject(p_70624_1_.getEntityId());
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1200F);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(13F);
    }

    public boolean isAIEnabled() {
        return true;
    }

    public float getShadowSize() {
        return this.height / 8F;
    }

//    protected String getHurtSound() {
//        return "popular:PatGrunt";
//    }
//
//    protected String getDeathSound() {
//        return "popular:PatDeath";
//    }

    public int getTotalArmorValue() {
        return 2;
    }

//    protected void dropFewItems(boolean b, int amt)
//    {
//        int essenceAmt;
//        essenceAmt = ThreadLocalRandom.current().nextInt(30, 35);
//        this.dropItem(PopularItems.largeWeight, 1);
//        this.dropItem(PopularItems.furiousEssence, essenceAmt);
//
//        if (!this.worldObj.isRemote)
//        {
//            Iterator iterator = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(50.0D, 100.0D, 50.0D)).iterator();
//
//            while (iterator.hasNext())
//            {
//                EntityPlayer entityplayer = (EntityPlayer)iterator.next();
//                entityplayer.triggerAchievement(PopularMMOs.popularmmos);
//            }
//        }
//    }

    protected void despawnEntity() {
        this.entityAge = 0;
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float f) {
        return 12128880;
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

    public void onUpdate() {
        super.onUpdate();
        if (animID != 0)
            animTick++;
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        if(worldObj.getEntityByID(getObject()) != null && this.animID == 0)
            switch(this.rand.nextInt(3))
            {
                case 0:
                    this.setAnimID(5);
                    AnimationAPI.sendAnimPacket(this, 1);
                    System.out.println("SwordStrike");
                    break;

                case 1:
                    this.setAnimID(2);
                    AnimationAPI.sendAnimPacket(this, 2);
                    System.out.println("Beam");
                    break;

                case 2:
                    this.setAnimID(3);
                    AnimationAPI.sendAnimPacket(this,3);
                    System.out.println("Unknown(Exploding hearts?");
                    break;

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
                this.motionX += d0 / d5 * 0.0725D - this.motionX;
                this.motionZ += d1 / d5 * 0.0725D - this.motionZ;
            }
        }

        if(entity != null && this.getAnimID() == 1 && (this.getAnimTick() == 20 || this.getAnimTick() == 35))
        {
            double d0 = entity.posX - this.posX;
            double d1 = entity.posZ - this.posZ;
            double d3 = d0 * d0 + d1 * d1;
            if ((d3 > 1.0D) && (this.animTick == 0))
            {
                double d5 = MathHelper.sqrt_double(d3);
                this.motionX += d0 / d5 * 0.625D - this.motionX;
                this.motionZ += d1 / d5 * 0.625D - this.motionZ;
            }
        }

        this.renderYawOffset = this.rotationYaw = this.rotationYawHead;

        if(this.ticksExisted == 1)
        {
            this.playSound("popular:PatSpawn", 10F, 10F);
        }
    }

    public void onDeathUpdate()
    {
        deathTicks++;

        if(deathTicks == 200)
        {
            this.setDead();
        }
    }


}
