package com.popularmmos.main;

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


    public static void initThings(){

        pinkOre = new PinkOre(Material.rock).setBlockName("pinkOre").setBlockTextureName("popular:pinkOre").setCreativeTab(PopularItems.popularTab).setHardness(3F);

        patFace = new DecorationBlock(Material.rock).setBlockName("patFace").setBlockTextureName("popular:patFace").setCreativeTab(PopularItems.popularTab).setHardness(2);

    }
    public static void registerThings(){

        GameRegistry.registerBlock(pinkOre, "topazOre");
        GameRegistry.registerBlock(patFace, "fopalOre");

    }
}
