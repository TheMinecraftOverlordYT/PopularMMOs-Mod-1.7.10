package com.popularmmos.items.largeWeight;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemLargeWeight extends ItemSword {

    public ItemLargeWeight(ToolMaterial tm)
    {
        super(tm);
    }

    private EntityPlayer player;

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int i, boolean b)
    {
        if(!world.isRemote)
        {
            if(entity instanceof EntityPlayer) {

                player = (EntityPlayer) entity;

                if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemLargeWeight)
                {

                    player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1, 2));

                }
            }
        }
    }
}
