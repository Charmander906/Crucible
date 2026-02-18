package com.charmander906.crucible.registry;

import com.charmander906.crucible.Crucible;
import com.charmander906.crucible.common.PyreflameEffect;
import com.charmander906.crucible.common.PyrewardEffect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModEffects {
        public static final DeferredRegister<MobEffect> MOB_EFFECTS =
                DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Crucible.MODID);

        public static final RegistryObject<MobEffect> PYREFLAME = MOB_EFFECTS.register("pyreflame",
                () -> new PyreflameEffect(MobEffectCategory.HARMFUL, 0xE25822));

        public static final RegistryObject<MobEffect> PYREWARD = MOB_EFFECTS.register("pyreward",
                () -> new PyrewardEffect(MobEffectCategory.BENEFICIAL, 0xFFD700));

        public static void register(IEventBus eventBus) {
                MOB_EFFECTS.register(eventBus);
        }
}
