package com.realmofthecelestials.realmofthecelestials;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

public class ModPortalItem {
    // This is used for mod the logic of portal, but still don't know how to mod it
    public void teleport(Entity entity, ServerLevel world, BlockPos pos) {
        // 確保傳送門位置是正確的
        if (isValidPortalLocation(world, pos)) {
            Vec3 teleportPosition = new Vec3(pos.getX(), pos.getY(), pos.getY() + 1);
            entity.teleportTo(teleportPosition.x, teleportPosition.y, teleportPosition.z);
        }
    }

    private boolean isValidPortalLocation(ServerLevel world, BlockPos pos) {
        // 檢查傳送門的有效性
        BlockState state = world.getBlockState(pos);
        return state.is(Blocks.END_PORTAL) && state.getValue(BlockStateProperties.HORIZONTAL_FACING) != null;
    }

    // 其他相關的傳送門邏輯（例如生成、啟動等）可以在這裡添加
}

