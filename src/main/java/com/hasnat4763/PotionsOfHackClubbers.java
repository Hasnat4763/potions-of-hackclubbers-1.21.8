package com.hasnat4763;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.hasnat4763.ModPotions.RegisterModPotions;
import static com.hasnat4763.ModVillagerTrades.RegisterModVillagerTrades;
import static com.hasnat4763.effect.ModEffects.RegisterModEffects;
import static com.hasnat4763.item.ModItems.*;

public class PotionsOfHackClubbers implements ModInitializer {
	public static final String MOD_ID = "pohc";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	private static final Identifier CAT_GIFT_ID = Identifier.of("minecraft", "gameplay/cat_morning_gift");
	private static final Identifier CHICKEN_LOOT_DROP_ID = Identifier.of("minecraft", "entities/chicken");


	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		RegisterModItems();
		RegisterModEffects();
		RegisterModPotions();
		RegisterModVillagerTrades();

		LootTableEvents.MODIFY.register(((registryKey, builder, lootTableSource, wrapperLookup) -> {
			if (CHICKEN_LOOT_DROP_ID.equals(registryKey.getValue())) {
				if (lootTableSource.isBuiltin()) {
					LootPool.Builder poolBuilder = LootPool.builder()
							.rolls(ConstantLootNumberProvider.create(1))
							.with(ItemEntry.builder(CHICKEN_OVARY)
									.weight(5)
									.quality(0));
					builder.pool(poolBuilder);
				}
			}
		}));



		LootTableEvents.MODIFY.register((registryKey, builder, lootTableSource, wrapperLookup) -> {
			if (CAT_GIFT_ID.equals(registryKey.getValue())) {
				if (lootTableSource.isBuiltin()) {
					LootPool.Builder poolBuilder = LootPool.builder()
							.rolls(ConstantLootNumberProvider.create(1))
							.with(ItemEntry.builder(ORPHEUS_TAIL)
									.weight(30)
									.quality(0));
					builder.pool(poolBuilder);
				}
		}
			if (CAT_GIFT_ID.equals(registryKey.getValue())) {
				if (lootTableSource.isBuiltin()) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.with(ItemEntry.builder(HEIDI_TAIL)
								.weight(30)
								.quality(0));
						builder.pool(poolBuilder);
					}
			}

			if (CAT_GIFT_ID.equals(registryKey.getValue())) {
				if (lootTableSource.isBuiltin()) {
					LootPool.Builder poolBuilder = LootPool.builder()
							.rolls(ConstantLootNumberProvider.create(1))
							.with(ItemEntry.builder(CHICKEN_OVARY)
									.weight(30)
									.quality(0));
					builder.pool(poolBuilder);
				}
			}
		}
		);
		}
}