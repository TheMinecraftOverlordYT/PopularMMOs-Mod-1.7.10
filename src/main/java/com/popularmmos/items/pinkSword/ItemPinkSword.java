package com.popularmmos.items.pinkSword;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemSword;

public class ItemPinkSword extends ItemSword
{
    public ItemPinkSword(ToolMaterial tm)
{
    super(tm);
}

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
}
