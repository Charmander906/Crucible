package com.charmander906.crucible.registry;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Supplier;
import com.charmander906.crucible.Crucible;
import com.charmander906.crucible.common.ObsidianskinTonicItem;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class ModItems {
        public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, Crucible.MODID);

        public static final List<RegistryObject<? extends Item>> ORDERED_ITEMS = new ArrayList<>();

        private static <T extends Item> RegistryObject<T> register(String name, Supplier<? extends T> supplier) {
                RegistryObject<T> item = ITEMS.register(name, supplier);
                ORDERED_ITEMS.add(item);
                return item;
        }


        /* 
         *  █████ █   █  ███   ███  █████   █████ █████ █████ ██ ██  ████
         *    █   ██  █ █     █   █   █       █     █   █     █ █ █ █
         *    █   █ █ █ █  ██ █   █   █       █     █   ████  █ █ █  ███
         *    █   █  ██ █   █ █   █   █       █     █   █     █ █ █     █
         *  █████ █   █  ███   ███    █     █████   █   █████ █ █ █ ████
         */

        public static final RegistryObject<Item> TIN_INGOT =
                register("tin_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_INGOT =
                register("bronze_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> LEAD_INGOT =
                register("lead_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> ZINC_INGOT =
                register("zinc_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> BRASS_INGOT =
                register("brass_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> SILVER_INGOT =
                register("silver_ingot", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> STEEL_INGOT =
                register("steel_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> TUNGSTEN_INGOT =
                register("tungsten_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> PALLADIUM_INGOT =
                register("palladium_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> MYTHRIL_INGOT =
                register("mythril_ingot", () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> VOLCANIUM_INGOT =
                register("volcanium_ingot", () -> new Item(new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> COBALT_INGOT =
                register("cobalt_ingot", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> ORICHALCUM_INGOT =
                register("orichalcum_ingot", () -> new Item(new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> TITANIUM_INGOT =
                register("titanium_ingot", () -> new Item(new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> ADAMANTIUM_INGOT =
                register("adamantium_ingot", () -> new Item(new Item.Properties().fireResistant()));

        public static final RegistryObject<Item> HYPERSPARK_ALLOY = 
                register("hyperspark_alloy", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
        public static final RegistryObject<Item> FIRESTORM_ALLOY = 
                register("firestorm_alloy", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
        public static final RegistryObject<Item> WITHERBLIGHT_ALLOY = 
                register("witherblight_alloy", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
        
        public static final RegistryObject<Item> TITANIUM_SHEET =
                register("titanium_sheet", () -> new Item(new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> TRIWIRE_LATTICE =
                register("triwire_lattice", () -> new Item(new Item.Properties().fireResistant()));

        public static final RegistryObject<Item> DAEDRITE_INGOT =
                register("daedrite_ingot", () -> new Item(new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> NYXIUM_INGOT =
                register("nyxium_ingot", () -> new Item(new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> CELESTIUM_INGOT =
                register("celestium_ingot", () -> new Item(new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> VOIDSTEEL_INGOT =
                register("voidsteel_ingot", () -> new Item(new Item.Properties().fireResistant()));
        
        /* 
         *   ███  ████  █████   ████  █      ███   ███  █  █  ████
         *  █   █ █   █ █       █   █ █     █   █ █   █ █ █  █
         *  █   █ ████  ████    ████  █     █   █ █     ██    ███
         *  █   █ █   █ █       █   █ █     █   █ █   █ █ █      █
         *   ███  █   █ █████   ████  █████  ███   ███  █  █ ████
         */

        public static final RegistryObject<Item> TIN_ORE =
                register("tin_ore", () -> new BlockItem(ModBlocks.TIN_ORE.get(), new Item.Properties()));
        public static final RegistryObject<Item> LEAD_ORE =
                register("lead_ore", () -> new BlockItem(ModBlocks.LEAD_ORE.get(), new Item.Properties()));
        public static final RegistryObject<Item> ZINC_ORE =
                register("zinc_ore", () -> new BlockItem(ModBlocks.ZINC_ORE.get(), new Item.Properties()));
        public static final RegistryObject<Item> SILVER_ORE =
                register("silver_ore", () -> new BlockItem(ModBlocks.SILVER_ORE.get(), new Item.Properties()));
        public static final RegistryObject<Item> DEEPSLATE_TUNGSTEN_ORE =
                register("deepslate_tungsten_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), new Item.Properties()));
        public static final RegistryObject<Item> NETHER_PALLADIUM_ORE =
                register("nether_palladium_ore", () -> new BlockItem(ModBlocks.NETHER_PALLADIUM_ORE.get(), new Item.Properties()));
        public static final RegistryObject<Item> DEEPSLATE_MYTHRIL_ORE =
                register("deepslate_mythril_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(), new Item.Properties()));
        public static final RegistryObject<Item> BLACK_VOLCANIUM_ORE =
                register("black_volcanium_ore", () -> new BlockItem(ModBlocks.BLACK_VOLCANIUM_ORE.get(), new Item.Properties()));
        public static final RegistryObject<Item> DEEPSLATE_COBALT_ORE =
                register("deepslate_cobalt_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_COBALT_ORE.get(), new Item.Properties()));
        public static final RegistryObject<Item> NETHER_ORICHALCUM_ORE =
                register("nether_orichalcum_ore", () -> new BlockItem(ModBlocks.NETHER_ORICHALCUM_ORE.get(), new Item.Properties()));
        public static final RegistryObject<Item> DEEPSLATE_TITANIUM_ORE =
                register("deepslate_titanium_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_TITANIUM_ORE.get(), new Item.Properties()));
        public static final RegistryObject<Item> NETHER_ADAMANTIUM_ORE =
                register("nether_adamantium_ore", () -> new BlockItem(ModBlocks.NETHER_ADAMANTIUM_ORE.get(), new Item.Properties()));
        public static final RegistryObject<Item> END_NYXIUM_ORE =
                register("end_nyxium_ore", () -> new BlockItem(ModBlocks.END_NYXIUM_ORE.get(), new Item.Properties()));
        public static final RegistryObject<Item> END_CELESTIUM_ORE =
                register("end_celestium_ore", () -> new BlockItem(ModBlocks.END_CELESTIUM_ORE.get(), new Item.Properties()));
        public static final RegistryObject<Item> END_VOIDSTEEL_ORE =
                register("end_voidsteel_ore", () -> new BlockItem(ModBlocks.END_VOIDSTEEL_ORE.get(), new Item.Properties()));

        /* 
         *  ████   ███  █   █   █████ █████ █████ ██ ██  ████
         *  █   █ █   █ █   █     █     █   █     █ █ █ █
         *  ████  █████ █ █ █     █     █   ████  █ █ █  ███
         *  █   █ █   █ █ █ █     █     █   █     █ █ █     █
         *  █   █ █   █  █ █    █████   █   █████ █ █ █ ████
         */
        
        public static final RegistryObject<Item> RAW_TIN =
                register("raw_tin", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_LEAD =
                register("raw_lead", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_ZINC =
                register("raw_zinc", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_SILVER =
                register("raw_silver", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_TUNGSTEN =
                register("raw_tungsten", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_PALLADIUM =
                register("raw_palladium", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_MYTHRIL =
                register("raw_mythril", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_VOLCANIUM =
                register("raw_volcanium", () -> new Item(new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> RAW_COBALT =
                register("raw_cobalt", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_ORICHALCUM =
                register("raw_orichalcum", () -> new Item(new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> RAW_TITANIUM =
                register("raw_titanium", () -> new Item(new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> RAW_ADAMANTIUM =
                register("raw_adamantium", () -> new Item(new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> RAW_NYXIUM =
                register("raw_nyxium", () -> new Item(new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> RAW_CELESTIUM =
                register("raw_celestium", () -> new Item(new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> RAW_VOIDSTEEL_SHARD =
                register("raw_voidsteel_shard", () -> new Item(new Item.Properties().fireResistant()));
        
        /* 
         *  █████  ███   ███  █      ████
         *    █   █   █ █   █ █     █
         *    █   █   █ █   █ █      ███
         *    █   █   █ █   █ █         █
         *    █    ███   ███  █████ ████
         *
         *   ███  ████  ██ ██  ███  ████
         *  █   █ █   █ █ █ █ █   █ █   █
         *  █████ ████  █ █ █ █   █ ████
         *  █   █ █   █ █ █ █ █   █ █   █
         *  █   █ █   █ █ █ █  ███  █   █
         */
        
        public static final RegistryObject<SwordItem> COPPER_SWORD = register("copper_sword",
                () -> new SwordItem(
                        ModToolTiers.COPPER,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> COPPER_PICKAXE = register("copper_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.COPPER,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> COPPER_AXE = register("copper_axe",
                () -> new AxeItem(
                        ModToolTiers.COPPER,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> COPPER_SHOVEL = register("copper_shovel",
                () -> new ShovelItem(
                        ModToolTiers.COPPER,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> COPPER_HOE = register("copper_hoe",
                () -> new HoeItem(
                        ModToolTiers.COPPER,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> COPPER_HELMET = register("copper_helmet",
                () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<ArmorItem> COPPER_CHESTPLATE = register("copper_chestplate",
                () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<ArmorItem> COPPER_LEGGINGS = register("copper_leggings",
                () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<ArmorItem> COPPER_BOOTS = register("copper_boots",
                () -> new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Properties()));

        public static final RegistryObject<SwordItem> TIN_SWORD = register("tin_sword",
                () -> new SwordItem(
                        ModToolTiers.TIN,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> TIN_PICKAXE = register("tin_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.TIN,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> TIN_AXE = register("tin_axe",
                () -> new AxeItem(
                        ModToolTiers.TIN,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> TIN_SHOVEL = register("tin_shovel",
                () -> new ShovelItem(
                        ModToolTiers.TIN,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> TIN_HOE = register("tin_hoe",
                () -> new HoeItem(
                        ModToolTiers.TIN,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> TIN_HELMET = register("tin_helmet",
                () -> new ArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<ArmorItem> TIN_CHESTPLATE = register("tin_chestplate",
                () -> new ArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<ArmorItem> TIN_LEGGINGS = register("tin_leggings",
                () -> new ArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<ArmorItem> TIN_BOOTS = register("tin_boots",
                () -> new ArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.BOOTS, new Item.Properties()));

        public static final RegistryObject<SwordItem> BRONZE_SWORD = register("bronze_sword",
                () -> new SwordItem(
                        ModToolTiers.BRONZE,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> BRONZE_PICKAXE = register("bronze_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.BRONZE,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> BRONZE_AXE = register("bronze_axe",
                () -> new AxeItem(
                        ModToolTiers.BRONZE,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> BRONZE_SHOVEL = register("bronze_shovel",
                () -> new ShovelItem(
                        ModToolTiers.BRONZE,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> BRONZE_HOE = register("bronze_hoe",
                () -> new HoeItem(
                        ModToolTiers.BRONZE,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> BRONZE_HELMET = register("bronze_helmet",
                () -> new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<ArmorItem> BRONZE_CHESTPLATE = register("bronze_chestplate",
                () -> new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<ArmorItem> BRONZE_LEGGINGS = register("bronze_leggings",
                () -> new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<ArmorItem> BRONZE_BOOTS = register("bronze_boots",
                () -> new ArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.BOOTS, new Item.Properties()));

        public static final RegistryObject<SwordItem> LEAD_SWORD = register("lead_sword",
                () -> new SwordItem(
                        ModToolTiers.LEAD,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> LEAD_PICKAXE = register("lead_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.LEAD,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> LEAD_AXE = register("lead_axe",
                () -> new AxeItem(
                        ModToolTiers.LEAD,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> LEAD_SHOVEL = register("lead_shovel",
                () -> new ShovelItem(
                        ModToolTiers.LEAD,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> LEAD_HOE = register("lead_hoe",
                () -> new HoeItem(
                        ModToolTiers.LEAD,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> LEAD_HELMET = register("lead_helmet",
                () -> new ArmorItem(ModArmorMaterials.LEAD, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<ArmorItem> LEAD_CHESTPLATE = register("lead_chestplate",
                () -> new ArmorItem(ModArmorMaterials.LEAD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<ArmorItem> LEAD_LEGGINGS = register("lead_leggings",
                () -> new ArmorItem(ModArmorMaterials.LEAD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<ArmorItem> LEAD_BOOTS = register("lead_boots",
                () -> new ArmorItem(ModArmorMaterials.LEAD, ArmorItem.Type.BOOTS, new Item.Properties()));

        public static final RegistryObject<SwordItem> ZINC_SWORD = register("zinc_sword",
                () -> new SwordItem(
                        ModToolTiers.ZINC,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> ZINC_PICKAXE = register("zinc_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.ZINC,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> ZINC_AXE = register("zinc_axe",
                () -> new AxeItem(
                        ModToolTiers.ZINC,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> ZINC_SHOVEL = register("zinc_shovel",
                () -> new ShovelItem(
                        ModToolTiers.ZINC,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> ZINC_HOE = register("zinc_hoe",
                () -> new HoeItem(
                        ModToolTiers.ZINC,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> ZINC_HELMET = register("zinc_helmet",
                () -> new ArmorItem(ModArmorMaterials.ZINC, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<ArmorItem> ZINC_CHESTPLATE = register("zinc_chestplate",
                () -> new ArmorItem(ModArmorMaterials.ZINC, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<ArmorItem> ZINC_LEGGINGS = register("zinc_leggings",
                () -> new ArmorItem(ModArmorMaterials.ZINC, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<ArmorItem> ZINC_BOOTS = register("zinc_boots",
                () -> new ArmorItem(ModArmorMaterials.ZINC, ArmorItem.Type.BOOTS, new Item.Properties()));

        public static final RegistryObject<SwordItem> BRASS_SWORD = register("brass_sword",
                () -> new SwordItem(
                        ModToolTiers.BRASS,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> BRASS_PICKAXE = register("brass_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.BRASS,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> BRASS_AXE = register("brass_axe",
                () -> new AxeItem(
                        ModToolTiers.BRASS,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> BRASS_SHOVEL = register("brass_shovel",
                () -> new ShovelItem(
                        ModToolTiers.BRASS,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> BRASS_HOE = register("brass_hoe",
                () -> new HoeItem(
                        ModToolTiers.BRASS,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> BRASS_HELMET = register("brass_helmet",
                () -> new ArmorItem(ModArmorMaterials.BRASS, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<ArmorItem> BRASS_CHESTPLATE = register("brass_chestplate",
                () -> new ArmorItem(ModArmorMaterials.BRASS, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<ArmorItem> BRASS_LEGGINGS = register("brass_leggings",
                () -> new ArmorItem(ModArmorMaterials.BRASS, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<ArmorItem> BRASS_BOOTS = register("brass_boots",
                () -> new ArmorItem(ModArmorMaterials.BRASS, ArmorItem.Type.BOOTS, new Item.Properties()));

        public static final RegistryObject<SwordItem> SILVER_SWORD = register("silver_sword",
                () -> new SwordItem(
                        ModToolTiers.SILVER,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> SILVER_PICKAXE = register("silver_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.SILVER,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> SILVER_AXE = register("silver_axe",
                () -> new AxeItem(
                        ModToolTiers.SILVER,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> SILVER_SHOVEL = register("silver_shovel",
                () -> new ShovelItem(
                        ModToolTiers.SILVER,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> SILVER_HOE = register("silver_hoe",
                () -> new HoeItem(
                        ModToolTiers.SILVER,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> SILVER_HELMET = register("silver_helmet",
                () -> new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<ArmorItem> SILVER_CHESTPLATE = register("silver_chestplate",
                () -> new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<ArmorItem> SILVER_LEGGINGS = register("silver_leggings",
                () -> new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<ArmorItem> SILVER_BOOTS = register("silver_boots",
                () -> new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.BOOTS, new Item.Properties()));

        public static final RegistryObject<SwordItem> STEEL_SWORD = register("steel_sword",
                () -> new SwordItem(
                        ModToolTiers.STEEL,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = register("steel_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.STEEL,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> STEEL_AXE = register("steel_axe",
                () -> new AxeItem(
                        ModToolTiers.STEEL,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> STEEL_SHOVEL = register("steel_shovel",
                () -> new ShovelItem(
                        ModToolTiers.STEEL,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> STEEL_HOE = register("steel_hoe",
                () -> new HoeItem(
                        ModToolTiers.STEEL,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> STEEL_HELMET = register("steel_helmet",
                () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<ArmorItem> STEEL_CHESTPLATE = register("steel_chestplate",
                () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<ArmorItem> STEEL_LEGGINGS = register("steel_leggings",
                () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<ArmorItem> STEEL_BOOTS = register("steel_boots",
                () -> new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));

        public static final RegistryObject<SwordItem> TUNGSTEN_SWORD = register("tungsten_sword",
                () -> new SwordItem(
                        ModToolTiers.TUNGSTEN,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> TUNGSTEN_PICKAXE = register("tungsten_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.TUNGSTEN,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> TUNGSTEN_AXE = register("tungsten_axe",
                () -> new AxeItem(
                        ModToolTiers.TUNGSTEN,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> TUNGSTEN_SHOVEL = register("tungsten_shovel",
                () -> new ShovelItem(
                        ModToolTiers.TUNGSTEN,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> TUNGSTEN_HOE = register("tungsten_hoe",
                () -> new HoeItem(
                        ModToolTiers.TUNGSTEN,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> TUNGSTEN_HELMET = register("tungsten_helmet",
                () -> new ArmorItem(ModArmorMaterials.TUNGSTEN, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<ArmorItem> TUNGSTEN_CHESTPLATE = register("tungsten_chestplate",
                () -> new ArmorItem(ModArmorMaterials.TUNGSTEN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<ArmorItem> TUNGSTEN_LEGGINGS = register("tungsten_leggings",
                () -> new ArmorItem(ModArmorMaterials.TUNGSTEN, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<ArmorItem> TUNGSTEN_BOOTS = register("tungsten_boots",
                () -> new ArmorItem(ModArmorMaterials.TUNGSTEN, ArmorItem.Type.BOOTS, new Item.Properties()));

        public static final RegistryObject<SwordItem> PALLADIUM_SWORD = register("palladium_sword",
                () -> new SwordItem(
                        ModToolTiers.PALLADIUM,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> PALLADIUM_PICKAXE = register("palladium_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.PALLADIUM,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> PALLADIUM_AXE = register("palladium_axe",
                () -> new AxeItem(
                        ModToolTiers.PALLADIUM,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> PALLADIUM_SHOVEL = register("palladium_shovel",
                () -> new ShovelItem(
                        ModToolTiers.PALLADIUM,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> PALLADIUM_HOE = register("palladium_hoe",
                () -> new HoeItem(
                        ModToolTiers.PALLADIUM,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> PALLADIUM_HELMET = register("palladium_helmet",
                () -> new ArmorItem(ModArmorMaterials.PALLADIUM, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<ArmorItem> PALLADIUM_CHESTPLATE = register("palladium_chestplate",
                () -> new ArmorItem(ModArmorMaterials.PALLADIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<ArmorItem> PALLADIUM_LEGGINGS = register("palladium_leggings",
                () -> new ArmorItem(ModArmorMaterials.PALLADIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<ArmorItem> PALLADIUM_BOOTS = register("palladium_boots",
                () -> new ArmorItem(ModArmorMaterials.PALLADIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

        public static final RegistryObject<SwordItem> MYTHRIL_SWORD = register("mythril_sword",
                () -> new SwordItem(
                        ModToolTiers.MYTHRIL,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> MYTHRIL_PICKAXE = register("mythril_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.MYTHRIL,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> MYTHRIL_AXE = register("mythril_axe",
                () -> new AxeItem(
                        ModToolTiers.MYTHRIL,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> MYTHRIL_SHOVEL = register("mythril_shovel",
                () -> new ShovelItem(
                        ModToolTiers.MYTHRIL,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> MYTHRIL_HOE = register("mythril_hoe",
                () -> new HoeItem(
                        ModToolTiers.MYTHRIL,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> MYTHRIL_HELMET = register("mythril_helmet",
                () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<ArmorItem> MYTHRIL_CHESTPLATE = register("mythril_chestplate",
                () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<ArmorItem> MYTHRIL_LEGGINGS = register("mythril_leggings",
                () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<ArmorItem> MYTHRIL_BOOTS = register("mythril_boots",
                () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.BOOTS, new Item.Properties()));

        public static final RegistryObject<SwordItem> VOLCANIUM_SWORD = register("volcanium_sword",
                () -> new SwordItem(
                        ModToolTiers.VOLCANIUM,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> VOLCANIUM_PICKAXE = register("volcanium_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.VOLCANIUM,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> VOLCANIUM_AXE = register("volcanium_axe",
                () -> new AxeItem(
                        ModToolTiers.VOLCANIUM,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> VOLCANIUM_SHOVEL = register("volcanium_shovel",
                () -> new ShovelItem(
                        ModToolTiers.VOLCANIUM,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> VOLCANIUM_HOE = register("volcanium_hoe",
                () -> new HoeItem(
                        ModToolTiers.VOLCANIUM,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> VOLCANIUM_HELMET = register("volcanium_helmet",
                () -> new ArmorItem(ModArmorMaterials.VOLCANIUM, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> VOLCANIUM_CHESTPLATE = register("volcanium_chestplate",
                () -> new ArmorItem(ModArmorMaterials.VOLCANIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> VOLCANIUM_LEGGINGS = register("volcanium_leggings",
                () -> new ArmorItem(ModArmorMaterials.VOLCANIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> VOLCANIUM_BOOTS = register("volcanium_boots",
                () -> new ArmorItem(ModArmorMaterials.VOLCANIUM, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

        public static final RegistryObject<SwordItem> COBALT_SWORD = register("cobalt_sword",
                () -> new SwordItem(
                        ModToolTiers.COBALT,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> COBALT_PICKAXE = register("cobalt_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.COBALT,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> COBALT_AXE = register("cobalt_axe",
                () -> new AxeItem(
                        ModToolTiers.COBALT,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> COBALT_SHOVEL = register("cobalt_shovel",
                () -> new ShovelItem(
                        ModToolTiers.COBALT,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> COBALT_HOE = register("cobalt_hoe",
                () -> new HoeItem(
                        ModToolTiers.COBALT,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> COBALT_HELMET = register("cobalt_helmet",
                () -> new ArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<ArmorItem> COBALT_CHESTPLATE = register("cobalt_chestplate",
                () -> new ArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<ArmorItem> COBALT_LEGGINGS = register("cobalt_leggings",
                () -> new ArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<ArmorItem> COBALT_BOOTS = register("cobalt_boots",
                () -> new ArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.BOOTS, new Item.Properties()));

        public static final RegistryObject<SwordItem> ORICHALCUM_SWORD = register("orichalcum_sword",
                () -> new SwordItem(
                        ModToolTiers.ORICHALCUM,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> ORICHALCUM_PICKAXE = register("orichalcum_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.ORICHALCUM,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> ORICHALCUM_AXE = register("orichalcum_axe",
                () -> new AxeItem(
                        ModToolTiers.ORICHALCUM,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> ORICHALCUM_SHOVEL = register("orichalcum_shovel",
                () -> new ShovelItem(
                        ModToolTiers.ORICHALCUM,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> ORICHALCUM_HOE = register("orichalcum_hoe",
                () -> new HoeItem(
                        ModToolTiers.ORICHALCUM,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> ORICHALCUM_HELMET = register("orichalcum_helmet",
                () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> ORICHALCUM_CHESTPLATE = register("orichalcum_chestplate",
                () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> ORICHALCUM_LEGGINGS = register("orichalcum_leggings",
                () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> ORICHALCUM_BOOTS = register("orichalcum_boots",
                () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

        public static final RegistryObject<SwordItem> TITANIUM_SWORD = register("titanium_sword",
                () -> new SwordItem(
                        ModToolTiers.TITANIUM,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> TITANIUM_PICKAXE = register("titanium_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.TITANIUM,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> TITANIUM_AXE = register("titanium_axe",
                () -> new AxeItem(
                        ModToolTiers.TITANIUM,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> TITANIUM_SHOVEL = register("titanium_shovel",
                () -> new ShovelItem(
                        ModToolTiers.TITANIUM,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> TITANIUM_HOE = register("titanium_hoe",
                () -> new HoeItem(
                        ModToolTiers.TITANIUM,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> TITANIUM_HELMET = register("titanium_helmet",
                () -> new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> TITANIUM_CHESTPLATE = register("titanium_chestplate",
                () -> new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> TITANIUM_LEGGINGS = register("titanium_leggings",
                () -> new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> TITANIUM_BOOTS = register("titanium_boots",
                () -> new ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

        public static final RegistryObject<SwordItem> ADAMANTIUM_SWORD = register("adamantium_sword",
                () -> new SwordItem(
                        ModToolTiers.ADAMANTIUM,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> ADAMANTIUM_PICKAXE = register("adamantium_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.ADAMANTIUM,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> ADAMANTIUM_AXE = register("adamantium_axe",
                () -> new AxeItem(
                        ModToolTiers.ADAMANTIUM,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> ADAMANTIUM_SHOVEL = register("adamantium_shovel",
                () -> new ShovelItem(
                        ModToolTiers.ADAMANTIUM,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> ADAMANTIUM_HOE = register("adamantium_hoe",
                () -> new HoeItem(
                        ModToolTiers.ADAMANTIUM,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> ADAMANTIUM_HELMET = register("adamantium_helmet",
                () -> new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> ADAMANTIUM_CHESTPLATE = register("adamantium_chestplate",
                () -> new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> ADAMANTIUM_LEGGINGS = register("adamantium_leggings",
                () -> new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> ADAMANTIUM_BOOTS = register("adamantium_boots",
                () -> new ArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

        public static final RegistryObject<SwordItem> DAEDRITE_SWORD = register("daedrite_sword",
                () -> new SwordItem(
                        ModToolTiers.DAEDRITE,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> DAEDRITE_PICKAXE = register("daedrite_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.DAEDRITE,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> DAEDRITE_AXE = register("daedrite_axe",
                () -> new AxeItem(
                        ModToolTiers.DAEDRITE,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> DAEDRITE_SHOVEL = register("daedrite_shovel",
                () -> new ShovelItem(
                        ModToolTiers.DAEDRITE,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> DAEDRITE_HOE = register("daedrite_hoe",
                () -> new HoeItem(
                        ModToolTiers.DAEDRITE,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> DAEDRITE_HELMET = register("daedrite_helmet",
                () -> new ArmorItem(ModArmorMaterials.DAEDRITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> DAEDRITE_CHESTPLATE = register("daedrite_chestplate",
                () -> new ArmorItem(ModArmorMaterials.DAEDRITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> DAEDRITE_LEGGINGS = register("daedrite_leggings",
                () -> new ArmorItem(ModArmorMaterials.DAEDRITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> DAEDRITE_BOOTS = register("daedrite_boots",
                () -> new ArmorItem(ModArmorMaterials.DAEDRITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

        public static final RegistryObject<SwordItem> NYXIUM_SWORD = register("nyxium_sword",
                () -> new SwordItem(
                        ModToolTiers.NYXIUM,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> NYXIUM_PICKAXE = register("nyxium_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.NYXIUM,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> NYXIUM_AXE = register("nyxium_axe",
                () -> new AxeItem(
                        ModToolTiers.NYXIUM,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> NYXIUM_SHOVEL = register("nyxium_shovel",
                () -> new ShovelItem(
                        ModToolTiers.NYXIUM,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> NYXIUM_HOE = register("nyxium_hoe",
                () -> new HoeItem(
                        ModToolTiers.NYXIUM,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> NYXIUM_HELMET = register("nyxium_helmet",
                () -> new ArmorItem(ModArmorMaterials.NYXIUM, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> NYXIUM_CHESTPLATE = register("nyxium_chestplate",
                () -> new ArmorItem(ModArmorMaterials.NYXIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> NYXIUM_LEGGINGS = register("nyxium_leggings",
                () -> new ArmorItem(ModArmorMaterials.NYXIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> NYXIUM_BOOTS = register("nyxium_boots",
                () -> new ArmorItem(ModArmorMaterials.NYXIUM, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

        public static final RegistryObject<SwordItem> CELESTIUM_SWORD = register("celestium_sword",
                () -> new SwordItem(
                        ModToolTiers.CELESTIUM,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> CELESTIUM_PICKAXE = register("celestium_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.CELESTIUM,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> CELESTIUM_AXE = register("celestium_axe",
                () -> new AxeItem(
                        ModToolTiers.CELESTIUM,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> CELESTIUM_SHOVEL = register("celestium_shovel",
                () -> new ShovelItem(
                        ModToolTiers.CELESTIUM,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> CELESTIUM_HOE = register("celestium_hoe",
                () -> new HoeItem(
                        ModToolTiers.CELESTIUM,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> CELESTIUM_HELMET = register("celestium_helmet",
                () -> new ArmorItem(ModArmorMaterials.CELESTIUM, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> CELESTIUM_CHESTPLATE = register("celestium_chestplate",
                () -> new ArmorItem(ModArmorMaterials.CELESTIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> CELESTIUM_LEGGINGS = register("celestium_leggings",
                () -> new ArmorItem(ModArmorMaterials.CELESTIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> CELESTIUM_BOOTS = register("celestium_boots",
                () -> new ArmorItem(ModArmorMaterials.CELESTIUM, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

        public static final RegistryObject<SwordItem> VOIDSTEEL_SWORD = register("voidsteel_sword",
                () -> new SwordItem(
                        ModToolTiers.VOIDSTEEL,
                        3,
                        -2.4F,
                        new Item.Properties()
                ));
        public static final RegistryObject<PickaxeItem> VOIDSTEEL_PICKAXE = register("voidsteel_pickaxe",
                () -> new PickaxeItem(
                        ModToolTiers.VOIDSTEEL,
                        1,
                        -2.8F,
                        new Item.Properties()
                ));
        public static final RegistryObject<AxeItem> VOIDSTEEL_AXE = register("voidsteel_axe",
                () -> new AxeItem(
                        ModToolTiers.VOIDSTEEL,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<ShovelItem> VOIDSTEEL_SHOVEL = register("voidsteel_shovel",
                () -> new ShovelItem(
                        ModToolTiers.VOIDSTEEL,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                ));
        public static final RegistryObject<HoeItem> VOIDSTEEL_HOE = register("voidsteel_hoe",
                () -> new HoeItem(
                        ModToolTiers.VOIDSTEEL,
                        -1,
                        0.0F,
                        new Item.Properties()
                ));

        public static final RegistryObject<ArmorItem> VOIDSTEEL_HELMET = register("voidsteel_helmet",
                () -> new ArmorItem(ModArmorMaterials.VOIDSTEEL, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> VOIDSTEEL_CHESTPLATE = register("voidsteel_chestplate",
                () -> new ArmorItem(ModArmorMaterials.VOIDSTEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> VOIDSTEEL_LEGGINGS = register("voidsteel_leggings",
                () -> new ArmorItem(ModArmorMaterials.VOIDSTEEL, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
        public static final RegistryObject<ArmorItem> VOIDSTEEL_BOOTS = register("voidsteel_boots",
                () -> new ArmorItem(ModArmorMaterials.VOIDSTEEL, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));
        
        /* 
         *  █████ █   █  ███   ███  █████   ████  █      ███   ███  █  █  ████
         *    █   ██  █ █     █   █   █     █   █ █     █   █ █   █ █ █  █
         *    █   █ █ █ █  ██ █   █   █     ████  █     █   █ █     ██    ███
         *    █   █  ██ █   █ █   █   █     █   █ █     █   █ █   █ █ █      █
         *  █████ █   █  ███   ███    █     ████  █████  ███   ███  █  █ ████
         */

        public static final RegistryObject<Item> TIN_BLOCK =
                register("tin_block", () -> new BlockItem(ModBlocks.TIN_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> RAW_TIN_BLOCK =
                register("raw_tin_block", () -> new BlockItem(ModBlocks.RAW_TIN_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> BRONZE_BLOCK =
                register("bronze_block", () -> new BlockItem(ModBlocks.BRONZE_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> LEAD_BLOCK =
                register("lead_block", () -> new BlockItem(ModBlocks.LEAD_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> RAW_LEAD_BLOCK =
                register("raw_lead_block", () -> new BlockItem(ModBlocks.RAW_LEAD_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> ZINC_BLOCK =
                register("zinc_block", () -> new BlockItem(ModBlocks.ZINC_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> RAW_ZINC_BLOCK =
                register("raw_zinc_block", () -> new BlockItem(ModBlocks.RAW_ZINC_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> BRASS_BLOCK =
                register("brass_block", () -> new BlockItem(ModBlocks.BRASS_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> SILVER_BLOCK =
                register("silver_block", () -> new BlockItem(ModBlocks.SILVER_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> RAW_SILVER_BLOCK =
                register("raw_silver_block", () -> new BlockItem(ModBlocks.RAW_SILVER_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> STEEL_BLOCK =
                register("steel_block", () -> new BlockItem(ModBlocks.STEEL_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> TUNGSTEN_BLOCK =
                register("tungsten_block", () -> new BlockItem(ModBlocks.TUNGSTEN_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> RAW_TUNGSTEN_BLOCK =
                register("raw_tungsten_block", () -> new BlockItem(ModBlocks.RAW_TUNGSTEN_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> PALLADIUM_BLOCK =
                register("palladium_block", () -> new BlockItem(ModBlocks.PALLADIUM_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> RAW_PALLADIUM_BLOCK =
                register("raw_palladium_block", () -> new BlockItem(ModBlocks.RAW_PALLADIUM_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> MYTHRIL_BLOCK =
                register("mythril_block", () -> new BlockItem(ModBlocks.MYTHRIL_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> RAW_MYTHRIL_BLOCK =
                register("raw_mythril_block", () -> new BlockItem(ModBlocks.RAW_MYTHRIL_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> VOLCANIUM_BLOCK =
                register("volcanium_block", () -> new BlockItem(ModBlocks.VOLCANIUM_BLOCK.get(), new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> RAW_VOLCANIUM_BLOCK =
                register("raw_volcanium_block", () -> new BlockItem(ModBlocks.RAW_VOLCANIUM_BLOCK.get(), new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> COBALT_BLOCK =
                register("cobalt_block", () -> new BlockItem(ModBlocks.COBALT_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> RAW_COBALT_BLOCK =
                register("raw_cobalt_block", () -> new BlockItem(ModBlocks.RAW_COBALT_BLOCK.get(), new Item.Properties()));
        public static final RegistryObject<Item> ORICHALCUM_BLOCK =
                register("orichalcum_block", () -> new BlockItem(ModBlocks.ORICHALCUM_BLOCK.get(), new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> RAW_ORICHALCUM_BLOCK =
                register("raw_orichalcum_block", () -> new BlockItem(ModBlocks.RAW_ORICHALCUM_BLOCK.get(), new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> TITANIUM_BLOCK =
                register("titanium_block", () -> new BlockItem(ModBlocks.TITANIUM_BLOCK.get(), new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> RAW_TITANIUM_BLOCK =
                register("raw_titanium_block", () -> new BlockItem(ModBlocks.RAW_TITANIUM_BLOCK.get(), new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> ADAMANTIUM_BLOCK =
                register("adamantium_block", () -> new BlockItem(ModBlocks.ADAMANTIUM_BLOCK.get(), new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> RAW_ADAMANTIUM_BLOCK =
                register("raw_adamantium_block", () -> new BlockItem(ModBlocks.RAW_ADAMANTIUM_BLOCK.get(), new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> DAEDRITE_BLOCK =
                register("daedrite_block", () -> new BlockItem(ModBlocks.DAEDRITE_BLOCK.get(), new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> NYXIUM_BLOCK =
                register("nyxium_block", () -> new BlockItem(ModBlocks.NYXIUM_BLOCK.get(), new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> RAW_NYXIUM_BLOCK =
                register("raw_nyxium_block", () -> new BlockItem(ModBlocks.RAW_NYXIUM_BLOCK.get(), new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> CELESTIUM_BLOCK =
                register("celestium_block", () -> new BlockItem(ModBlocks.CELESTIUM_BLOCK.get(), new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> RAW_CELESTIUM_BLOCK =
                register("raw_celestium_block", () -> new BlockItem(ModBlocks.RAW_CELESTIUM_BLOCK.get(), new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> VOIDSTEEL_BLOCK =
                register("voidsteel_block", () -> new BlockItem(ModBlocks.VOIDSTEEL_BLOCK.get(), new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> RAW_VOIDSTEEL_BLOCK =
                register("raw_voidsteel_block", () -> new BlockItem(ModBlocks.RAW_VOIDSTEEL_BLOCK.get(), new Item.Properties().fireResistant()));
        
        /* 
         *   ███  █████ █   █ █████ ████
         *  █   █   █   █   █ █     █   █
         *  █   █   █   █████ ████  ████
         *  █   █   █   █   █ █     █   █
         *   ███    █   █   █ █████ █   █
         */
        
        public static final RegistryObject<Item> OBSIDIAN_DUST = register("obsidian_dust",
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> OBSIDIANSKIN_TONIC = register("obsidianskin_tonic",
                () -> new ObsidianskinTonicItem(new Item.Properties().stacksTo(16)));

        public static final RegistryObject<Item> CRUCIBLE = register("crucible",
                () -> new BlockItem(ModBlocks.CRUCIBLE.get(), new Item.Properties().fireResistant().rarity(Rarity.COMMON)));
        public static final RegistryObject<Item> REINFORCED_CRUCIBLE = register("reinforced_crucible",
                () -> new BlockItem(ModBlocks.REINFORCED_CRUCIBLE.get(), new Item.Properties().fireResistant().rarity(Rarity.RARE)));
        public static final RegistryObject<Item> SUPERHEATED_CRUCIBLE = register("superheated_crucible",
                () -> new BlockItem(ModBlocks.SUPERHEATED_CRUCIBLE.get(), new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));
        public static final RegistryObject<Item> HYPERCHARGED_CRUCIBLE = register("hypercharged_crucible",
                () -> new BlockItem(ModBlocks.HYPERCHARGED_CRUCIBLE.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
        
        public static final RegistryObject<Item> ADAMANTIUM_WIRE =
                register("adamantium_wire", () -> new Item(new Item.Properties().fireResistant()));
        public static final RegistryObject<Item> MYTHRIL_WIRE =
                register("mythril_wire", () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> COBALT_WIRE =
                register("cobalt_wire", () -> new Item(new Item.Properties()));
        
        /*
        @SuppressWarnings("deprecation")
        public static final RegistryObject<Item> DRAGON_DISC =
                ITEMS.register("dragon_disc",
                        () -> new RecordItem(
                                15,
                                ModSoundEvents.DRAGON_DISC,
                                new Item.Properties()
                                        .stacksTo(1)
                                        .rarity(Rarity.EPIC)
                                        .fireResistant(),
                                6500));
        */
        
        public static void register(IEventBus eventBus) {
                ITEMS.register(eventBus);
        }

}