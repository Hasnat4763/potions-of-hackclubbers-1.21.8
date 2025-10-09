package com.hasnat4763.effect;

import com.hasnat4763.PotionsOfHackClubbers;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import static com.hasnat4763.PotionsOfHackClubbers.MOD_ID;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> HEAVYSOB =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "heavysob"), new Heavysob());
    public static final RegistryEntry<StatusEffect> EGGER =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "egger"), new Egger());
    public static void RegisterModEffects(){
        PotionsOfHackClubbers.LOGGER.info("Registering effects for " + MOD_ID);

    }
}
