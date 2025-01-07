package com.realmofthecelestials.realmofthecelestials.sound;

import com.realmofthecelestials.realmofthecelestials.RealmoftheCelestials;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    //This is used for register sound events, including bgm and sound effect
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RealmoftheCelestials.MOD_ID);

    //之後要改成在神域裡的晚上
    public static final RegistryObject<SoundEvent> OVERWORLD_NIGHT = registerSoundEvent("overworld_night");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(RealmoftheCelestials.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
