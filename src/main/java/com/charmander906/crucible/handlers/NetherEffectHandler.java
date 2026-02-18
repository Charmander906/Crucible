package com.charmander906.crucible.handlers;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import com.charmander906.crucible.Crucible;
import com.charmander906.crucible.registry.ModEffects;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Crucible.MODID)
public class NetherEffectHandler {

    private static final ResourceKey<Level> NETHER_KEY =
            ResourceKey.create(Registries.DIMENSION, new ResourceLocation("minecraft", "the_nether"));

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        Player player = event.player;

        if (player.level().isClientSide()) return;

        if (player.level().dimension().equals(NETHER_KEY)) {
            if (!player.hasEffect(ModEffects.PYREFLAME.get()) &&
                !player.hasEffect(ModEffects.PYREWARD.get())) {

                player.addEffect(new MobEffectInstance(
                        ModEffects.PYREFLAME.get(),
                        40,    // duration
                        0,     // amplifier
                        true,  // ambient
                        true,  // showParticles
                        true   // showIcon
                ));
            }
        }
    }
}
