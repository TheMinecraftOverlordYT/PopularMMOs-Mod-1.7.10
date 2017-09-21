package com.popularmmos;


import com.popularmmos.entities.pat.largeweight.EntityLargeWeight;
import com.popularmmos.entities.pat.smallweight.EntitySmallWeight;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class PopularDamageSources extends DamageSource{

    public PopularDamageSources(String name)
    {
        super(name);
    }

    public static DamageSource upperCut = new PopularDamageSources("upperCut");
    public static DamageSource swordSlice = new PopularDamageSources("swordSlice");
    public static DamageSource downwardsSwordSlice = new PopularDamageSources("downwardsSwordSlice");
    public static DamageSource beam = new PopularDamageSources("beam");

    public static DamageSource smallWeight (EntitySmallWeight entitySmallWeight, EntityLivingBase thrower)
    {
        return (new EntityDamageSourceIndirect("smallWeight", entitySmallWeight, thrower)).setProjectile();
    }

    public static DamageSource largeWeight (EntityLargeWeight entityLargeWeight, EntityLivingBase thrower)
    {
        return (new EntityDamageSourceIndirect("largeWeight", entityLargeWeight, thrower)).setProjectile();
    }

}
