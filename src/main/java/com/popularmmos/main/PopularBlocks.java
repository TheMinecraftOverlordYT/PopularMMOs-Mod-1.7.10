package com.popularmmos.main;

import com.popularmmos.explosions.BlockPinkTNT;
import com.popularmmos.blocks.DecorationBlock;
import com.popularmmos.blocks.PinkOre;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class PopularBlocks
{
    public static void Popular()
    {
        initThings();
        registerThings();
    }

    public static Block pinkOre;
    public static Block patFace;
    public static Block pinkTNT;

    public static void initThings(){

        pinkOre = new PinkOre(Material.rock).setBlockName("pinkOre").setBlockTextureName("popular:pinkOre").setCreativeTab(PopularItems.popularTab).setHardness(3F);

        patFace = new DecorationBlock(Material.rock).setBlockName("patFace").setBlockTextureName("popular:patFace").setCreativeTab(PopularItems.popularTab).setHardness(2);

        pinkTNT = new BlockPinkTNT().setBlockName("pinkTNT").setCreativeTab(PopularItems.popularTab).setBlockTextureName("pinktnt");

    }
    public static void registerThings(){

        GameRegistry.registerBlock(pinkOre, "pinkOre");
        GameRegistry.registerBlock(patFace, "patFace");
        GameRegistry.registerBlock(pinkTNT, "pinkTNT");

    }
}
