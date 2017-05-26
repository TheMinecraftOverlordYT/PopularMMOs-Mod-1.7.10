package com.popularmmos.armor;

import com.popularmmos.main.PopularItems;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class FuriousArmor extends ItemArmor{
    private String [] amourTypes = new String [] {"Helmfurious", "Chestfurious", "legsfurious", "bootsfurious"};

    public FuriousArmor(ArmorMaterial armorMaterial, int renderIndex, int armourType) {
        super(armorMaterial, renderIndex, armourType);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer){
        if(stack.getItem().equals(PopularItems.furiousHelm)|| stack.getItem().equals(PopularItems.furiousChest) || stack.getItem().equals(PopularItems.furiousBoots)){
            return "popular:textures/armor/furious_1.png";
        }
        if(stack.getItem().equals(PopularItems.furiousLegs)){
            return "popular:textures/armor/furious_2.png";
        }
        else
            return null;
    }
    @Override
    public void registerIcons(IIconRegister reg){
        if(this == PopularItems.furiousHelm)
            this.itemIcon = reg.registerIcon("popular:furiousHelm");
        if(this == PopularItems.furiousChest)
            this.itemIcon = reg.registerIcon("popular:furiousChest");
        if(this == PopularItems.furiousLegs)
            this.itemIcon = reg.registerIcon("popular:furiousLegs");
        if(this == PopularItems.furiousBoots)
            this.itemIcon = reg.registerIcon("popular:furiousBoots");
    }

    private void effectPlayer(EntityPlayer player, Potion potion, int amplifier)
    {
        if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)
        {
            player.addPotionEffect(new PotionEffect(potion.id, 20, amplifier, true));
        }
    }

    boolean isWearingFullSet(EntityPlayer player, Item Helm, Item Chest, Item Legs, Item boots)
    {
        return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == Helm
                && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == Chest
                && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == Legs
                && player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == boots;
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if (itemStack.getItem() == PopularItems.furiousChest)
        {
            this.effectPlayer(player, Potion.resistance, 2);
        }
        if (itemStack.getItem() == PopularItems.furiousLegs)
        {
            this.effectPlayer(player, Potion.jump, 2);
        }
        if (itemStack.getItem() == PopularItems.furiousBoots)
        {
            this.effectPlayer(player, Potion.moveSpeed, 2);
        }

        if (this.isWearingFullSet(player, PopularItems.furiousHelm, PopularItems.furiousChest, PopularItems.furiousLegs, PopularItems.furiousBoots))
        {
            this.effectPlayer(player, Potion.damageBoost, 2);

        }
    }
}