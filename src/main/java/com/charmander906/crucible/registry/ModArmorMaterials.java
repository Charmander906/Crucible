package com.charmander906.crucible.registry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    /*
    *  LEATHER
    *  durabilityMultiplier: 5
    *  armor: {1, 3, 4, 1}
    *  enchantmentValue: 15
    *  toughness: 0
    *  knockbackResistance: 0
    * 
    *  CHAINMAIL
    *  durabilityMultiplier: 15
    *  armor: {2, 3, 4, 2}
    *  enchantmentValue: 12
    *  toughness: 0
    *  knockbackResistance: 0
    */
    COPPER("copper",
        15,
        new int[]{2, 3, 5, 2},
        12,
        SoundEvents.ARMOR_EQUIP_IRON,
        0.0f,
        0.0f,
        () -> Ingredient.of(Items.COPPER_INGOT)
    ),
    TIN("tin",
        15,
        new int[]{2, 4, 5, 2},
        9,
        SoundEvents.ARMOR_EQUIP_IRON,
        0.0f,
        0.0f,
        () -> Ingredient.of(ModItems.TIN_INGOT.get())
    ),
    BRONZE("bronze",
        15,
        new int[]{2, 4, 6, 3},
        11,
        SoundEvents.ARMOR_EQUIP_IRON,
        0.0f,
        0.0f,
        () -> Ingredient.of(ModItems.BRONZE_INGOT.get())
    ),
    /*
    *  IRON
    *  durabilityMultiplier: 15
    *  armor: {3, 5, 6, 3}
    *  enchantmentValue: 9
    *  toughness: 0
    *  knockbackResistance: 0
    */
    LEAD("lead",
        15,
        new int[]{3, 5, 7, 3},
        1,
        SoundEvents.ARMOR_EQUIP_IRON,
        0.0f,
        0.0f,
        () -> Ingredient.of(ModItems.LEAD_INGOT.get())
    ),
    ZINC("zinc",
        15,
        new int[]{3, 5, 7, 3},
        9,
        SoundEvents.ARMOR_EQUIP_IRON,
        0.0f,
        0.0f,
        () -> Ingredient.of(ModItems.ZINC_INGOT.get())
    ),
    BRASS("brass",
        15,
        new int[]{4, 6, 8, 4},
        13,
        SoundEvents.ARMOR_EQUIP_IRON,
        1.0f,
        0.0f,
        () -> Ingredient.of(ModItems.BRASS_INGOT.get())
    ),
    SILVER("silver",
        15,
        new int[]{4, 6, 8, 4},
        20,
        SoundEvents.ARMOR_EQUIP_GOLD,
        1.0f,
        0.0f,
        () -> Ingredient.of(ModItems.SILVER_INGOT.get())
    ),
    STEEL("steel",
        20,
        new int[]{4, 7, 9, 4},
        4,
        SoundEvents.ARMOR_EQUIP_IRON,
        1.0f,
        0.0f,
        () -> Ingredient.of(ModItems.STEEL_INGOT.get())
    ),
    TUNGSTEN("tungsten",
        25,
        new int[]{4, 7, 9, 5},
        9,
        SoundEvents.ARMOR_EQUIP_IRON,
        3.0f,
        0.0f,
        () -> Ingredient.of(ModItems.TUNGSTEN_INGOT.get())
    ),
    /*
    *  DIAMOND
    *  durabilityMultiplier: 33
    *  armor: {5, 8, 10, 5}
    *  enchantmentValue: 10
    *  toughness: 2
    *  knockbackResistance: 0
    * 
    *  NETHERITE
    *  durabilityMultiplier: 37
    *  armor: {5, 8, 10, 5}
    *  enchantmentValue: 15
    *  toughness: 3
    *  knockbackResistance: 0.1
    */
    PALLADIUM("palladium",
        37,
        new int[]{5, 9, 11, 6},
        17,
        SoundEvents.ARMOR_EQUIP_GOLD,
        3.0f,
        0.1f,
        () -> Ingredient.of(ModItems.PALLADIUM_INGOT.get())
    ),
    MYTHRIL("mythril",
        40,
        new int[]{6, 9, 11, 6},
        23,
        SoundEvents.ARMOR_EQUIP_GOLD,
        4.0f,
        0.1f,
        () -> Ingredient.of(ModItems.MYTHRIL_INGOT.get())
    ),
    VOLCANIUM("volcanium",
        40,
        new int[]{6, 10, 12, 7},
        15,
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        4.0f,
        0.1f,
        () -> Ingredient.of(ModItems.VOLCANIUM_INGOT.get())
    ),
    COBALT("cobalt",
        40,
        new int[]{6, 10, 12, 7},
        20,
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        5.0f,
        0.1f,
        () -> Ingredient.of(ModItems.COBALT_INGOT.get())
    ),
    ORICHALCUM("orichalcum",
        45,
        new int[]{7, 11, 13, 7},
        18,
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        5.0f,
        0.1f,
        () -> Ingredient.of(ModItems.ORICHALCUM_INGOT.get())
    ),
    TITANIUM("titanium",
        50,
        new int[]{7, 11, 14, 8},
        15,
        SoundEvents.ARMOR_EQUIP_NETHERITE,
        6.0f,
        0.2f,
        () -> Ingredient.of(ModItems.TITANIUM_INGOT.get())
    ),
    ADAMANTIUM("adamantium",
        55,
        new int[]{7, 12, 14, 8},
        18,
        SoundEvents.ARMOR_EQUIP_NETHERITE,
        6.0f,
        0.2f,
        () -> Ingredient.of(ModItems.ADAMANTIUM_INGOT.get())
    ),
    DAEDRITE("daedrite",
        60,
        new int[]{8, 12, 15, 8},
        5,
        SoundEvents.ARMOR_EQUIP_NETHERITE,
        7.0f,
        0.2f,
        () -> Ingredient.of(ModItems.DAEDRITE_INGOT.get())
    ),
    NYXIUM("nyxium",
        65,
        new int[]{8, 13, 15, 9},
        20,
        SoundEvents.ARMOR_EQUIP_NETHERITE,
        7.0f,
        0.2f,
        () -> Ingredient.of(ModItems.NYXIUM_INGOT.get())
    ),
    CELESTIUM("celestium",
        70,
        new int[]{8, 13, 16, 9},
        30,
        SoundEvents.ARMOR_EQUIP_NETHERITE,
        8.0f,
        0.2f,
        () -> Ingredient.of(ModItems.CELESTIUM_INGOT.get())
    ),
    VOIDSTEEL("voidsteel",
        75,
        new int[]{9, 14, 17, 10},
        15,
        SoundEvents.ARMOR_EQUIP_NETHERITE,
        9.0f,
        0.3f,
        () -> Ingredient.of(ModItems.VOIDSTEEL_INGOT.get())
    );

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};

    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ModArmorMaterials(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue,
                      SoundEvent equipSound, float toughness, float knockbackResistance,
                      Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(@Nonnull ArmorItem.Type type) {
        return HEALTH_PER_SLOT[type.getSlot().getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(@Nonnull ArmorItem.Type type) {
        return this.slotProtections[type.getSlot().getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    @Override
    public String getName() {
        return "crucible:" + name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
