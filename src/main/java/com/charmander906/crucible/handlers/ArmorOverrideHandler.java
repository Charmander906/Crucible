package com.charmander906.crucible.handlers;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.UUID;

import com.charmander906.crucible.Crucible;

@Mod.EventBusSubscriber(modid = Crucible.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ArmorOverrideHandler {

    private static final Map<Item, Double> ARMOR_OVERRIDES = Map.ofEntries(
        Map.entry(Items.LEATHER_HELMET, 1.0),
        Map.entry(Items.LEATHER_CHESTPLATE, 4.0),
        Map.entry(Items.LEATHER_LEGGINGS, 3.0),
        Map.entry(Items.LEATHER_BOOTS, 1.0),

        Map.entry(Items.CHAINMAIL_HELMET, 2.0),
        Map.entry(Items.CHAINMAIL_CHESTPLATE, 4.0),
        Map.entry(Items.CHAINMAIL_LEGGINGS, 3.0),
        Map.entry(Items.CHAINMAIL_BOOTS, 2.0),

        Map.entry(Items.IRON_HELMET, 3.0),
        Map.entry(Items.IRON_CHESTPLATE, 6.0),
        Map.entry(Items.IRON_LEGGINGS, 5.0),
        Map.entry(Items.IRON_BOOTS, 3.0),

        Map.entry(Items.DIAMOND_HELMET, 5.0),
        Map.entry(Items.DIAMOND_CHESTPLATE, 10.0),
        Map.entry(Items.DIAMOND_LEGGINGS, 8.0),
        Map.entry(Items.DIAMOND_BOOTS, 5.0),

        Map.entry(Items.NETHERITE_HELMET, 5.0),
        Map.entry(Items.NETHERITE_CHESTPLATE, 10.0),
        Map.entry(Items.NETHERITE_LEGGINGS, 8.0),
        Map.entry(Items.NETHERITE_BOOTS, 5.0)
    );

    private static final Map<String, double[]> MODDED_ARMOR_OVERRIDES = Map.ofEntries(
        Map.entry("iceandfire:armor_red_helmet",          new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_red_chestplate",      new double[]{12.0, 3.0}),
        Map.entry("iceandfire:armor_red_leggings",        new double[]{10.0, 3.0}),
        Map.entry("iceandfire:armor_red_boots",           new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_copper_helmet",          new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_copper_chestplate",      new double[]{12.0, 3.0}),
        Map.entry("iceandfire:armor_copper_leggings",        new double[]{10.0, 3.0}),
        Map.entry("iceandfire:armor_copper_boots",           new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_bronze_helmet",          new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_bronze_chestplate",      new double[]{12.0, 3.0}),
        Map.entry("iceandfire:armor_bronze_leggings",        new double[]{10.0, 3.0}),
        Map.entry("iceandfire:armor_bronze_boots",           new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_black_helmet",          new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_black_chestplate",      new double[]{12.0, 3.0}),
        Map.entry("iceandfire:armor_black_leggings",        new double[]{10.0, 3.0}),
        Map.entry("iceandfire:armor_black_boots",           new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_amythest_helmet",          new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_amythest_chestplate",      new double[]{12.0, 3.0}),
        Map.entry("iceandfire:armor_amythest_leggings",        new double[]{10.0, 3.0}),
        Map.entry("iceandfire:armor_amythest_boots",           new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_electric_helmet",          new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_electric_chestplate",      new double[]{12.0, 3.0}),
        Map.entry("iceandfire:armor_electric_leggings",        new double[]{10.0, 3.0}),
        Map.entry("iceandfire:armor_electric_boots",           new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_gray_helmet",          new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_gray_chestplate",      new double[]{12.0, 3.0}),
        Map.entry("iceandfire:armor_gray_leggings",        new double[]{10.0, 3.0}),
        Map.entry("iceandfire:armor_gray_boots",           new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_green_helmet",          new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_green_chestplate",      new double[]{12.0, 3.0}),
        Map.entry("iceandfire:armor_green_leggings",        new double[]{10.0, 3.0}),
        Map.entry("iceandfire:armor_green_boots",           new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_sapphire_helmet",          new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_sapphire_chestplate",      new double[]{12.0, 3.0}),
        Map.entry("iceandfire:armor_sapphire_leggings",        new double[]{10.0, 3.0}),
        Map.entry("iceandfire:armor_sapphire_boots",           new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_blue_helmet",          new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_blue_chestplate",      new double[]{12.0, 3.0}),
        Map.entry("iceandfire:armor_blue_leggings",        new double[]{10.0, 3.0}),
        Map.entry("iceandfire:armor_blue_boots",           new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_silver_helmet",          new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_silver_chestplate",      new double[]{12.0, 3.0}),
        Map.entry("iceandfire:armor_silver_leggings",        new double[]{10.0, 3.0}),
        Map.entry("iceandfire:armor_silver_boots",           new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_white_helmet",          new double[]{7.0, 3.0}),
        Map.entry("iceandfire:armor_white_chestplate",      new double[]{12.0, 3.0}),
        Map.entry("iceandfire:armor_white_leggings",        new double[]{10.0, 3.0}),
        Map.entry("iceandfire:armor_white_boots",           new double[]{7.0, 3.0}),

        Map.entry("iceandfire:tide_blue_helmet",          new double[]{7.0, 2.5}),
        Map.entry("iceandfire:tide_blue_chestplate",      new double[]{12.0, 2.5}),
        Map.entry("iceandfire:tide_blue_leggings",        new double[]{10.0, 2.5}),
        Map.entry("iceandfire:tide_blue_boots",           new double[]{7.0, 2.5}),
        Map.entry("iceandfire:tide_teal_helmet",          new double[]{7.0, 2.5}),
        Map.entry("iceandfire:tide_teal_chestplate",      new double[]{12.0, 2.5}),
        Map.entry("iceandfire:tide_teal_leggings",        new double[]{10.0, 2.5}),
        Map.entry("iceandfire:tide_teal_boots",           new double[]{7.0, 2.5}),
        Map.entry("iceandfire:tide_red_helmet",          new double[]{7.0, 2.5}),
        Map.entry("iceandfire:tide_red_chestplate",      new double[]{12.0, 2.5}),
        Map.entry("iceandfire:tide_red_leggings",        new double[]{10.0, 2.5}),
        Map.entry("iceandfire:tide_red_boots",           new double[]{7.0, 2.5}),
        Map.entry("iceandfire:tide_deepblue_helmet",          new double[]{7.0, 2.5}),
        Map.entry("iceandfire:tide_deepblue_chestplate",      new double[]{12.0, 2.5}),
        Map.entry("iceandfire:tide_deepblue_leggings",        new double[]{10.0, 2.5}),
        Map.entry("iceandfire:tide_deepblue_boots",           new double[]{7.0, 2.5}),
        Map.entry("iceandfire:tide_green_helmet",          new double[]{7.0, 2.5}),
        Map.entry("iceandfire:tide_green_chestplate",      new double[]{12.0, 2.5}),
        Map.entry("iceandfire:tide_green_leggings",        new double[]{10.0, 2.5}),
        Map.entry("iceandfire:tide_green_boots",           new double[]{7.0, 2.5}),
        Map.entry("iceandfire:tide_purple_helmet",          new double[]{7.0, 2.5}),
        Map.entry("iceandfire:tide_purple_chestplate",      new double[]{12.0, 2.5}),
        Map.entry("iceandfire:tide_purple_leggings",        new double[]{10.0, 2.5}),
        Map.entry("iceandfire:tide_purple_boots",           new double[]{7.0, 2.5}),
        Map.entry("iceandfire:tide_bronze_helmet",          new double[]{7.0, 2.5}),
        Map.entry("iceandfire:tide_bronze_chestplate",      new double[]{12.0, 2.5}),
        Map.entry("iceandfire:tide_bronze_leggings",        new double[]{10.0, 2.5}),
        Map.entry("iceandfire:tide_bronze_boots",           new double[]{7.0, 2.5}),
        
        Map.entry("iceandfire:forest_troll_leather_helmet",          new double[]{3.0, 1.0}),
        Map.entry("iceandfire:forest_troll_leather_chestplate",      new double[]{10.0, 1.0}),
        Map.entry("iceandfire:forest_troll_leather_leggings",        new double[]{7.0, 1.0}),
        Map.entry("iceandfire:forest_troll_leather_boots",           new double[]{4.0, 1.0}),
        Map.entry("iceandfire:mountain_troll_leather_helmet",          new double[]{3.0, 1.0}),
        Map.entry("iceandfire:mountain_troll_leather_chestplate",      new double[]{10.0, 1.0}),
        Map.entry("iceandfire:mountain_troll_leather_leggings",        new double[]{7.0, 1.0}),
        Map.entry("iceandfire:mountain_troll_leather_boots",           new double[]{4.0, 1.0}),
        Map.entry("iceandfire:frost_troll_leather_helmet",          new double[]{3.0, 1.0}),
        Map.entry("iceandfire:frost_troll_leather_chestplate",      new double[]{10.0, 1.0}),
        Map.entry("iceandfire:frost_troll_leather_leggings",        new double[]{7.0, 1.0}),
        Map.entry("iceandfire:frost_troll_leather_boots",           new double[]{4.0, 1.0}),
        
        Map.entry("irons_spellbooks:netherite_mage_helmet",          new double[]{4.0, 3.0}),
        Map.entry("irons_spellbooks:netherite_mage_chestplate",      new double[]{11.0, 3.0}),
        Map.entry("irons_spellbooks:netherite_mage_leggings",        new double[]{8.0, 3.0}),
        Map.entry("irons_spellbooks:netherite_mage_boots",           new double[]{4.0, 3.0}),
        
        Map.entry("cataclysm:ignitium_helmet",          new double[]{8.0, 6.5}),
        Map.entry("cataclysm:ignitium_chestplate",      new double[]{14.0, 6.5}),
        Map.entry("cataclysm:ignitium_leggings",        new double[]{12.0, 6.5}),
        Map.entry("cataclysm:ignitium_boots",           new double[]{8.0, 6.5}),
        
        Map.entry("cataclysm:cursium_helmet",          new double[]{7.0, 6.0}),
        Map.entry("cataclysm:cursium_chestplate",      new double[]{13.0, 6.0}),
        Map.entry("cataclysm:cursium_leggings",        new double[]{11.0, 6.0}),
        Map.entry("cataclysm:cursium_boots",           new double[]{7.0, 6.0}),
        
        Map.entry("cataclysm:bone_reptile_helmet",          new double[]{8.0, 4.0}),
        Map.entry("cataclysm:bone_reptile_chestplate",      new double[]{14.0, 4.0}),
        Map.entry("cataclysm:monstrous_helm",               new double[]{4.0, 4.0}),
        Map.entry("cataclysm:bloom_stone_pauldrons",        new double[]{11.0, 2.0})
    );

    private static final UUID ARMOR_UUID_HELMET = UUID.fromString("10e08d25-233d-459d-99fb-a9e3b6c7d3a1");
    private static final UUID ARMOR_UUID_CHEST = UUID.fromString("289c79a8-b0ba-4103-b1bd-8e56e014df58");
    private static final UUID ARMOR_UUID_LEGS = UUID.fromString("495ac1fd-a607-4d6e-b830-b84d888fff1f");
    private static final UUID ARMOR_UUID_BOOTS = UUID.fromString("c38d6b57-e828-4a94-982f-d470a780f3a9");

    private static final UUID TOUGH_UUID_HELMET = UUID.fromString("c2e5d4f2-0000-4f2a-bbbb-111111111111");
    private static final UUID TOUGH_UUID_CHEST = UUID.fromString("c2e5d4f2-0000-4f2a-bbbb-222222222222");
    private static final UUID TOUGH_UUID_LEGS = UUID.fromString("c2e5d4f2-0000-4f2a-bbbb-333333333333");
    private static final UUID TOUGH_UUID_BOOTS = UUID.fromString("c2e5d4f2-0000-4f2a-bbbb-444444444444");

    @SubscribeEvent
    public static void onArmorModifiers(ItemAttributeModifierEvent event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();

        EquipmentSlot slot = event.getSlotType();
        if (slot.getType() != EquipmentSlot.Type.ARMOR) return;

        if (!item.canEquip(stack, slot, null)) return;

        Double newArmor = ARMOR_OVERRIDES.get(item);
        Double newToughness = null;

        if (newArmor == null) {
            var key = ForgeRegistries.ITEMS.getKey(item);
            if (key != null) {
                String id = key.toString();
                double[] values = MODDED_ARMOR_OVERRIDES.get(id);
                if (values != null) {
                    newArmor = values[0];
                    newToughness = values[1];
                }
            }
        }

        if (newArmor == null && newToughness == null) return;

        UUID armorUUID = getArmorUuid(slot);
        UUID toughUUID = getToughnessUuid(slot);

        if (newArmor != null) {
            event.removeAttribute(Attributes.ARMOR);

            event.addModifier(
                Attributes.ARMOR,
                new AttributeModifier(
                    armorUUID,
                    "custom_armor_override",
                    newArmor,
                    AttributeModifier.Operation.ADDITION
                )
            );
        }

        if (newToughness != null) {
            event.removeAttribute(Attributes.ARMOR_TOUGHNESS);

            event.addModifier(
                Attributes.ARMOR_TOUGHNESS,
                new AttributeModifier(
                    toughUUID,
                    "custom_armor_toughness_override",
                    newToughness,
                    AttributeModifier.Operation.ADDITION
                )
            );
        }
    }

    private static UUID getArmorUuid(EquipmentSlot slot) {
        return switch (slot) {
            case HEAD -> ARMOR_UUID_HELMET;
            case CHEST -> ARMOR_UUID_CHEST;
            case LEGS -> ARMOR_UUID_LEGS;
            case FEET -> ARMOR_UUID_BOOTS;
            default -> ARMOR_UUID_HELMET;
        };
    }

    private static UUID getToughnessUuid(EquipmentSlot slot) {
        return switch (slot) {
            case HEAD -> TOUGH_UUID_HELMET;
            case CHEST -> TOUGH_UUID_CHEST;
            case LEGS -> TOUGH_UUID_LEGS;
            case FEET -> TOUGH_UUID_BOOTS;
            default -> TOUGH_UUID_HELMET;
        };
    }
}
