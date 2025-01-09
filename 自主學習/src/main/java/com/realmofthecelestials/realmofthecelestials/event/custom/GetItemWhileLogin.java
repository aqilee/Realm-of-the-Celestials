package com.realmofthecelestials.realmofthecelestials.event.custom;

import com.realmofthecelestials.realmofthecelestials.item.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class GetItemWhileLogin {
    private boolean hasGetItem = false;
    @SubscribeEvent
    public void GetItemWhileLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if(event.getEntity() instanceof ServerPlayer && !hasGetItem) {
            ServerPlayer player = (ServerPlayer) event.getEntity();
            ItemStack itemStack = new ItemStack(ModItems.SPINE.get(), 1);
            player.getInventory().add(itemStack);
            hasGetItem = true;
        }
    }
}
