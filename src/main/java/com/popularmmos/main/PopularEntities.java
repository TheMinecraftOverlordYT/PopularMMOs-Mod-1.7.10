package com.popularmmos.main;

import com.popularmmos.entities.jenboss.EntityJenBoss;
import com.popularmmos.explosions.EntityPinkTNTPrimed;
import com.popularmmos.entities.jenboss.subsidiaries.lightningPink.EntityLightningPink;
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
        createEntity(EntityPat.class, "MMOs", 0x0, 0x0);
        createEntity(EntityJenicorn.class, "Jenicorn", 0xFF33CC, 0xFF66CC);
        createEntity(EntityJenBoss.class, "Jen", 0xFF66CC, 0xFF33CC);

        createNonLivingEntity(EntitySmallWeight.class, "ItemSmallWeight");
        createNonLivingEntity(EntityLargeWeight.class, "largeWeight");

        createNonLivingEntity(EntityLightningPink.class, "lightning");
        createNonLivingEntity(EntityPinkTNTPrimed.class, "pinkTNT");
    }

    public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor)
    {
        int randomID = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomID);
        EntityRegistry.registerModEntity(entityClass, entityName, randomID, MMOs.MODID, 30, 1, true);
        //probability, minimum group size, max group size, type of creature, biome(s) to spawn in
        if (entityName.equals("Jenicorn"))
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
        EntityRegistry.registerModEntity(entityClass, entityName, randomID, MMOs.MODID, 66, 1, true);
    }

    private static void createEgg(int randomID, int solidColor, int spotColor)
    {
        EntityList.entityEggs.put(Integer.valueOf(randomID), new EntityList.EntityEggInfo(randomID, solidColor, spotColor));
    }
}
