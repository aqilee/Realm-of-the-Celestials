package com.realmofthecelestials.realmofthecelestials.item;

import com.realmofthecelestials.realmofthecelestials.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier SPARKLING = new ForgeTier(1680, 5, 3f, 20,
            ModTags.Blocks.NEED_SPARKLING_TOOL, () -> Ingredient.of(ModItems.SPARKLING_CRYSTAL.get()),
            ModTags.Blocks.INCORRECT_FOR_SPARKLING_TOOL);
}
