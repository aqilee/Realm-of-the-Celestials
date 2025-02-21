package com.realmofthecelestials.realmofthecelestials.worldgen;

import com.realmofthecelestials.realmofthecelestials.RealmoftheCelestials;
import com.realmofthecelestials.realmofthecelestials.entity.ModEntities;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class ModBiomeModifiers {
    //用途: 用於修改生物群系的生成特徵。
    //功能: 能夠在特定的生物群系中添加、刪除或修改生成的特徵。 使得某些生物群系可以擁有獨特的生成物件，例如特定的樹木或礦石。
    //generated by monica

    public static final ResourceKey<BiomeModifier> ADD_SPARKLING_ORE = registerKey("add_sparkling_ore");

    //public static final ResourceKey<BiomeModifier> SPAWN_SPECIAL_PIG = registerKey("spawn_special_pig");

    public static void bootstrap(BootstrapContext<BiomeModifier> context){
        //CF -> PF -> BM
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_SPARKLING_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
           biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
           HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.SPARKLING_ORE_PLACED_KEY)),
           GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        /*context.register(SPAWN_SPECIAL_PIG, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BAMBOO_JUNGLE), biomes.getOrThrow(Biomes.BIRCH_FOREST)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.SPECIAL_PIG.get(), 250, 2, 10))));*/
    }

    public static ResourceKey<BiomeModifier> registerKey(String name){
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(RealmoftheCelestials.MOD_ID, name));
    }


}
