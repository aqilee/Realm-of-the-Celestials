package com.realmofthecelestials.realmofthecelestials.component;

import com.realmofthecelestials.realmofthecelestials.RealmoftheCelestials;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.UnaryOperator;

public class ModDataComponentType {
    /*主要用途
     *  數據生成：提供工具來創建和管理 Minecraft 數據包，幫助玩家自定義遊戲內容。
     *  自動化：簡化數據包的生成過程，減少手動編輯 JSON 文件的需求。
     *  模組兼容性：支持不同模組之間的互操作性，讓玩家能夠更輕鬆地整合各種模組。
     *  增強功能：提供額外的功能和選項，如自定義物品、方塊和實體的屬性。
     *使用場景
     *  創建自定義物品：玩家可以使用該模組創建獨特的物品和方塊，並為其定義行為和屬性。
     *  設計遊戲機制：可用於設計新的遊戲機制或調整現有機制，以增強遊戲體驗。
     *  社群分享：玩家可以輕鬆分享自己創建的數據包，促進社群互動。
     *
     *generated by monica
     */
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, RealmoftheCelestials.MOD_ID);

    public static final RegistryObject<DataComponentType<BlockPos>> COORDINATES = register("coordinates",
            builder -> builder.persistent(BlockPos.CODEC)); //coordinate:協調  codec:編解碼器

    private static <T>RegistryObject<DataComponentType<T>> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator){
        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus){
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}
