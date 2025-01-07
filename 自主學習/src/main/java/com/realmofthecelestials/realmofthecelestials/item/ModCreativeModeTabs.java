package com.realmofthecelestials.realmofthecelestials.item;

import com.realmofthecelestials.realmofthecelestials.RealmoftheCelestials;
import com.realmofthecelestials.realmofthecelestials.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RealmoftheCelestials.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ROTC_ITEMS_TAB = CREATIVE_MODE_TABS.register("rotc_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SPINE.get()))
                    .title(Component.translatable("creativetab.realmofthecelestials.rotc_items"))
                    .displayItems((itemDisplayParameters, output) -> { //Here is used for put in what you wanna put
                        output.accept(ModItems.SPINE.get());
                        output.accept(ModItems.SPARKLING_CRYSTAL.get());
                        output.accept(ModItems.CUISINE.get());
                        output.accept(ModItems.MYSTERIOUS_COMPASS.get());

                        output.accept(ModItems.SPARKLING_SWORD.get());
                        output.accept(ModItems.SPARKLING_PICKAXE.get());
                        output.accept(ModItems.SPARKLING_SHOVEL.get());
                        output.accept(ModItems.SPARKLING_AXE.get());
                        output.accept(ModItems.SPARKLING_HOE.get());
                        output.accept(ModItems.SPARKLING_HAMMER.get());

                        output.accept(ModItems.SPARKLING_HELMET.get());
                        output.accept(ModItems.SPARKLING_CHESTPLATE.get());
                        output.accept(ModItems.SPARKLING_LEGGINGS.get());
                        output.accept(ModItems.SPARKLING_BOOTS.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> ROTC_BLOCKS_TAB = CREATIVE_MODE_TABS.register("rotc_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SPARKLING_BLOCK.get()))
                    .withTabsBefore(ROTC_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.realmofthecelestials.rotc_block"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.SPARKLING_BLOCK.get());
                        output.accept(ModBlocks.SPARKLING_ORE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
