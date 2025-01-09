package com.realmofthecelestials.realmofthecelestials.item;

import com.realmofthecelestials.realmofthecelestials.RealmoftheCelestials;
import com.realmofthecelestials.realmofthecelestials.item.custom.ModArmorItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    //This is used for register items which this mod owns
    //Registering Items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RealmoftheCelestials.MOD_ID);


    //Items
    public static final RegistryObject<Item> SPINE = ITEMS.register("spine",
            () -> new Item(new Item.Properties()));
            // The man whose spine is broken : "I have German to *uck with."

    public static final RegistryObject<Item> SPARKLING_CRYSTAL = ITEMS.register("sparkling_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> UNKNOWN_BOOK = ITEMS.register("unknown_book",
            () -> new WrittenBookItem(new Item.Properties()));

    public static final RegistryObject<Item> CUISINE = ITEMS.register("cuisine",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CUISINE)));

    public static final RegistryObject<Item> MYSTERIOUS_COMPASS = ITEMS.register("mysterious_compass",
            () -> new Item(new Item.Properties()));


    //Sparkling Tools
    public static final RegistryObject<Item> SPARKLING_SWORD = ITEMS.register("sparkling_sword",
            () -> new SwordItem(ModToolTiers.SPARKLING, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.SPARKLING, 12, 3.6f))));

    public static final RegistryObject<Item> SPARKLING_PICKAXE = ITEMS.register("sparkling_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SPARKLING, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SPARKLING, 4, 3.6f))));

    public static final RegistryObject<Item> SPARKLING_SHOVEL = ITEMS.register("sparkling_shovel",
            () -> new ShovelItem(ModToolTiers.SPARKLING, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.SPARKLING, 2, 3.6f))));

    public static final RegistryObject<Item> SPARKLING_AXE = ITEMS.register("sparkling_axe",
            () -> new AxeItem(ModToolTiers.SPARKLING, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.SPARKLING, 18, 0.6f))));

    public static final RegistryObject<Item> SPARKLING_HOE = ITEMS.register("sparkling_hoe",
            () -> new HoeItem(ModToolTiers.SPARKLING, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.SPARKLING, 2, 3.6f))));

    public static final RegistryObject<Item> SPARKLING_HAMMER = ITEMS.register("sparkling_hammer",
            () -> new AxeItem(ModToolTiers.SPARKLING, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.SPARKLING, 20, 0.5F))));


    //Sparkling Armors
    public static final RegistryObject<Item> SPARKLING_HELMET = ITEMS.register("sparkling_helmet",
            () -> new ModArmorItem(ModArmorMaterials.SPARKLING_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(1000))));

    public static final RegistryObject<Item> SPARKLING_CHESTPLATE = ITEMS.register("sparkling_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.SPARKLING_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(1200))));

    public static final RegistryObject<Item> SPARKLING_LEGGINGS = ITEMS.register("sparkling_leggings",
            () -> new ModArmorItem(ModArmorMaterials.SPARKLING_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(1200))));

    public static final RegistryObject<Item> SPARKLING_BOOTS = ITEMS.register("sparkling_boots",
            () -> new ModArmorItem(ModArmorMaterials.SPARKLING_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(1000))));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
