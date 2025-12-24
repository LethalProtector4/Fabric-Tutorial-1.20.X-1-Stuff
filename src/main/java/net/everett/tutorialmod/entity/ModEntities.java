package net.everett.tutorialmod.entity;

import net.everett.tutorialmod.TutorialMod;
import net.everett.tutorialmod.entity.custom.PorcupineEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<PorcupineEntity> PORCUPINE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID, "porcupine"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PorcupineEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 0.9f)).build());   // Hitboxes

    public static void registerModEntities() {
        TutorialMod.LOGGER.info("Registering Entities for " + TutorialMod.MOD_ID);
    }
}
