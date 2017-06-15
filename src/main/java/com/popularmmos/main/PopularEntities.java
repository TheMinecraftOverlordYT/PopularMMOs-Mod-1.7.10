package com.popularmmos.main;

import com.popularmmos.entities.jenicorn.EntityJenicorn;
import com.popularmmos.entities.pat.EntityPat;
import com.popularmmos.entities.pat.largeweight.EntityLargeWeight;
import com.popularmmos.entities.pat.smallweight.EntitySmallWeight;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

public class PopularEntities
{

    public static void Popular()
    {
        registerEntity();
    }

    public static void registerEntity()
    {
        createEntity(EntityPat.class, "PopularMMOs", 0x0, 0x0);
        createEntity(EntityJenicorn.class, "Jenicorn", 0xFF33CC, 0xFF66CC);

        createNonLivingEntity(EntitySmallWeight.class, "ItemSmallWeight");
        createNonLivingEntity(EntityLargeWeight.class, "largeWeight");
    }

    public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor)
    {
        int randomID = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomID);
        EntityRegistry.registerModEntity(entityClass, entityName, randomID, PopularMMOs.MODID, 30, 1, true);
        //probability, minimum group size, max group size, type of creature, biome(s) to spawn in
        if (entityName == "Jenicorn")
        {
            EntityRegistry.addSpawn(entityClass, 2, 0, 1, EnumCreatureType.creature, BiomeGenBase.forest);
        }
        createEgg(randomID, solidColor, spotColor);
    }

    //Creates Projectiles
    public static void createNonLivingEntity(Class entityClass, String entityName)
    {
        int randomID = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomID);
        EntityRegistry.registerModEntity(entityClass, entityName, randomID, PopularMMOs.MODID, 66, 1, true);
        System.out.println(entityClass + " successfully registered.");
    }

    private static void createEgg(int randomID, int solidColor, int spotColor)
    {
        EntityList.entityEggs.put(Integer.valueOf(randomID), new EntityList.EntityEggInfo(randomID, solidColor, spotColor));
    }
}
