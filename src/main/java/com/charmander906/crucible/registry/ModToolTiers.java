package com.charmander906.crucible.registry;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum ModToolTiers implements Tier {
    /*
     *  WOOD
     *  baseLevel: 0
     *  uses: 59
     *  speed: 2.0F
     *  enchantmentValue: 15
     *  virtualLevel: 0.0
     *
     *  STONE
     *  baseLevel: 1
     *  uses: 131
     *  speed: 4.0F
     *  enchantmentValue: 5
     *  virtualLevel: 1.0
     */
    COPPER(
        1,
        250,
        4.0f,
        12,
        Ingredient.of(Items.COPPER_INGOT),
        1.25f
    ),
    TIN(
        1,
        250,
        5.0f,
        9,
        Ingredient.of(ModItems.TIN_INGOT.get()),
        1.5f
    ),
    BRONZE(
        1,
        250,
        5.0f,
        11,
        Ingredient.of(ModItems.BRONZE_INGOT.get()),
        1.75f
    ),
    /*
     *  IRON
     *  baseLevel: 2
     *  uses: 250
     *  speed: 6.0F
     *  enchantmentValue: 14
     *  virtualLevel: 2.0
     */
    LEAD(
        2,
        250,
        6.0f,
        1,
        Ingredient.of(ModItems.LEAD_INGOT.get()),
        2.125f
    ),
    ZINC(
        2,
        250,
        6.0f,
        9,
        Ingredient.of(ModItems.ZINC_INGOT.get()),
        2.25f
    ),
    BRASS(
        2,
        250,
        7.0f,
        13,
        Ingredient.of(ModItems.BRASS_INGOT.get()),
        2.375f
    ),
    SILVER(
        2,
        250,
        7.0f,
        20,
        Ingredient.of(ModItems.SILVER_INGOT.get()),
        2.5f
    ),
    STEEL(
        2,
        663,
        8.0f,
        4,
        Ingredient.of(ModItems.STEEL_INGOT.get()),
        2.75f
    ),
    TUNGSTEN(
        2,
        1072,
        8.0f,
        9,
        Ingredient.of(ModItems.TUNGSTEN_INGOT.get()),
        2.875f
    ),
    /*
     *  DIAMOND
     *  baseLevel: 3
     *  uses: 1561
     *  speed: 8.0F
     *  enchantmentValue: 10
     *  virtualLevel: 3.0
     *
     *  NETHERITE
     *  baseLevel: 4
     *  uses: 2031
     *  speed: 9.0F
     *  enchantmentValue: 15
     *  virtualLevel: 4.0
     */
    PALLADIUM(
        5,
        2031,
        9.0f,
        17,
        Ingredient.of(ModItems.PALLADIUM_INGOT.get()),
        5f
    ),
    MYTHRIL(
        6,
        2200,
        9.0f,
        23,
        Ingredient.of(ModItems.MYTHRIL_INGOT.get()),
        6f
    ),
    VOLCANIUM(
        7,
        2200,
        10.0f,
        15,
        Ingredient.of(ModItems.VOLCANIUM_INGOT.get()),
        7f
    ),
    COBALT(
        8,
        2200,
        10.0f,
        20,
        Ingredient.of(ModItems.COBALT_INGOT.get()),
        8f
    ),
    ORICHALCUM(
        9,
        2400,
        10.0f,
        18,
        Ingredient.of(ModItems.ORICHALCUM_INGOT.get()),
        9f
    ),
    TITANIUM(
        10,
        2600,
        11.0f,
        15,
        Ingredient.of(ModItems.TITANIUM_INGOT.get()),
        10f
    ),
    ADAMANTIUM(
        11,
        2800,
        11.0f,
        18,
        Ingredient.of(ModItems.ADAMANTIUM_INGOT.get()),
        11f
    ),
    DAEDRITE(
        12,
        3000,
        12.0f,
        5,
        Ingredient.of(ModItems.DAEDRITE_INGOT.get()),
        12f
    ),
    NYXIUM(
        13,
        3200,
        12.0f,
        20,
        Ingredient.of(ModItems.NYXIUM_INGOT.get()),
        13f
    ),
    CELESTIUM(
        14,
        3600,
        13.0f,
        30,
        Ingredient.of(ModItems.CELESTIUM_INGOT.get()),
        14f
    ),
    VOIDSTEEL(
        15,
        4000,
        14.0f,
        15,
        Ingredient.of(ModItems.VOIDSTEEL_INGOT.get()),
        15f
    );

    private final int level;              // Vanilla integer mining level
    private final float virtualLevel;     // Fractional "virtual" mining level
    private final int uses;               // Durability
    private final float speed;            // Mining speed
    private final float attackDamageBonus;// Base attack damage
    private final int enchantmentValue;   // Enchantability
    private final Ingredient repairIngredient;

    ModToolTiers(int level, int uses, float speed, int enchantmentValue, Ingredient repairIngredient, float virtualLevel) {
        this.level = level;
        this.virtualLevel = virtualLevel;
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = 0f;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    @Override public int getUses() { return uses; }
    @Override public float getSpeed() { return speed; }
    @Override public float getAttackDamageBonus() { return attackDamageBonus; }
    @Override public int getLevel() { return level; }
    public float getVirtualLevel() { return virtualLevel; }

    @Override public int getEnchantmentValue() { return enchantmentValue; }
    @Override public Ingredient getRepairIngredient() { return repairIngredient; }
}
