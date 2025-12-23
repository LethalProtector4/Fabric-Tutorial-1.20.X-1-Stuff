package net.everett.tutorialmod.entity.client;

import net.everett.tutorialmod.TutorialMod;
import net.everett.tutorialmod.entity.custom.SnailEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class SnailModel extends GeoModel<SnailEntity> {
    @Override
    public Identifier getModelResource(SnailEntity animatable) {
        return new Identifier(TutorialMod.MOD_ID, "geo/snail.geo.json");
    }

    @Override
    public Identifier getTextureResource(SnailEntity animatable) {
        return new Identifier(TutorialMod.MOD_ID, "textures/entity/snail.png");
    }

    @Override
    public Identifier getAnimationResource(SnailEntity animatable) {
        return new Identifier(TutorialMod.MOD_ID, "animations/snail.animation.json");
    }
}
