package com.popularmmos.main;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class AchievementHandler
{
    @SubscribeEvent
    public void onCrafting(PlayerEvent.ItemCraftedEvent event)
    {
     //   if(event.crafting.getItem().equals(TUOMItems.bejewelledBone))
        // {
     //       event.player.addStat(TUOM.achievementBejewelledBone, 1);
        // }
        }

    @SubscribeEvent
    public void onSmelting(PlayerEvent.ItemSmeltedEvent event)
    {
        if(event.smelting.getItem().equals((PopularItems.pinkEssence)))
        {
            event.player.addStat(MMOs.beauty, 1);
        }
    }
}

