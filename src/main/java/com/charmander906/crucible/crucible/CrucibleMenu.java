package com.charmander906.crucible.crucible;

import javax.annotation.Nonnull;

import com.charmander906.crucible.registry.ModMenuTypes;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class CrucibleMenu extends AbstractContainerMenu {
    @SuppressWarnings("unused")
    private final IItemHandler handler;
    private final ContainerData data;

    public CrucibleMenu(int id, @Nonnull Inventory playerInv, @Nonnull IItemHandler handler, @Nonnull ContainerData data) {
        super(ModMenuTypes.CRUCIBLE.get(), id);
        this.handler = handler;
        this.data = data;

        addDataSlots(data);

        this.addSlot(new SlotItemHandler(handler, CrucibleBlockEntity.SLOT_FUEL, 44, 43));
        this.addSlot(new SlotItemHandler(handler, CrucibleBlockEntity.SLOT_INPUT1, 80, 14));
        this.addSlot(new SlotItemHandler(handler, CrucibleBlockEntity.SLOT_INPUT2, 80, 58));
        this.addSlot(new CrucibleOutputSlot(handler, CrucibleBlockEntity.SLOT_OUTPUT, 116, 36));

        addPlayerInventory(playerInv);
        addPlayerHotbar(playerInv);
    }

    public boolean isBurning() {
        return data.get(0) > 0;
    }

    public int getBurnProgressScaled(int pixels) {
        int burnTime = data.get(0);
        int fuelTime = data.get(1);
        if (fuelTime == 0) fuelTime = 300;
        return burnTime * pixels / fuelTime;
    }

    public int getCookProgressScaled(int maxFrames) {
        int cookTime = data.get(2);
        int cookTimeTotal = data.get(3);
        if (cookTimeTotal == 0) cookTimeTotal = 300;
        return cookTime * maxFrames / cookTimeTotal;
    }

    public int getTier(){
        return data.get(4);
    }

    private void addPlayerInventory(@Nonnull Inventory playerInv) {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
    }

    private void addPlayerHotbar(@Nonnull Inventory playerInv) {
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInv, col, 8 + col * 18, 142));
        }
    }

    @Override
    public boolean stillValid(@Nonnull Player player) {
        return true;
    }

    @Override
    @Nonnull
    public ItemStack quickMoveStack(@Nonnull Player player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack originalStack = slot.getItem();
            newStack = originalStack.copy();

            if (index < 4) {
                if (!this.moveItemStackTo(originalStack, 4, this.slots.size(), true))
                    return ItemStack.EMPTY;
            } else if (!this.moveItemStackTo(originalStack, 0, 4, false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty())
                slot.set(ItemStack.EMPTY);
            else
                slot.setChanged();
        }
        return newStack;
    }
}
