package com.charmander906.crucible.handlers;

import com.charmander906.crucible.Crucible;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Normalize BYPASSES_ARMOR damage to non-bypassing damage, except for FORCE_BYPASS entries.
 * Special-cases fall damage: preserve the fall DamageSource and computed amount, apply armor/toughness mitigation
 * by changing only event.getAmount() (so death messages / statistics / triggers remain vanilla).
 */
@Mod.EventBusSubscriber(modid = Crucible.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class NoBypassArmorHandler {

    private static final ThreadLocal<Boolean> REENTRANT = ThreadLocal.withInitial(() -> false);
    private static final Set<ResourceLocation> FORCE_BYPASS = new HashSet<>();

    static {
        // Crucible
        FORCE_BYPASS.add(new ResourceLocation("crucible:pyreflame"));

        // True Ending
        FORCE_BYPASS.add(new ResourceLocation("true_ending:mob_attack_pierce_shield"));
        FORCE_BYPASS.add(new ResourceLocation("true_ending:mob_attack_pierce_shield_cooldown"));

        // Tough As Nails
        FORCE_BYPASS.add(new ResourceLocation("toughasnails:hyperthermia"));
        FORCE_BYPASS.add(new ResourceLocation("toughasnails:thirst"));

        // Enchancement
        FORCE_BYPASS.add(new ResourceLocation("enchancement:brimstone"));
        FORCE_BYPASS.add(new ResourceLocation("enchancement:frostbite"));
        FORCE_BYPASS.add(new ResourceLocation("enchancement:life_drain"));

        // Ice and Fire
        FORCE_BYPASS.add(new ResourceLocation("iceandfire:gorgon"));

        // Vanilla exclusions
        FORCE_BYPASS.add(new ResourceLocation("minecraft:out_of_world"));
        FORCE_BYPASS.add(new ResourceLocation("minecraft:starve"));
        FORCE_BYPASS.add(new ResourceLocation("minecraft:freeze"));
        FORCE_BYPASS.add(new ResourceLocation("minecraft:dragon_breath"));
        FORCE_BYPASS.add(new ResourceLocation("minecraft:generic_kill"));
        FORCE_BYPASS.add(new ResourceLocation("minecraft:drown"));
        FORCE_BYPASS.add(new ResourceLocation("minecraft:lightning_bolt"));
        FORCE_BYPASS.add(new ResourceLocation("minecraft:hot_floor"));
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onLivingHurt(LivingHurtEvent event) {
        if (REENTRANT.get()) return;

        LivingEntity target = event.getEntity();
        if (target.level().isClientSide()) return;

        DamageSource original = event.getSource();
        Optional<ResourceKey<DamageType>> keyOpt = original.typeHolder().unwrapKey();
        if (keyOpt.isEmpty()) return;

        ResourceLocation id = keyOpt.get().location();

        if (id.equals(new ResourceLocation("minecraft:fall"))) {
            float amount = event.getAmount();

            float armor = target.getArmorValue();
            float toughness = (float) target.getAttributeValue(Attributes.ARMOR_TOUGHNESS);

            float boostedArmor = (float) Math.pow(armor, 1.25);
            float boostedToughness = (float) Math.pow(toughness, 1.25);

            float mitigated = CombatRules.getDamageAfterAbsorb(amount, boostedArmor, boostedToughness);

            event.setAmount(mitigated);
            return;
        }

        if (id.equals(new ResourceLocation("minecraft:magic"))) {
            float amount = event.getAmount();

            float armor = target.getArmorValue();
            float toughness = (float) target.getAttributeValue(Attributes.ARMOR_TOUGHNESS);

            float mitigated = CombatRules.getDamageAfterAbsorb(amount, armor, toughness);

            event.setAmount(mitigated);
            return;
        }

        if (FORCE_BYPASS.contains(id)) return;

        if (original.is(DamageTypeTags.BYPASSES_ARMOR)) {
            float amount = event.getAmount();
            DamageSources sources = target.damageSources();

            Entity attacker = original.getEntity();
            Entity direct = original.getDirectEntity();

            DamageSource replacement;
            if (attacker instanceof LivingEntity living) {
                replacement = sources.mobAttack(living);
            } else if (direct instanceof LivingEntity livingDirect) {
                replacement = sources.mobAttack(livingDirect);
            } else {
                replacement = sources.generic();
            }

            event.setCanceled(true);

            try {
                REENTRANT.set(true);
                target.hurt(replacement, amount);
            } finally {
                REENTRANT.set(false);
            }
        }
    }
}
