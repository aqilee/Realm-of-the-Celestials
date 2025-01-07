package com.realmofthecelestials.realmofthecelestials.event.custom;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

public class DayChangeAlert {
    //This code is used to send a message to players when the 2nd day comes
    private boolean messageSent = false; //訊息是否已發出

    @SubscribeEvent
    public void onLevelTick(TickEvent.LevelTickEvent event) {
        // 檢查是否在伺服器端執行，並確認是主世界
        if (event.level instanceof ServerLevel world && !event.level.isClientSide) {
            long dayCount = world.getDayTime() / 24000L; // 計算天數

            if (dayCount == 1 && !messageSent) {
                world.players().forEach(player ->
                        player.sendSystemMessage(Component.literal("到第二天了......"))
                );
                messageSent = true; //確保訊息不會傳送第二次
            }
        }
    }
}