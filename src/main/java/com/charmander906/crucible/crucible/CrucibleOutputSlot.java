package com.charmander906.crucible.crucible;

import javax.annotation.Nonnull;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraft.world.item.ItemStack;

public class CrucibleOutputSlot extends SlotItemHandler {

    public CrucibleOutputSlot(@Nonnull IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return false;
    }
}
