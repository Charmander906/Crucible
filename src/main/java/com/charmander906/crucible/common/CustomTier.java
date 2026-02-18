package com.charmander906.crucible.common;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class CustomTier implements Tier {

    private final int baseLevel;
    private final float virtualLevel;
    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    public CustomTier(int baseLevel, float virtualLevel, int uses, float speed, int enchantmentValue, Ingredient repairIngredient) {
        this.baseLevel = baseLevel;
        this.virtualLevel = virtualLevel;
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = 0f;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    @Override public int getLevel() { return baseLevel; }
    public float getVirtualLevel() { return virtualLevel; }

    @Override public int getUses() { return uses; }
    @Override public float getSpeed() { return speed; }
    @Override public float getAttackDamageBonus() { return attackDamageBonus; }
    @Override public int getEnchantmentValue() { return enchantmentValue; }
    @Override public Ingredient getRepairIngredient() { return repairIngredient; }
}
