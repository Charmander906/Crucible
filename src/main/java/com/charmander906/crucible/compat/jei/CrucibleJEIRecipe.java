package com.charmander906.crucible.compat.jei;

import com.charmander906.crucible.crucible.CrucibleRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class CrucibleJEIRecipe {
    private final Ingredient top;
    private final int topCount;
    private final Ingredient bottom;
    private final ItemStack output;
    private final int tier;

    public CrucibleJEIRecipe(CrucibleRecipe recipe) {
        this.top = recipe.getTopInput();
        this.topCount = recipe.getTopCount();
        this.bottom = recipe.getBottomInput();
        this.output = recipe.getResultItem().copy();
        this.tier = recipe.getTier();
    }

    public Ingredient  getTop()     { return top; }
    public int         getTopCount(){ return topCount; }
    public Ingredient  getBottom()  { return bottom; }
    public ItemStack   getOutput()  { return output; }
    public int         getTier()    { return tier; }

    public List<Ingredient> getInputs() {
        return List.of(top, bottom);
    }
}
