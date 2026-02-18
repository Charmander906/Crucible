package com.charmander906.crucible.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class VirtualMiningRegistry {

    public static final Map<Block, Float> VIRTUAL_LEVEL_OVERRIDES = new HashMap<>();

    static {
        VIRTUAL_LEVEL_OVERRIDES.put(Blocks.COPPER_ORE, 1.0f);
        VIRTUAL_LEVEL_OVERRIDES.put(Blocks.DEEPSLATE_COPPER_ORE, 1.0f);
        VIRTUAL_LEVEL_OVERRIDES.put(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("cavesanddepths:slate_copper_ore")), 1.0f);
        VIRTUAL_LEVEL_OVERRIDES.put(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("natures_spirit:chert_copper_ore")), 1.0f);

        VIRTUAL_LEVEL_OVERRIDES.put(Blocks.IRON_ORE, 1.75f);
        VIRTUAL_LEVEL_OVERRIDES.put(Blocks.DEEPSLATE_IRON_ORE, 1.75f);
        VIRTUAL_LEVEL_OVERRIDES.put(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("cavesanddepths:slate_iron_ore")), 1.75f);
        VIRTUAL_LEVEL_OVERRIDES.put(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("natures_spirit:chert_iron_ore")), 1.75f);

        VIRTUAL_LEVEL_OVERRIDES.put(Blocks.DIAMOND_ORE, 2.875f);
        VIRTUAL_LEVEL_OVERRIDES.put(Blocks.DEEPSLATE_DIAMOND_ORE, 2.875f);
        VIRTUAL_LEVEL_OVERRIDES.put(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("cavesanddepths:slate_diamond_ore")), 2.875f);
        VIRTUAL_LEVEL_OVERRIDES.put(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("natures_spirit:chert_diamond_ore")), 2.875f);

        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.TIN_ORE.get(), 1.25f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.LEAD_ORE.get(), 2.0f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.ZINC_ORE.get(), 2.125f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.SILVER_ORE.get(), 2.375f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), 2.75f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.NETHER_PALLADIUM_ORE.get(), 4f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(), 5f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.BLACK_VOLCANIUM_ORE.get(), 6f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.DEEPSLATE_COBALT_ORE.get(), 7f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.NETHER_ORICHALCUM_ORE.get(), 8f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.DEEPSLATE_TITANIUM_ORE.get(), 9f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.NETHER_ADAMANTIUM_ORE.get(), 10f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.END_NYXIUM_ORE.get(), 12f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.END_CELESTIUM_ORE.get(), 13f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.END_VOIDSTEEL_ORE.get(), 14f);

        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.TIN_BLOCK.get(), 1.5f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.BRONZE_BLOCK.get(), 1.75f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.LEAD_BLOCK.get(), 2.125f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.ZINC_BLOCK.get(), 2.25f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.BRASS_BLOCK.get(), 2.5f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.SILVER_BLOCK.get(), 2.75f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.STEEL_BLOCK.get(), 2.875f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.TUNGSTEN_BLOCK.get(), 3f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.PALLADIUM_BLOCK.get(), 5f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.MYTHRIL_BLOCK.get(), 6f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.VOLCANIUM_BLOCK.get(), 7f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.COBALT_BLOCK.get(), 8f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.ORICHALCUM_BLOCK.get(), 9f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.TITANIUM_BLOCK.get(), 10f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.ADAMANTIUM_BLOCK.get(), 11f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.DAEDRITE_BLOCK.get(), 12f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.NYXIUM_BLOCK.get(), 13f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.CELESTIUM_BLOCK.get(), 14f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.VOIDSTEEL_BLOCK.get(), 15f);

        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.RAW_TIN_BLOCK.get(), 1.5f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.RAW_LEAD_BLOCK.get(), 2.125f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.RAW_ZINC_BLOCK.get(), 2.25f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.RAW_SILVER_BLOCK.get(), 2.75f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.RAW_TUNGSTEN_BLOCK.get(), 3f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.RAW_PALLADIUM_BLOCK.get(), 5f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.RAW_MYTHRIL_BLOCK.get(), 6f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.RAW_VOLCANIUM_BLOCK.get(), 7f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.RAW_COBALT_BLOCK.get(), 8f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.RAW_ORICHALCUM_BLOCK.get(), 9f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.RAW_TITANIUM_BLOCK.get(), 10f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.RAW_ADAMANTIUM_BLOCK.get(), 11f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.RAW_NYXIUM_BLOCK.get(), 13f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.RAW_CELESTIUM_BLOCK.get(), 14f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.RAW_VOIDSTEEL_BLOCK.get(), 15f);
        
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.CRUCIBLE.get(), 1.25f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.REINFORCED_CRUCIBLE.get(), 2.5f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.SUPERHEATED_CRUCIBLE.get(), 6f);
        VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.HYPERCHARGED_CRUCIBLE.get(), 10f);

        // VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.INTERMEDIATE_ORE1.get(), 1.5f);
        // VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.INTERMEDIATE_ORE2.get(), 2.25f);
        // VIRTUAL_LEVEL_OVERRIDES.put(ModBlocks.INTERMEDIATE_ORE3.get(), 2.5f);
    }

    public static float getVirtualLevel(Block block) {
        return VIRTUAL_LEVEL_OVERRIDES.getOrDefault(block, 0f);
    }
}
