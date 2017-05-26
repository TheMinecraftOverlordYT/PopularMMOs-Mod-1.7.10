package com.popularmmos.items.smallWeight;

import com.popularmmos.generation.Gym;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import java.util.Random;

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

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int X, int Y, int Z, int par7, float par8, float par9, float par10)
    {
        if (!par3World.isRemote)
        {
            int direction = MathHelper.floor_double(par2EntityPlayer.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;

            if (Keyboard.isKeyDown(Keyboard.KEY_G))
            {
                new Gym().generate(par3World, new Random(),X, Y, Z);
            }
            return true;
        }
        return true;
    }
}
