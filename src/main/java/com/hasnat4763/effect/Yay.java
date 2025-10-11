package com.hasnat4763.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;



public class Yay extends StatusEffect {
    protected Yay() {
        super(StatusEffectCategory.HARMFUL, 0x98D9EA);
        this.addAttributeModifier(EntityAttributes.ATTACK_DAMAGE, Identifier.ofVanilla("effect.strength"), 30.0F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(EntityAttributes.MAX_ABSORPTION, Identifier.ofVanilla("effect.absorption"), 5.0F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(EntityAttributes.MOVEMENT_SPEED, Identifier.ofVanilla("effect.speed"), 2.0F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(EntityAttributes.MAX_HEALTH, Identifier.ofVanilla("effect.speed"), 2.0F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {

        return super.applyUpdateEffect(world, entity, amplifier);

    }
}
