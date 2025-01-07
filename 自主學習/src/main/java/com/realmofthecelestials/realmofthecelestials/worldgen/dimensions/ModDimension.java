package com.realmofthecelestials.realmofthecelestials.worldgen.dimensions;

import com.realmofthecelestials.realmofthecelestials.RealmoftheCelestials;
import com.realmofthecelestials.realmofthecelestials.worldgen.biomes.ModBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;
import java.util.OptionalLong;

public class ModDimension {
    //This is used for register dimension, this mod has only one dimension -- Realm of the Celestials
    //傳送至其他維度的指令:execute in (dimension) run teleport ~ ~ ~
    //ROTC == Realm of the Celestials
    public static final ResourceKey<LevelStem> ROTC_DIM_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            ResourceLocation.fromNamespaceAndPath(RealmoftheCelestials.MOD_ID, "realm_of_the_celestials"));
    public static final ResourceKey<DimensionType> ROTC_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            ResourceLocation.fromNamespaceAndPath(RealmoftheCelestials.MOD_ID, "realm_of_the_celestials_type"));

    @SubscribeEvent
    public static void registerDimensions(BootstrapContext<DimensionType> context) {
        context.register(ROTC_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime 天空時間週期
                false, // hasSkyLight 是否有天空光照
                false, // hasCeiling 是否有天花板 (僅僅是邏輯上擁有)
                false, // ultraWarm 是否超熱（如地獄 水會蒸發，海綿會變乾，熔岩流動更快、擴散更遠)
                false, // natural ==false，羅盤會隨機轉動，且無法右鍵床； ==true，地獄傳送門方塊會生成殭屍化豬布林
                1.0, // coordinateScale 傳送到該維度時的座標縮放值 [10^-5,30000000.0]
                true, // bedWorks 是否能用床
                false, // respawnAnchorWorks 玩家試圖使用重生錨時，其是否不會爆炸
                0, // minY 可以存在方塊的最低高度 [-2032,2016] && x%16==0
                256, // height 可以存在方塊的總高度。[16,4064] && x%16==0
                256, // logicalHeight 玩家使用歌萊果或地獄傳送門可以到達的總高度 [0,4064] && <= height
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn 火可以在哪些方塊上永久燃燒
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation 確定該維度的天空效果
                1.0f, // ambientLight 該維度擁有多少環境光照 ==0，完全跟隨光照變化； ==1，無環境光照
                new DimensionType.MonsterSettings(
                        false, //piglinSafe 豬布林和豬布獸是否不會殭屍化
                        false, // hasRaids 帶有不祥之兆的玩家是否會觸發突襲
                        ConstantInt.of(0),/*   monsterSpawnLightTest
                                                     *  [0,15]，怪物生成位置的最大光照。
                                                     *   該光照的計算公式是：
                                                     *       雷雨時max( skyLight - 10, blockLight )
                                                     *       其他天氣時max( internalSkyLight, blockLight )。
                                                     */
                        0 // monsterSpawnBlockLightLimit [0,15]，怪物生成位置的最大方塊光照。
                )));
    }

    public static void bootstrapStem(BootstrapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(ModBiomes.WHITE_FOREST)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.AMPLIFIED));

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(

                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.AMPLIFIED));


        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ROTC_DIM_TYPE), noiseBasedChunkGenerator);

        context.register(ROTC_DIM_KEY, stem);
    }

}

