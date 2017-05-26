package com.popularmmos.generation;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import scala.concurrent.forkjoin.ThreadLocalRandom;

import java.util.Random;

public class PopularStructureGen implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		int Xcoord = chunkX * 20 + random.nextInt(15);
		int Ycoord = ThreadLocalRandom.current().nextInt(0, 256);
		int Zcoord = chunkZ * 20 + random.nextInt(15);

		new Gym().generate(world, random, Xcoord, Ycoord, Zcoord);
		System.out.println("X: " + Xcoord + "Y: " + Ycoord + "Z: " + Zcoord);
	}
}
