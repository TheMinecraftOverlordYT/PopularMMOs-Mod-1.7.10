package com.popularmmos.items.smallWeight;

import com.popularmmos.entities.jenboss.subsidiaries.lightningPink.EntityLightningPink;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemSmallWeight extends ItemSword {

    public ItemSmallWeight(ToolMaterial tm)
    {
        super(tm);
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        if (!p_77659_3_.capabilities.isCreativeMode)
        {
            --p_77659_1_.stackSize;
        }

        p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!p_77659_2_.isRemote)
        {
            p_77659_2_.addWeatherEffect(new EntityLightningPink(p_77659_2_, p_77659_3_.posX, p_77659_3_.posY, p_77659_3_.posZ, 0F, .4F, .7F));
        }

        return p_77659_1_;
    }

}
