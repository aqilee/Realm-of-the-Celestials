package com.realmofthecelestials.realmofthecelestials.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties CUISINE = new FoodProperties.Builder()
            .nutrition(3) //營養價值:=回復飽食度與飢餓值的比值 飢餓值 = 飽食度/營養價值
            .saturationModifier(1f) //飽食度 (?)
            .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 600), 0.5f)//效果 持續時間 機率
            .build();
}
