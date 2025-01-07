package com.realmofthecelestials.realmofthecelestials.entity;

import com.realmofthecelestials.realmofthecelestials.RealmoftheCelestials;
import com.realmofthecelestials.realmofthecelestials.entity.custom.SpecialPigEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RealmoftheCelestials.MOD_ID);

    public static final RegistryObject<EntityType<SpecialPigEntity>> SPECIAL_PIG =
            ENTITY_TYPES.register("special_pig", () -> EntityType.Builder.of(SpecialPigEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 2.5f).build("special_pig"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
