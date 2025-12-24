package net.everett.tutorialmod;

import net.everett.tutorialmod.block.ModBlocks;
import net.everett.tutorialmod.entity.ModEntities;
import net.everett.tutorialmod.entity.custom.PorcupineEntity;
import net.everett.tutorialmod.item.ModItemGroups;
import net.everett.tutorialmod.item.ModItems;
import net.everett.tutorialmod.sound.ModSounds;
import net.everett.tutorialmod.util.ModCustomTrades;
import net.everett.tutorialmod.util.ModLootTableModifiers;
import net.everett.tutorialmod.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();

		ModVillagers.registerVillagers();
		ModCustomTrades.registerCustomTrades();

		ModSounds.registerSounds();

		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
		ModEntities.registerModEntities();

		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);
	}
}