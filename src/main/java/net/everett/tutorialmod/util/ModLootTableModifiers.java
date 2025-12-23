package net.everett.tutorialmod.util;

import net.everett.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {
    private static final Identifier JUNGLE_TEMPLE_ID =
            new Identifier("minecraft", "chests/jungle_temple");
    private static final Identifier CREEPER_ID =
            new Identifier("minecraft", "entities/creeper");
    private static final Identifier ZOMBIE_ID =
            new Identifier("minecraft", "entities/zombie");

    private static final Identifier SUSPICIOUS_SAND_ID =
            new Identifier("minecraft", "archaeology/desert_pyramid");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(JUNGLE_TEMPLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))   // Chance of the item below being dropped
                        .with(ItemEntry.builder(ModItems.METAL_DETECTOR))   // The item being dropped
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f))); // the range of the amount of items dropped

                tableBuilder.pool(poolBuilder);
            }

            if(CREEPER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))   // Chance of the item below being dropped
                        .with(ItemEntry.builder(ModItems.COAL_BRIQUETTE))   // The item being dropped
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f))); // the range of the amount of items dropped

                tableBuilder.pool(poolBuilder);
            }

            if(ZOMBIE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.025f))   // Chance of the item below being dropped
                        .with(ItemEntry.builder(ModItems.TOMATO))   // The item being dropped
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f))); // the range of the amount of items dropped

                tableBuilder.pool(poolBuilder);
            }
        });

        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
//            if(SUSPICIOUS_SAND_ID.equals(id)) {
//                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
//                entries.add(ItemEntry.builder(ModItems.METAL_DETECTOR).build());
//
//                LootPool.Builder pool = LootPool.builder().with(entries);
//                return LootTable.builder().pool(pool).build();
//            }

            return null;
        });
    }
}
