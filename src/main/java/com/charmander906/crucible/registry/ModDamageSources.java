package com.charmander906.crucible.registry;

import com.charmander906.crucible.Crucible;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;

public final class ModDamageSources {
    private ModDamageSources() {}

    public static final ResourceKey<DamageType> PYREFLAME =
        ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Crucible.MODID, "pyreflame"));

    public static DamageSource pyreflame(ServerLevel level) {
        Holder.Reference<DamageType> holder = level.registryAccess()
                .registryOrThrow(Registries.DAMAGE_TYPE)
                .getHolderOrThrow(PYREFLAME);
        return new DamageSource(holder);
    }
}
