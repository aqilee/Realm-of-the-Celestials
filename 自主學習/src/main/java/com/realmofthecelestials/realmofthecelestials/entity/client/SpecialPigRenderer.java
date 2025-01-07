package com.realmofthecelestials.realmofthecelestials.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.realmofthecelestials.realmofthecelestials.entity.custom.SpecialPigEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SpecialPigRenderer extends MobRenderer<SpecialPigEntity, SpecialPigModel<SpecialPigEntity>> {
    // renderer(n.) 渲染器
    public SpecialPigRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new SpecialPigModel<>(pContext.bakeLayer(SpecialPigModel.LAYER_LOCATION)), 0.9f);
        /*Util.make(Maps.newEnumMap(SpecialPigVariant.class), map->{
         *      map.put(SpecialPigVariant.GREEN, ResourceLocation.fromNamespaceAndPath(RealmoftheCelestials.MOD_ID, (texture)));
         *});
         */
    }

    @Override
    public ResourceLocation getTextureLocation(SpecialPigEntity specialPigEntity) {
        return null; //此處應填入該生物的texture檔 形如texture/entity/(creature name)/(png name).png
    }

    @Override
    public void render(SpecialPigEntity entity, float entityYaw, float partialTicks, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight){
        if(entity.isBaby()) poseStack.scale(0.5f, 0.5f, 0.5f);
        else poseStack.scale(1f, 1f, 1f);

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

}
