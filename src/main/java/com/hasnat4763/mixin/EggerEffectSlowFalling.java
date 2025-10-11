package com.hasnat4763.mixin;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.hasnat4763.effect.ModEffects.EGGER;
import static net.minecraft.entity.damage.DamageTypes.FALL;

@Mixin(PlayerEntity.class)
public abstract class EggerEffectSlowFalling {

    @Inject(method = "handleFallDamage", at = @At("HEAD"), cancellable = true)
    private void preventFallDamage(double fallDistance, float damagePerDistance, DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        if (player.hasStatusEffect(EGGER) && source.isOf(FALL)) {
            cir.setReturnValue(false);
        }
    }
}

