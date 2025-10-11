package com.hasnat4763.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static com.hasnat4763.effect.ModEffects.HEAVYSOB;

public class Heavysob extends StatusEffect {
    protected Heavysob() {
        super(StatusEffectCategory.HARMFUL, 0x98D9EA);
        this.addAttributeModifier(EntityAttributes.ATTACK_DAMAGE, Identifier.ofVanilla("effect.weakness"), -10.0F, EntityAttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(EntityAttributes.BLOCK_BREAK_SPEED, Identifier.ofVanilla("effect.mining_fatigue"), -10.0F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(EntityAttributes.MOVEMENT_SPEED, Identifier.ofVanilla("effect.slowness"), -7.0F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).addExhaustion(0.01F * (amplifier + 1));
        }
        StatusEffectInstance heavysobInstance = entity.getStatusEffect(HEAVYSOB);
        if (heavysobInstance != null && (heavysobInstance.getDuration() % 40 == 0)) {
            world.playSound(
                    null,
                    entity.getX(),
                    entity.getY(),
                    entity.getZ(),
                    SoundEvents.ENTITY_GHAST_HURT,
                    net.minecraft.sound.SoundCategory.PLAYERS,
                    1.0f,
                    0.8f
            );
        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }
}
