package com.popularmmos.generation;

import com.popularmmos.main.PopularBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class PopularGen implements IWorldGenerator{
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
        switch(world.provider.dimensionId){

            case 1:
                generateEnd(world, rand, chunkX, chunkZ);
                break;
            case 0:
                generateOverworld(world, rand, chunkX, chunkZ);
                break;
            case -1:
                generateNether(world, rand, chunkX, chunkZ);
                break;

        }
    }
    public void generateNether(World world, Random rand, int x, int z){

    }

    public void generateOverworld(World world, Random rand, int x, int z){
        //       Block2generate, min vein size, max vein size, chance of spawning, lowest y-range, highest y-range
        generateOre(PopularBlocks.pinkOre, world, rand, x, z, 2, 10, 1, 0, 70, Blocks.stone);
    }

    public void generateEnd(World world, Random rand, int x, int z){
    }

    public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY, int maxY, Block generateIn){
        int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
        int heightRange = maxY - minY;
        WorldGenMinable gen = new WorldGenMinable(block, veinSize, generateIn);
        for(int i = 0; i < chance; i++){
            int xRand = chunkX * 16 + random.nextInt(16);
            int yRand = random.nextInt(heightRange) + minY;
            int zRand = chunkZ * 16 + random.nextInt(16);
            gen.generate(world, random, xRand, yRand, zRand);
        }
    }
}