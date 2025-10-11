package com.hasnat4763.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.hasnat4763.effect.ModEffects.YAY;

@Mixin(PlayerEntity.class)
public abstract class YayEffectHaste {
    @Inject(method = "getBlockBreakingSpeed", at = @At("RETURN"), cancellable = true)
    private void onGetBlockBreakingSpeedMultiplier(BlockState state, CallbackInfoReturnable<Float> cir) {

        PlayerEntity entity = (PlayerEntity) (Object) this;

        if (entity.hasStatusEffect(YAY)) {
            StatusEffectInstance effect = entity.getStatusEffect(YAY);

            if (effect == null) return;
            if (cir.getReturnValue() == null) return;


            Float speed = cir.getReturnValue() + (5F * (effect.getAmplifier() + 1));

            cir.setReturnValue(speed);

        }
    }
}
