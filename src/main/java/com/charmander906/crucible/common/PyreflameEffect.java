package com.charmander906.crucible.common;

import javax.annotation.Nonnull;

import com.charmander906.crucible.registry.ModDamageSources;
import com.charmander906.crucible.registry.ModEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class PyreflameEffect extends MobEffect {

    public PyreflameEffect(MobEffectCategory type, int color) {
        super(type, color);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 40 == 0;
    }

    @Override
    public void applyEffectTick(@Nonnull LivingEntity entity, int amplifier) {
        if (entity.level().isClientSide) return;

        if (ModEffects.PYREWARD.isPresent() && entity.hasEffect(ModEffects.PYREWARD.get())) return;

        if (!(entity.level() instanceof ServerLevel serverLevel)) return;

        DamageSource src = ModDamageSources.pyreflame(serverLevel);

        float damage = 4.0F + (amplifier * 1.5F);
        entity.hurt(src, damage);

        int fireSeconds = 5;
        entity.setSecondsOnFire(fireSeconds);
    }
}
