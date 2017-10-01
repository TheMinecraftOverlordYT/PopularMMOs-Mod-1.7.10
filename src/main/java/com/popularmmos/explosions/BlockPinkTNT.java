package com.popularmmos.explosions;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockTNT;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockPinkTNT extends BlockTNT
{

    private IIcon icon;
    private IIcon icon2;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon("popular:textures/pinktnt_side.png");
        this.icon = p_149651_1_.registerIcon("popular:textures/pinktnt_top.png");
        this.icon2 = p_149651_1_.registerIcon("popular:textures/pinktnt_bottom.png");
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        return side == 0 ? this.icon2 : (side == 1 ? this.icon : this.blockIcon);
    }

    /**
     * Called upon the block being destroyed by an explosion
     */
    @Override
    public void onBlockDestroyedByExplosion(World p_149723_1_, int p_149723_2_, int p_149723_3_, int p_149723_4_, Explosion p_149723_5_)
    {
        if (!p_149723_1_.isRemote)
        {
            EntityPinkTNTPrimed entitypinktntprimed = new EntityPinkTNTPrimed(p_149723_1_, (double)((float)p_149723_2_ + 0.5F), (double)((float)p_149723_3_ + 0.5F), (double)((float)p_149723_4_ + 0.5F), p_149723_5_.getExplosivePlacedBy());
            entitypinktntprimed.fuse = p_149723_1_.rand.nextInt(entitypinktntprimed.fuse / 4) + entitypinktntprimed.fuse / 8;
            p_149723_1_.spawnEntityInWorld(entitypinktntprimed);
        }
    }


}
