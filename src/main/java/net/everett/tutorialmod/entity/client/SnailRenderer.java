package net.everett.tutorialmod.entity.client;

import net.everett.tutorialmod.TutorialMod;
import net.everett.tutorialmod.entity.custom.SnailEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SnailRenderer extends GeoEntityRenderer<SnailEntity> {
    public SnailRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new SnailModel());
    }

    @Override
    public Identifier getTextureLocation(SnailEntity animatable) {
        return new Identifier(TutorialMod.MOD_ID, "textures/entity/snail.png");
    }

    @Override
    public void render(SnailEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.8f, 0.8f, 0.8f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
