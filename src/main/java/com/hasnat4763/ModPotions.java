package com.hasnat4763;

import com.hasnat4763.item.ModItems;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.hasnat4763.PotionsOfHackClubbers.MOD_ID;
import static com.hasnat4763.effect.ModEffects.*;

public class ModPotions {
    public static final Potion HEAVYSOB_POTION =
            Registry.register(
                    Registries.POTION,
                    Identifier.of(MOD_ID, "heavysob"),
                    new Potion("heavysob",
                            new StatusEffectInstance(
                                    HEAVYSOB,
                                    3600,
                                    0)));

    public static final Potion HEAVYSOB_POTION_II =
            Registry.register(
                    Registries.POTION,
                    Identifier.of(MOD_ID, "heavysob_ii"),
                    new Potion("heavysob_ii",
                            new StatusEffectInstance(
                                    HEAVYSOB,
                                    3600,
                                    1)));


    public static final Potion EGGER_POTION =
            Registry.register(
                    Registries.POTION,
                    Identifier.of(MOD_ID, "egger"),
                    new Potion("egger",
                            new StatusEffectInstance(
                                    EGGER,
                                    3600,
                                    0)));

    public static final Potion EGGER_POTION_II =
            Registry.register(
                    Registries.POTION,
                    Identifier.of(MOD_ID, "egger_ii"),
                    new Potion("egger_ii",
                            new StatusEffectInstance(
                                    EGGER,
                                    3600,
                                    1)));


    public static final Potion YAY_POTION =
            Registry.register(
                    Registries.POTION,
                    Identifier.of(MOD_ID, "yay"),
                    new Potion("yay",
                            new StatusEffectInstance(
                                    YAY,
                                    3600,
                                    0)));
    public static final Potion YAY_POTION_II =
            Registry.register(
                    Registries.POTION,
                    Identifier.of(MOD_ID, "yay_ii"),
                    new Potion("yay_ii",
                            new StatusEffectInstance(
                                    YAY,
                                    3600,
                                    1)));


    public static void RegisterModPotions() {
        PotionsOfHackClubbers.LOGGER.info("Registering potions for " + MOD_ID);
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder ->
                builder.registerPotionRecipe(
                        Potions.AWKWARD,
                        ModItems.HEIDI_TAIL,
                        Registries.POTION.getEntry(HEAVYSOB_POTION)
                ));

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder ->
                builder.registerPotionRecipe(
                        Registries.POTION.getEntry(HEAVYSOB_POTION),
                        Items.GLOWSTONE_DUST,
                        Registries.POTION.getEntry(HEAVYSOB_POTION_II)
                ));

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder ->
            builder.registerPotionRecipe(
                    Potions.AWKWARD,
                    ModItems.CHICKEN_OVARY,
                    Registries.POTION.getEntry(EGGER_POTION)
            ));

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder ->
                builder.registerPotionRecipe(
                        Registries.POTION.getEntry(EGGER_POTION),
                        Items.GLOWSTONE_DUST,
                        Registries.POTION.getEntry(EGGER_POTION_II)
                ));

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder ->
                builder.registerPotionRecipe(
                        Potions.AWKWARD,
                        ModItems.ORPHEUS_TAIL,
                        Registries.POTION.getEntry(YAY_POTION)
                ));
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder ->
                builder.registerPotionRecipe(
                        Registries.POTION.getEntry(YAY_POTION),
                        Items.GLOWSTONE_DUST,
                        Registries.POTION.getEntry(YAY_POTION_II)
                ));

    }
}
