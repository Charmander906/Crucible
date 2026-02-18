package com.charmander906.crucible.handlers;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.UUID;

import com.charmander906.crucible.Crucible;

@Mod.EventBusSubscriber(modid = Crucible.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ToolAttackOverrideHandler {

    private static final Map<Item, Double> TOOL_ATTACK_OVERRIDES = Map.ofEntries(
        Map.entry(Items.WOODEN_SWORD, 3.0),
        Map.entry(Items.WOODEN_AXE, 4.5),
        Map.entry(Items.WOODEN_PICKAXE, 1.5),
        Map.entry(Items.WOODEN_SHOVEL, 2.0),
        Map.entry(Items.WOODEN_HOE, 1.0),

        Map.entry(Items.STONE_SWORD, 3.5),
        Map.entry(Items.STONE_AXE, 5.0),
        Map.entry(Items.STONE_PICKAXE, 1.5),
        Map.entry(Items.STONE_SHOVEL, 2.0),
        Map.entry(Items.STONE_HOE, 1.0),

        Map.entry(Items.IRON_SWORD, 6.0),
        Map.entry(Items.IRON_AXE, 9.0),
        Map.entry(Items.IRON_PICKAXE, 2.5),
        Map.entry(Items.IRON_SHOVEL, 3.5),
        Map.entry(Items.IRON_HOE, 1.0),

        Map.entry(Items.DIAMOND_SWORD, 11.0),
        Map.entry(Items.DIAMOND_AXE, 16.5),
        Map.entry(Items.DIAMOND_PICKAXE, 4.5),
        Map.entry(Items.DIAMOND_SHOVEL, 5.5),
        Map.entry(Items.DIAMOND_HOE, 1.5),

        Map.entry(Items.NETHERITE_SWORD, 11.5),
        Map.entry(Items.NETHERITE_AXE, 18.0),
        Map.entry(Items.NETHERITE_PICKAXE, 4.5),
        Map.entry(Items.NETHERITE_SHOVEL, 6.0),
        Map.entry(Items.NETHERITE_HOE, 1.5),

        Map.entry(Items.TRIDENT, 12.0)
    );

    private static final Map<String, Double> MODDED_TOOL_OVERRIDES = Map.ofEntries(
        Map.entry("crucible:copper_axe", 6.0),
        Map.entry("crucible:copper_sword", 4.0),
        Map.entry("crucible:copper_shovel", 2.5),
        Map.entry("crucible:copper_pickaxe", 1.5),
        Map.entry("crucible:copper_hoe", 1.0),
        
        Map.entry("crucible:tin_axe", 7.0),
        Map.entry("crucible:tin_sword", 4.5),
        Map.entry("crucible:tin_shovel", 2.5),
        Map.entry("crucible:tin_pickaxe", 2.0),
        Map.entry("crucible:tin_hoe", 1.0),
        
        Map.entry("crucible:bronze_axe", 8.0),
        Map.entry("crucible:bronze_sword", 5.0),
        Map.entry("crucible:bronze_shovel", 3.0),
        Map.entry("crucible:bronze_pickaxe", 2.0),
        Map.entry("crucible:bronze_hoe", 1.0),
        
        Map.entry("crucible:lead_axe", 10.0),
        Map.entry("crucible:lead_sword", 6.5),
        Map.entry("crucible:lead_shovel", 3.5),
        Map.entry("crucible:lead_pickaxe", 2.5),
        Map.entry("crucible:lead_hoe", 1.0),
        
        Map.entry("crucible:zinc_axe", 11.0),
        Map.entry("crucible:zinc_sword", 7.0),
        Map.entry("crucible:zinc_shovel", 4.0),
        Map.entry("crucible:zinc_pickaxe", 3.0),
        Map.entry("crucible:zinc_hoe", 1.0),
        
        Map.entry("crucible:brass_axe", 12.0),
        Map.entry("crucible:brass_sword", 8.0),
        Map.entry("crucible:brass_shovel", 4.0),
        Map.entry("crucible:brass_pickaxe", 3.0),
        Map.entry("crucible:brass_hoe", 1.0),
        
        Map.entry("crucible:silver_axe", 13.0),
        Map.entry("crucible:silver_sword", 8.5),
        Map.entry("crucible:silver_shovel", 4.5),
        Map.entry("crucible:silver_pickaxe", 3.5),
        Map.entry("crucible:silver_hoe", 1.5),
        
        Map.entry("crucible:steel_axe", 14.5),
        Map.entry("crucible:steel_sword", 9.5),
        Map.entry("crucible:steel_shovel", 5.0),
        Map.entry("crucible:steel_pickaxe", 3.5),
        Map.entry("crucible:steel_hoe", 1.5),
        
        Map.entry("crucible:tungsten_axe", 15.5),
        Map.entry("crucible:tungsten_sword", 10.0),
        Map.entry("crucible:tungsten_shovel", 5.0),
        Map.entry("crucible:tungsten_pickaxe", 4.0),
        Map.entry("crucible:tungsten_hoe", 1.5),
        
        Map.entry("crucible:palladium_axe", 19.0),
        Map.entry("crucible:palladium_sword", 12.5),
        Map.entry("crucible:palladium_shovel", 6.0),
        Map.entry("crucible:palladium_pickaxe", 5.0),
        Map.entry("crucible:palladium_hoe", 1.5),
        
        Map.entry("crucible:mythril_axe", 20.5),
        Map.entry("crucible:mythril_sword", 13.5),
        Map.entry("crucible:mythril_shovel", 6.5),
        Map.entry("crucible:mythril_pickaxe", 5.0),
        Map.entry("crucible:mythril_hoe", 2.0),
        
        Map.entry("crucible:volcanium_axe", 21.5),
        Map.entry("crucible:volcanium_sword", 14.5),
        Map.entry("crucible:volcanium_shovel", 7.0),
        Map.entry("crucible:volcanium_pickaxe", 5.5),
        Map.entry("crucible:volcanium_hoe", 2.0),
        
        Map.entry("crucible:cobalt_axe", 23.0),
        Map.entry("crucible:cobalt_sword", 15.5),
        Map.entry("crucible:cobalt_shovel", 7.5),
        Map.entry("crucible:cobalt_pickaxe", 5.5),
        Map.entry("crucible:cobalt_hoe", 2.0),
        
        Map.entry("crucible:orichalcum_axe", 24.5),
        Map.entry("crucible:orichalcum_sword", 16.5),
        Map.entry("crucible:orichalcum_shovel", 7.5),
        Map.entry("crucible:orichalcum_pickaxe", 6.0),
        Map.entry("crucible:orichalcum_hoe", 2.0),
        
        Map.entry("crucible:titanium_axe", 26.0),
        Map.entry("crucible:titanium_sword", 17.5),
        Map.entry("crucible:titanium_shovel", 8.0),
        Map.entry("crucible:titanium_pickaxe", 6.0),
        Map.entry("crucible:titanium_hoe", 2.5),
        
        Map.entry("crucible:adamantium_axe", 27.5),
        Map.entry("crucible:adamantium_sword", 18.5),
        Map.entry("crucible:adamantium_shovel", 8.5),
        Map.entry("crucible:adamantium_pickaxe", 6.5),
        Map.entry("crucible:adamantium_hoe", 2.5),
        
        Map.entry("crucible:daedrite_axe", 29.5),
        Map.entry("crucible:daedrite_sword", 19.5),
        Map.entry("crucible:daedrite_shovel", 9.0),
        Map.entry("crucible:daedrite_pickaxe", 6.5),
        Map.entry("crucible:daedrite_hoe", 2.5),
        
        Map.entry("crucible:nyxium_axe", 31.0),
        Map.entry("crucible:nyxium_sword", 21.0),
        Map.entry("crucible:nyxium_shovel", 9.0),
        Map.entry("crucible:nyxium_pickaxe", 7.0),
        Map.entry("crucible:nyxium_hoe", 2.5),
        
        Map.entry("crucible:celestium_axe", 33.0),
        Map.entry("crucible:celestium_sword", 22.0),
        Map.entry("crucible:celestium_shovel", 9.5),
        Map.entry("crucible:celestium_pickaxe", 7.5),
        Map.entry("crucible:celestium_hoe", 3.0),
        
        Map.entry("crucible:voidsteel_axe", 35.0),
        Map.entry("crucible:voidsteel_sword", 23.5),
        Map.entry("crucible:voidsteel_shovel", 10.0),
        Map.entry("crucible:voidsteel_pickaxe", 7.5),
        Map.entry("crucible:voidsteel_hoe", 3.0),

        Map.entry("iceandfire:hippocampus_slapper", 2.5),

        Map.entry("irons_spellbooks:graybeard_staff", 3.5),

        Map.entry("irons_spellbooks:artificer_cane", 5.0),
        Map.entry("atlas_additions:cleric_mace", 5.0),

        Map.entry("iceandfire:myrmex_desert_sword", 6.0),
        Map.entry("iceandfire:myrmex_jungle_sword", 6.0),
        Map.entry("iceandfire:myrmex_desert_sword_venom", 6.0),
        Map.entry("iceandfire:myrmex_jungle_sword_venom", 6.0),
        Map.entry("iceandfire:amphithere_macuahuitl", 6.0),
        Map.entry("irons_spellbooks:ice_staff", 6.0),
        Map.entry("irons_spellbooks:lightning_rod", 6.0),

        Map.entry("atlas_additions:illager_standard", 7.5),
        Map.entry("atlas_additions:centella", 7.5),
        Map.entry("atlas_additions:ambrosia", 7.5),
        Map.entry("atlas_additions:eternal_torch", 7.5),
        Map.entry("atlas_additions:gazer_staff", 7.5),
        Map.entry("iceandfire:stymphalian_bird_dagger", 7.5),

        Map.entry("iceandfire:hippogryph_sword", 8.0),

        Map.entry("iceandfire:myrmex_jungle_axe", 8.5),
        Map.entry("iceandfire:myrmex_desert_axe", 8.5),
        Map.entry("irons_spellbooks:magehunter", 8.5),

        Map.entry("cataclysm:the_immolator", 9.5),
        Map.entry("cataclysm:the_annihilator", 9.5),

        Map.entry("cataclysm:tidal_claws", 10.0),
        Map.entry("irons_spellbooks:blood_staff", 10.0),
        Map.entry("irons_spellbooks:amethyst_rapier", 10.0),
        Map.entry("atlas_additions:sculk_staff", 10.0),
        Map.entry("atlas_additions:sarmiento", 10.0),
        Map.entry("atlas_additions:ruego_al_alba", 10.0),
        Map.entry("iceandfire:dragonbone_sword", 12.0),

        Map.entry("cataclysm:meat_shredder", 10.5),

        Map.entry("enlightened_end:rooting_blade", 11.0),

        Map.entry("iceandfire:dragonbone_sword_fire", 14.0),
        Map.entry("iceandfire:dragonbone_sword_ice", 14.0),
        Map.entry("iceandfire:dragonbone_sword_lightning", 14.0),
        Map.entry("cataclysm:ancient_spear", 12.0),

        Map.entry("iceandfire:dragonbone_axe", 14.5),
        Map.entry("irons_spellbooks:spellbreaker", 12.5),
        Map.entry("atlas_additions:mea_culpa", 12.5),
        Map.entry("cataclysm:astrape", 12.5),

        Map.entry("cataclysm:gauntlet_of_guard", 13.5),
        Map.entry("cataclysm:gauntlet_of_bulwark", 13.5),
        Map.entry("cataclysm:gauntlet_of_maelstrom", 13.5),
        Map.entry("irons_spellbooks:keeper_flamberge", 13.5),
        Map.entry("iceandfire:ghost_sword", 13.5),

        Map.entry("atlas_additions:flaming_blade", 15.0),
        Map.entry("atlas_additions:bandaged_blade", 15.0),

        Map.entry("iceandfire:tide_trident", 16.0),
        Map.entry("cataclysm:infernal_forge", 16.0),
        Map.entry("cataclysm:void_forge", 16.0),

        Map.entry("cataclysm:the_incinerator", 17.5),

        Map.entry("atlas_additions:veredicto", 19.0),
        Map.entry("cataclysm:soul_render", 19.0),

        Map.entry("cataclysm:ceraunus", 20.0),

        Map.entry("iceandfire:troll_weapon_axe", 21.5),
        Map.entry("iceandfire:troll_weapon_hammer", 21.5),
        Map.entry("iceandfire:troll_weapon_trunk", 21.5),
        Map.entry("iceandfire:troll_weapon_trunk_frost", 21.5),
        Map.entry("iceandfire:troll_weapon_column", 21.5),
        Map.entry("iceandfire:troll_weapon_column_forest", 21.5),
        Map.entry("iceandfire:troll_weapon_column_frost", 21.5)
    );

    private static final UUID TOOL_ATTACK_MODIFIER_UUID = UUID.fromString("f3b8d6c4-9a1e-4b2c-b9f2-8d0d6a2f7c6e");

    @SubscribeEvent
    public static void onToolAttackModifiers(ItemAttributeModifierEvent event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();

        Double newAttack = TOOL_ATTACK_OVERRIDES.get(item);

        if (newAttack == null) {
            var key = ForgeRegistries.ITEMS.getKey(item);
            if (key == null) return;
            String id = key.toString();
            newAttack = MODDED_TOOL_OVERRIDES.get(id);
        }

        if (newAttack == null) return;

        if (event.getSlotType() != net.minecraft.world.entity.EquipmentSlot.MAINHAND) return;

        event.removeAttribute(Attributes.ATTACK_DAMAGE);

        event.addModifier(Attributes.ATTACK_DAMAGE, new AttributeModifier(
                TOOL_ATTACK_MODIFIER_UUID,
                "custom_tool_attack_override",
                newAttack,
                AttributeModifier.Operation.ADDITION
        ));
    }
}
