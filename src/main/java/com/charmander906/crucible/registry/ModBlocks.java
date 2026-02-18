package com.charmander906.crucible.registry;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Supplier;
import com.charmander906.crucible.Crucible;
import com.charmander906.crucible.crucible.CrucibleBlock;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Crucible.MODID);

    public static final List<RegistryObject<Block>> ORDERED_BLOCKS = new ArrayList<>();

    private static RegistryObject<Block> register(String name, Supplier<Block> supplier) {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ORDERED_BLOCKS.add(block);
        return block;
    }

    /* 
     *   ███  ████  █████   ████  █      ███   ███  █  █  ████
     *  █   █ █   █ █       █   █ █     █   █ █   █ █ █  █
     *  █   █ ████  ████    ████  █     █   █ █     ██    ███
     *  █   █ █   █ █       █   █ █     █   █ █   █ █ █      █
     *   ███  █   █ █████   ████  █████  ███   ███  █  █ ████
     */

    public static final RegistryObject<Block> TIN_ORE =
        BLOCKS.register("tin_ore",
            () -> new Block(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.STONE)
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            )
        );
    public static final RegistryObject<Block> LEAD_ORE =
        BLOCKS.register("lead_ore",
            () -> new Block(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.STONE)
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            )
        );
    public static final RegistryObject<Block> ZINC_ORE =
        BLOCKS.register("zinc_ore",
            () -> new Block(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.STONE)
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            )
        );
    public static final RegistryObject<Block> SILVER_ORE =
        BLOCKS.register("silver_ore",
            () -> new Block(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.STONE)
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            )
        );
    public static final RegistryObject<Block> DEEPSLATE_TUNGSTEN_ORE =
        BLOCKS.register("deepslate_tungsten_ore",
            () -> new Block(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)
            )
        );
    public static final RegistryObject<Block> NETHER_PALLADIUM_ORE =
        BLOCKS.register("nether_palladium_ore",
            () -> new Block(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.NETHER)
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_ORE)
            )
        );
    public static final RegistryObject<Block> DEEPSLATE_MYTHRIL_ORE =
        BLOCKS.register("deepslate_mythril_ore",
            () -> new Block(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)
            )
        );
    public static final RegistryObject<Block> BLACK_VOLCANIUM_ORE =
        BLOCKS.register("black_volcanium_ore",
            () -> new Block(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .strength(4.5F, 6.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            )
        );
    public static final RegistryObject<Block> DEEPSLATE_COBALT_ORE =
        BLOCKS.register("deepslate_cobalt_ore",
            () -> new Block(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)
            )
        );
    public static final RegistryObject<Block> NETHER_ORICHALCUM_ORE =
        BLOCKS.register("nether_orichalcum_ore",
            () -> new Block(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.NETHER)
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_ORE)
            )
        );
    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE =
        BLOCKS.register("deepslate_titanium_ore",
            () -> new Block(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)
            )
        );
    public static final RegistryObject<Block> NETHER_ADAMANTIUM_ORE =
        BLOCKS.register("nether_adamantium_ore",
            () -> new Block(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.NETHER)
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_ORE)
            )
        );
    public static final RegistryObject<Block> END_NYXIUM_ORE =
        BLOCKS.register("end_nyxium_ore",
            () -> new Block(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.SAND)
                    .strength(7.5F, 9.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            )
        );
    public static final RegistryObject<Block> END_CELESTIUM_ORE =
        BLOCKS.register("end_celestium_ore",
            () -> new Block(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.SAND)
                    .strength(10.5F, 9.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            )
        );
    public static final RegistryObject<Block> END_VOIDSTEEL_ORE =
        BLOCKS.register("end_voidsteel_ore",
            () -> new Block(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.SAND)
                    .strength(15.5F, 9.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            )
        );

    /* 
     *  █████ █   █  ███   ███  █████   ████  █      ███   ███  █  █  ████
     *    █   ██  █ █     █   █   █     █   █ █     █   █ █   █ █ █  █
     *    █   █ █ █ █  ██ █   █   █     ████  █     █   █ █     ██    ███
     *    █   █  ██ █   █ █   █   █     █   █ █     █   █ █   █ █ █      █
     *  █████ █   █  ███   ███    █     ████  █████  ███   ███  █  █ ████
     */

    public static final RegistryObject<Block> TIN_BLOCK =
            BLOCKS.register("tin_block",
                () -> new Block(
                    BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_LIGHT_GRAY)
                        .strength(3.0F, 6.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_TIN_BLOCK =
            BLOCKS.register("raw_tin_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_GRAY)
                        .strength(2.5F, 5.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> BRONZE_BLOCK =
            BLOCKS.register("bronze_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_BROWN)
                        .strength(4.0F, 7.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> LEAD_BLOCK =
            BLOCKS.register("lead_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_GRAY)
                        .strength(3.0F, 6.5F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_LEAD_BLOCK =
            BLOCKS.register("raw_lead_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_BLACK)
                        .strength(2.7F, 5.5F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> ZINC_BLOCK =
            BLOCKS.register("zinc_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_GRAY)
                        .strength(3.0F, 6.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_ZINC_BLOCK =
            BLOCKS.register("raw_zinc_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_LIGHT_GRAY)
                        .strength(2.5F, 5.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> BRASS_BLOCK =
            BLOCKS.register("brass_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.GOLD)
                        .strength(4.0F, 7.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> SILVER_BLOCK =
            BLOCKS.register("silver_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_LIGHT_GRAY)
                        .strength(3.0F, 6.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_SILVER_BLOCK =
            BLOCKS.register("raw_silver_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_GRAY)
                        .strength(2.5F, 5.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> STEEL_BLOCK =
            BLOCKS.register("steel_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_GRAY)
                        .strength(5.0F, 7.5F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> TUNGSTEN_BLOCK =
            BLOCKS.register("tungsten_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_LIGHT_GREEN)
                        .strength(6.0F, 9.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_TUNGSTEN_BLOCK =
            BLOCKS.register("raw_tungsten_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_GREEN)
                        .strength(5.5F, 8.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> PALLADIUM_BLOCK =
            BLOCKS.register("palladium_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_ORANGE)
                        .strength(6.5F, 9.5F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_PALLADIUM_BLOCK =
            BLOCKS.register("raw_palladium_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_BROWN)
                        .strength(6.0F, 8.5F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> MYTHRIL_BLOCK =
            BLOCKS.register("mythril_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_GREEN)
                        .strength(7.0F, 10.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_MYTHRIL_BLOCK =
            BLOCKS.register("raw_mythril_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_GREEN)
                        .strength(6.5F, 9.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> VOLCANIUM_BLOCK =
            BLOCKS.register("volcanium_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_ORANGE)
                        .strength(7.5F, 10.5F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

    public static final RegistryObject<Block> RAW_VOLCANIUM_BLOCK =
            BLOCKS.register("raw_volcanium_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_RED)
                        .strength(7.0F, 9.5F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

    public static final RegistryObject<Block> COBALT_BLOCK =
            BLOCKS.register("cobalt_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_BLUE)
                        .strength(8.0F, 11.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_COBALT_BLOCK =
            BLOCKS.register("raw_cobalt_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_LIGHT_BLUE)
                        .strength(7.5F, 10.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> ORICHALCUM_BLOCK =
            BLOCKS.register("orichalcum_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_PINK)
                        .strength(8.5F, 11.5F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_ORICHALCUM_BLOCK =
            BLOCKS.register("raw_orichalcum_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_MAGENTA)
                        .strength(8.0F, 10.5F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.METAL)));

    public static final RegistryObject<Block> TITANIUM_BLOCK =
            BLOCKS.register("titanium_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_LIGHT_GRAY)
                        .strength(9.0F, 12.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> RAW_TITANIUM_BLOCK =
            BLOCKS.register("raw_titanium_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_GRAY)
                        .strength(8.5F, 11.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> ADAMANTIUM_BLOCK =
            BLOCKS.register("adamantium_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_RED)
                        .strength(9.5F, 12.5F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> RAW_ADAMANTIUM_BLOCK =
            BLOCKS.register("raw_adamantium_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_RED)
                        .strength(9.0F, 11.5F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> DAEDRITE_BLOCK =
            BLOCKS.register("daedrite_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_GRAY)
                        .strength(10.0F, 13.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> NYXIUM_BLOCK =
            BLOCKS.register("nyxium_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_PURPLE)
                        .strength(10.5F, 13.5F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> RAW_NYXIUM_BLOCK =
            BLOCKS.register("raw_nyxium_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_PURPLE)
                        .strength(10.0F, 12.5F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> CELESTIUM_BLOCK =
            BLOCKS.register("celestium_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_LIGHT_BLUE)
                        .strength(11.0F, 14.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAW_CELESTIUM_BLOCK =
            BLOCKS.register("raw_celestium_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_BLUE)
                        .strength(10.5F, 13.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> VOIDSTEEL_BLOCK =
            BLOCKS.register("voidsteel_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_BLACK)
                        .strength(12.0F, 15.0F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> RAW_VOIDSTEEL_BLOCK =
            BLOCKS.register("raw_voidsteel_block",
                () -> new Block(BlockBehaviour.Properties
                        .of()
                        .mapColor(MapColor.COLOR_BLACK)
                        .strength(11.0F, 13.5F)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.ANCIENT_DEBRIS)));


    /* 
     *   ███  █████ █   █ █████ ████
     *  █   █   █   █   █ █     █   █
     *  █   █   █   █████ ████  ████
     *  █   █   █   █   █ █     █   █
     *   ███    █   █   █ █████ █   █
     */

    public static final RegistryObject<Block> CRUCIBLE =
        BLOCKS.register("crucible",
            () -> new CrucibleBlock(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(3.0F, 4.5F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                , 1
            )
        );
    public static final RegistryObject<Block> REINFORCED_CRUCIBLE =
        BLOCKS.register("reinforced_crucible",
            () -> new CrucibleBlock(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(6.0F, 9.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                , 2
            )
        );
    public static final RegistryObject<Block> SUPERHEATED_CRUCIBLE =
        BLOCKS.register("superheated_crucible",
            () -> new CrucibleBlock(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(9.0F, 13.5F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                , 3
            )
        );
    public static final RegistryObject<Block> HYPERCHARGED_CRUCIBLE =
        BLOCKS.register("hypercharged_crucible",
            () -> new CrucibleBlock(
                BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(12.0F, 18.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)
                , 4
            )
        );

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}