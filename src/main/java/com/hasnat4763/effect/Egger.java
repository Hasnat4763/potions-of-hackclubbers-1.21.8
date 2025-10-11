package com.hasnat4763.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;

import static com.hasnat4763.effect.ModEffects.EGGER;

public class Egger extends StatusEffect {
    protected Egger() {
        super(StatusEffectCategory.NEUTRAL, 0xFFFF00);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {

        return true;
    }

    @Override

    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        StatusEffectInstance EggerInstance = entity.getStatusEffect(EGGER);

        if (entity instanceof PlayerEntity player && EggerInstance != null) {
            int interval = 200 / (amplifier + 1);
            if ((EggerInstance.getDuration()) > 0 && (EggerInstance.getDuration() % interval == 0)) {
                player.dropItem(new ItemStack(Items.EGG), true, false);
                world.playSound(
                        null,
                        entity.getX(),
                        entity.getY(),
                        entity.getZ(),
                        SoundEvents.ENTITY_CHICKEN_EGG,
                        net.minecraft.sound.SoundCategory.PLAYERS,
                        1.0f,
                        0.8f
                );
            }

            if ((EggerInstance.getDuration() % 40 == 0)) {
                world.playSound(
                        null,
                        entity.getX(),
                        entity.getY(),
                        entity.getZ(),
                        SoundEvents.ENTITY_CHICKEN_AMBIENT,
                        net.minecraft.sound.SoundCategory.PLAYERS,
                        1.0f,
                        0.8f
                );
            }
        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }
}