package com.charmander906.crucible.crucible;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class CrucibleBlock extends BaseEntityBlock {
    private final int tier;

    public CrucibleBlock(@Nonnull BlockBehaviour.Properties properties, int tier) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.LIT, false));
        this.tier = tier;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@Nonnull Level level, @Nonnull BlockState state, @Nonnull BlockEntityType<T> type) {
        if (level.isClientSide) return null;

        return (lvl, pos, st, t) -> {
            if (t instanceof CrucibleBlockEntity be) {
                CrucibleBlockEntity.tick(lvl, pos, st, be);
            }
        };
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder builder) {
        builder.add(BlockStateProperties.LIT);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof CrucibleBlockEntity crucible) {
                ItemStackHandler handler = crucible.getItems();

                SimpleContainer inv = new SimpleContainer(handler.getSlots());
                for (int i = 0; i < handler.getSlots(); i++) {
                    inv.setItem(i, handler.getStackInSlot(i));
                }

                Containers.dropContents(level, pos, inv);
                level.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    @Nonnull
    public RenderShape getRenderShape(@Nonnull BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new CrucibleBlockEntity(pos, state);
    }

    public int getTier() {
        return tier;
    }

    @Override
    @Nonnull
    public InteractionResult use(
            @Nonnull BlockState state,
            @Nonnull Level level,
            @Nonnull BlockPos pos,
            @Nonnull Player player,
            @Nonnull InteractionHand hand,
            @Nonnull BlockHitResult hit
    ) {
        if (!level.isClientSide) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof CrucibleBlockEntity crucible) {
                player.openMenu(crucible);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
