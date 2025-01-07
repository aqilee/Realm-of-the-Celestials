package com.realmofthecelestials.realmofthecelestials.event.custom;

import com.realmofthecelestials.realmofthecelestials.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayBGM {
    // This is used for playing bgm in specific time

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Level level = event.player.level();
        long timeOfDay = level.getDayTime() % 24000L;

        if (event.phase == TickEvent.Phase.END) {
            if (level.dimension() == Level.OVERWORLD && timeOfDay == 13000L) {
                Minecraft.getInstance().getMusicManager().stopPlaying();
                playBGM(ModSounds.OVERWORLD_NIGHT.get());
            }
            //此處還需要再增加白天時停止的程式，以方便使用指令停止bgm
        }
    }

    private void playBGM(SoundEvent bgm) {
        Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forMusic(bgm));
    }
}