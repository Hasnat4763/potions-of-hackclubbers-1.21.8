package com.hasnat4763.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.hasnat4763.effect.ModEffects.YAY;

@Mixin(LivingEntity.class)
public abstract class YayEffectJumpBoost {
    @Inject(method = "jump", at = @At("TAIL") )
    private void applyJumpBoost(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (entity.hasStatusEffect(YAY)) {
            StatusEffectInstance effect = entity.getStatusEffect(YAY);

            if (effect == null) return;

            float jump_boost = 0.2F * (effect.getAmplifier() + 1);

            Vec3d velocity = entity.getVelocity();

            entity.setVelocity(velocity.x, velocity.y+jump_boost, velocity.z);


        }
    }

}
