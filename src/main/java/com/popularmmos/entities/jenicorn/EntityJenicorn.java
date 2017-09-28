package com.popularmmos.entities.jenicorn;

import com.popularmmos.main.MMOs;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

public class EntityJenicorn extends EntityAnimal implements IBossDisplayData
{

    private int flyTimer, cooldownTimer;

    public EntityJenicorn(World p_i1689_1_)
    {
        super(p_i1689_1_);
        this.setSize(5F, 5F);
        this.getNavigator().setAvoidsWater(false);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
    }

    protected void updateAITasks()
    {
        super.updateAITasks();
    }

    @Override
    public double getMountedYOffset()
    {
        return super.getMountedYOffset() + .8;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.horse.hit";
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.horse.idle";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.horse.death";
    }

    /**
     * Moves the entity based on the specified heading.  Args: strafe, forward
     */
    public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
    {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase)
        {
            this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
            this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
            p_70612_1_ = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
            p_70612_2_ = ((EntityLivingBase)this.riddenByEntity).moveForward;

            if (p_70612_2_ <= 0.0F)
            {
                p_70612_2_ *= 0.25F;
            }

            if (this.onGround)
            {
                if (this.isPotionActive(Potion.jump))
                {
                    this.motionY += (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
                }

                this.isAirBorne = true;

                if (p_70612_2_ > 0.0F)
                {
                    float f2 = MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F);
                    float f3 = MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F);
                    this.motionX += (double)(-0.4F * f2);
                    this.motionZ += (double)(0.4F * f3 );
                    if(this.ticksExisted % 5 == 0)
                        this.playSound("mob.horse.jump", 0.4F, 1.0F);
                }

                net.minecraftforge.common.ForgeHooks.onLivingJump(this);
            }

            this.stepHeight = 3.0F;
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

            if (!this.worldObj.isRemote)
            {
                this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
                super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
            }

            this.prevLimbSwingAmount = this.limbSwingAmount;
            double d1 = this.posX - this.prevPosX;
            double d0 = this.posZ - this.prevPosZ;
            float f4 = MathHelper.sqrt_double(d1 * d1 + d0 * d0) * 4.0F;

            if (f4 > 1.0F)
            {
                f4 = 1.0F;
            }

            this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
        }

        else
        {
            this.stepHeight = 0.5F;
            this.jumpMovementFactor = 0.02F;
            super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
        }

        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.9D;
        }
        if(this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer)
        {
            if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && flyTimer <= 75 && cooldownTimer == 0)
            {
                flyTimer++;
                this.motionY += .15F;
            }
            if(flyTimer == 75)
            {
                flyTimer = 0;
                cooldownTimer = 100;
            }
            if(cooldownTimer <= 100 && cooldownTimer > 0)
            {
                cooldownTimer--;
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_MINUS))
            {
                this.motionY -= .5F;
            }

            if(ticksExisted % 19 == 0 && (motionY < .1 || motionY > -.1) && motionY < .1 && motionY > -.1)
            {
                this.playSound("popular:WingFlap", 1F, 1F);
            }

        }
    }

    public EntityLiving getJenicorn()
    {
        return this;
    }

    public int getFlyTimer()
    {
        return flyTimer;
    }

    public int getCooldownTimer()
    {
        return cooldownTimer;
    }

    public void fall(float distance)
    {}

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();
        if(itemstack == null)
        {
            if (this.riddenByEntity == null) {
                player.mountEntity(this);
                player.triggerAchievement(MMOs.pixelsus);
                return true;
            }
            if (this.riddenByEntity != null) {

                player.dismountEntity(this);
                return true;
            }
            return true;
        }
        return true;
    }


    @Override
    public EntityAgeable createChild(EntityAgeable e)
    {
        return null;
    }

}
