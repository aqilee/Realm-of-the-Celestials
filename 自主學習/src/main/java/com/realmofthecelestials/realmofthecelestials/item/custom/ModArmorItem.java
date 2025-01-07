package com.realmofthecelestials.realmofthecelestials.item.custom;

import com.google.common.collect.ImmutableMap;
import com.realmofthecelestials.realmofthecelestials.item.ModArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    static int infinity = 2147483647;

    private static final Map<Holder<ArmorMaterial>, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<Holder<ArmorMaterial>, List<MobEffectInstance>>())
                    .put(ModArmorMaterials.SPARKLING_ARMOR_MATERIAL,
                            List.of(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 5, false, false),
                                    new MobEffectInstance(MobEffects.REGENERATION, 200, 5, false, false),
                                    new MobEffectInstance(MobEffects.HEALTH_BOOST, infinity, 5, false, false)))
                    .build();

    public ModArmorItem(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex){
        if(!level.isClientSide() && hasFullSuitOfArmorOn(player)){
            evaluateArmorEffects(player);
        }
    }

    private void evaluateArmorEffects(Player player){
        for(Map.Entry<Holder<ArmorMaterial>, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()){
            Holder<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapEffect = entry.getValue();

            if(hasPlayerCorrectArmorOn(mapArmorMaterial, player)){
                addEffectToPlayer(player, mapEffect);
            }
        }
    }

    private void addEffectToPlayer(Player player, List<MobEffectInstance> mapEffect){
        boolean hasPlayerEffect = mapEffect.stream().allMatch(effect -> player.hasEffect(effect.getEffect()));

        if(!hasPlayerEffect){
            for(MobEffectInstance effect : mapEffect){
                player.addEffect(new MobEffectInstance(effect.getEffect(),
                        effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
            }
        }
    }

    private boolean hasPlayerCorrectArmorOn(Holder<ArmorMaterial> mapArmorMaterial, Player player){
        for(ItemStack armorStack : player.getArmorSlots()){
            if(!(armorStack.getItem() instanceof ArmorItem)){ return false; }
        }

        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());

        return boots.getMaterial() == mapArmorMaterial && leggings.getMaterial()
                == mapArmorMaterial && chestplate.getMaterial()
                == mapArmorMaterial && helmet.getMaterial()
                == mapArmorMaterial;
    }

    private boolean hasFullSuitOfArmorOn(Player player){
        ItemStack helmet = player.getInventory().getArmor(3);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack boots =  player.getInventory().getArmor(0);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }
}
