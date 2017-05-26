package com.popularmmos.generation;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class PopularWorldGen {

	public static void Popular()
	{
		initWorldGen();
	}
	public static void initWorldGen()
	{
		registerWorldGen(new PopularGen(), 1);
		registerWorldGen(new PopularStructureGen(), 0);
	}

	public static void registerWorldGen(IWorldGenerator worldGenClass, int weightedProbability)
	{
		GameRegistry.registerWorldGenerator(new PopularGen(), 1);
		GameRegistry.registerWorldGenerator(new PopularStructureGen(), 0);
	}

}
