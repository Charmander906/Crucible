package com.charmander906.crucible.registry;

import com.charmander906.crucible.Crucible;
import com.charmander906.crucible.crucible.CrucibleBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Crucible.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Crucible.MODID);

    @SuppressWarnings("null")
    public static final RegistryObject<BlockEntityType<CrucibleBlockEntity>> CRUCIBLE =
        BLOCK_ENTITIES.register("crucible", () -> BlockEntityType.Builder
            .of(
                CrucibleBlockEntity::new,
                ModBlocks.CRUCIBLE.get(),
                ModBlocks.REINFORCED_CRUCIBLE.get(),
                ModBlocks.SUPERHEATED_CRUCIBLE.get(),
                ModBlocks.HYPERCHARGED_CRUCIBLE.get()
            )
            .build(null)
    );

    public static void register(IEventBus modEventBus) {
        BLOCK_ENTITIES.register(modEventBus);
    }
}
