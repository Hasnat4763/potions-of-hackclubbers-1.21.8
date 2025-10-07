package com.hasnat4763.effect;

import com.hasnat4763.PotionsOfHackClubbers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import static com.hasnat4763.PotionsOfHackClubbers.MOD_ID;
import static net.minecraft.entity.effect.StatusEffects.SLOWNESS;

public class Heavysob extends StatusEffect {
    protected Heavysob() {
        super(StatusEffectCategory.HARMFUL, 0x98D9EA);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).addExhaustion(0.1F * (amplifier + 1));


        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }

    public static void RegisterModEffects(){
        PotionsOfHackClubbers.LOGGER.info("Registering effects for " + MOD_ID);
        final RegistryEntry<StatusEffect> HEAVYSOB = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "heavysob"), new Heavysob());
    }

}
