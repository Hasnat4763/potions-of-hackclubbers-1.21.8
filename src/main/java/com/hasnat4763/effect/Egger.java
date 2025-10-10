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
import net.minecraft.util.math.Vec3d;

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
        if (entity instanceof PlayerEntity player) {
            player.addStatusEffect(
                    new StatusEffectInstance(
                            StatusEffects.SLOW_FALLING,
                            100,
                            amplifier,
                            false,
                            false,
                            false
                    )
            );

            int interval = 200 / (amplifier + 1);

            StatusEffectInstance EggerInstance = entity.getStatusEffect(EGGER);

            if (EggerInstance != null && (EggerInstance.getDuration()) > 0 && (EggerInstance.getDuration() % interval == 0)) {
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

            if (EggerInstance != null && (EggerInstance.getDuration() % 40 == 0)) {
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

            if (!world.isClient) {
                Vec3d velocity = entity.getVelocity();

                double upwardImpulse = 0.04 * (amplifier + 1);
                entity.addVelocity(0.0, upwardImpulse, 0.0);
                double maxFallSpeed = -0.05 * (amplifier + 1);

                if (velocity.y < maxFallSpeed) {
                    entity.setVelocity(new Vec3d(velocity.x, maxFallSpeed, velocity.z));
                }

                entity.velocityDirty = true;
            }
        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }
}