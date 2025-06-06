package com.realmofthecelestials.realmofthecelestials;

import com.mojang.logging.LogUtils;
import com.realmofthecelestials.realmofthecelestials.block.ModBlocks;
import com.realmofthecelestials.realmofthecelestials.entity.ModEntities;
import com.realmofthecelestials.realmofthecelestials.entity.client.SpecialPigRenderer;
import com.realmofthecelestials.realmofthecelestials.event.custom.DayChangeAlert;
import com.realmofthecelestials.realmofthecelestials.event.custom.GetItemWhileLogin;
import com.realmofthecelestials.realmofthecelestials.event.custom.PlayBGM;
import com.realmofthecelestials.realmofthecelestials.item.ModCreativeModeTabs;
import com.realmofthecelestials.realmofthecelestials.item.ModItems;
import com.realmofthecelestials.realmofthecelestials.sound.ModSounds;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RealmoftheCelestials.MOD_ID) // The entrance of the mod, it must exist and only exist one
public class RealmoftheCelestials {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "realmofthecelestials";
    // Directly reference a slf4j logger
    // slf4j : JAVA簡易日誌門面，Simple Logging Facade for Java
    public static final Logger LOGGER = LogUtils.getLogger();

    public RealmoftheCelestials() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Normal
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);

        // Register event
        MinecraftForge.EVENT_BUS.register(new DayChangeAlert());
        MinecraftForge.EVENT_BUS.register(new PlayBGM());
        MinecraftForge.EVENT_BUS.register(new GetItemWhileLogin());
        // Client


        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){ //Items
            event.accept(ModItems.SPINE);
            event.accept(ModItems.SPARKLING_CRYSTAL);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){ //Blocks
            event.accept(ModBlocks.SPARKLING_BLOCK);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            //EntityRenderers.register(ModEntities.SPECIAL_PIG.get(), SpecialPigRenderer::new);
        }
    }
}
