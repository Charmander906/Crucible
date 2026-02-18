package com.charmander906.crucible.crucible;

import javax.annotation.Nonnull;

import com.charmander906.crucible.registry.ModBlockEntities;
import com.charmander906.crucible.registry.ModRecipes;

import java.util.Optional;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.items.ItemStackHandler;

public class CrucibleBlockEntity extends BlockEntity implements MenuProvider {

    public static final int SLOT_FUEL = 0;
    public static final int SLOT_INPUT1 = 1;
    public static final int SLOT_INPUT2 = 2;
    public static final int SLOT_OUTPUT = 3;

    private final ItemStackHandler items = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private int burnTime;
    private int fuelTime;
    private int cookTime;
    private int cookTimeTotal;

    private final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> burnTime;
                case 1 -> fuelTime;
                case 2 -> cookTime;
                case 3 -> cookTimeTotal;
                case 4 -> getCrucibleTier();
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> burnTime = value;
                case 1 -> fuelTime = value;
                case 2 -> cookTime = value;
                case 3 -> cookTimeTotal = value;
            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    };

    public CrucibleBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        super(ModBlockEntities.CRUCIBLE.get(), pos, state);
        this.cookTimeTotal = 320;
    }

    @Override
    public void load(@Nonnull CompoundTag tag) {
        super.load(tag);
        items.deserializeNBT(tag.getCompound("Inventory"));
        burnTime = tag.getInt("BurnTime");
        fuelTime = tag.getInt("FuelTime");
        cookTime = tag.getInt("CookTime");
        cookTimeTotal = tag.getInt("CookTimeTotal");
        this.setChanged();
    }

    public ItemStackHandler getItems() {
        return items;
    }

    @Override
    protected void saveAdditional(@Nonnull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Inventory", items.serializeNBT());
        tag.putInt("BurnTime", burnTime);
        tag.putInt("FuelTime", fuelTime);
        tag.putInt("CookTime", cookTime);
        tag.putInt("CookTimeTotal", cookTimeTotal);
    }

    @Override
    @Nonnull
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        load(tag);
    }

    @Override
    @Nonnull
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public static void tick(@Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState state, @Nonnull CrucibleBlockEntity be) {
        boolean wasBurning = be.isBurning();
        boolean dirty = false;

        if (be.burnTime > 0) {
            be.burnTime -= 4;
            if (be.burnTime < 0) be.burnTime = 0;
        }

        ItemStack fuel = be.items.getStackInSlot(SLOT_FUEL);
        ItemStack input1 = be.items.getStackInSlot(SLOT_INPUT1);
        ItemStack input2 = be.items.getStackInSlot(SLOT_INPUT2);

        SimpleContainer inv = new SimpleContainer(2);
        inv.setItem(0, input1);
        inv.setItem(1, input2);

        Optional<CrucibleRecipe> recipeOpt = level.getRecipeManager()
                .getRecipeFor(ModRecipes.CRUCIBLE_TYPE.get(), inv, level);

        if (recipeOpt.isPresent()) {
            CrucibleRecipe recipe = recipeOpt.get();

            boolean basicInputsOk = input1.getCount() >= recipe.getTopCount() && input2.getCount() >= 1;
            boolean outputOk = be.canAcceptOutput(recipe);
            boolean crucibleHasFuel = be.hasFuel();

            int crucibleTier = be.getCrucibleTier();
            int recipeTier = recipe.getTier();
            boolean tierOk = crucibleTier >= recipeTier;

            boolean canCraft = basicInputsOk && outputOk && tierOk;

            if (!tierOk) {
                if (be.cookTime != 0) {
                    be.cookTime = 0;
                    dirty = true;
                }
            } else {
                int effectiveTier = Math.max(1, Math.min(4, (crucibleTier - recipeTier) + 1));

                be.cookTimeTotal = switch (effectiveTier) {
                    case 4 -> 80;
                    case 3 -> 120;
                    case 2 -> 200;
                    default -> 320;
                };
            }

            if (!be.isBurning() && crucibleHasFuel && canCraft) {
                be.fuelTime = ForgeHooks.getBurnTime(fuel, null);
                be.burnTime = be.fuelTime;
                if (be.isBurning()) {
                    fuel.shrink(1);
                    dirty = true;
                }
            }

            if (be.isBurning() && canCraft) {
                be.cookTime++;
                if (be.cookTime >= be.cookTimeTotal) {
                    be.craft(recipe);
                    dirty = true;
                }
            } else {
                if (be.cookTime != 0 && (!be.isBurning() || !canCraft)) {
                    be.cookTime = 0;
                    dirty = true;
                }
            }

        } else {
            if (be.cookTime != 0) {
                be.cookTime = 0;
                dirty = true;
            }
        }

        if (wasBurning != be.isBurning()) {
            state = state.setValue(BlockStateProperties.LIT, be.isBurning());
            level.setBlock(pos, state, 3);
        }

        if (dirty) be.setChanged();
    }

    private boolean hasFuel() {
        return burnTime > 0 || ForgeHooks.getBurnTime(items.getStackInSlot(SLOT_FUEL), null) > 0;
    }

    private boolean isBurning() {
        return burnTime > 0;
    }

    private boolean canAcceptOutput(@Nonnull CrucibleRecipe recipe) {
        ItemStack output = recipe.getResultItem();
        ItemStack current = items.getStackInSlot(SLOT_OUTPUT);

        if (current.isEmpty()) return true;
        if (!current.is(output.getItem())) return false;
        return current.getCount() + output.getCount() <= current.getMaxStackSize();
    }

    private int getCrucibleTier() {
        Block block = getBlockState().getBlock();
        if (block instanceof CrucibleBlock crucible) {
            return crucible.getTier();
        }
        return 1;
    }

    private void craft(@Nonnull CrucibleRecipe recipe) {
        ItemStack output = recipe.getResultItem();
        ItemStack current = items.getStackInSlot(SLOT_OUTPUT);

        if (current.isEmpty()) {
            items.setStackInSlot(SLOT_OUTPUT, output.copy());
        } else if (current.is(output.getItem())) {
            current.grow(output.getCount());
        }

        ItemStack topInput = items.getStackInSlot(SLOT_INPUT1);
        ItemStack bottomInput = items.getStackInSlot(SLOT_INPUT2);

        topInput.shrink(recipe.getTopCount());
        bottomInput.shrink(1);

        cookTime = 0;
    }

    @Override
    @Nonnull
    public Component getDisplayName() {
        return Component.translatable("block.crucible.crucible");
    }

    @Override
    @Nonnull
    public AbstractContainerMenu createMenu(int id, @Nonnull Inventory inv, @Nonnull Player player) {
        return new CrucibleMenu(id, inv, this.items, this.data);
    }
}
