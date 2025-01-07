package com.realmofthecelestials.realmofthecelestials.util;

import com.realmofthecelestials.realmofthecelestials.RealmoftheCelestials;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> NEED_SPARKLING_TOOL = createTag("need_sparkling_tool");
        public static final TagKey<Block> INCORRECT_FOR_SPARKLING_TOOL = createTag("incorrect_for_sparkling_tool");

        public static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(RealmoftheCelestials.MOD_ID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> KEY_FOR_ALTAR = createTag("key_for_altar");

        public static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(RealmoftheCelestials.MOD_ID, name));
        }

    }
}
