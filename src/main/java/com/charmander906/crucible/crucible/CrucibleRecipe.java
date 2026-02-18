package com.charmander906.crucible.crucible;

import com.charmander906.crucible.registry.ModRecipes;
import com.google.gson.JsonObject;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;

/**
 * A Crucible recipe that consumes a variable number of the top ingredient
 * and one of the bottom ingredient to produce an output item.
 */
public class CrucibleRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final Ingredient topInput;
    private final Ingredient bottomInput;
    private final int topCount;
    private final ItemStack output;
    private final int tier;

    public CrucibleRecipe(ResourceLocation id, Ingredient topInput, int topCount, Ingredient bottomInput, ItemStack output, int tier) {
        this.id = id;
        this.topInput = topInput;
        this.topCount = topCount;
        this.bottomInput = bottomInput;
        this.output = output;
        this.tier = tier;
    }

    @Override
    public boolean matches(@Nonnull SimpleContainer container, @Nonnull Level level) {
        if (level.isClientSide) return false;

        ItemStack top = container.getItem(0);
        ItemStack bottom = container.getItem(1);

        boolean topMatches = topInput.test(top) && top.getCount() >= topCount;
        boolean bottomMatches = bottomInput.test(bottom);

        return topMatches && bottomMatches;
    }

    @Override
    @Nonnull
    public ItemStack assemble(@Nonnull SimpleContainer container, @Nonnull RegistryAccess registry) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    @Nonnull
    public ItemStack getResultItem(@Nonnull RegistryAccess registry) {
        return output;
    }

    @Nonnull
    public ItemStack getResultItem() {
        return output;
    }

    @Nonnull
    public ResourceLocation getId() {
        return id;
    }

    @Override
    @Nonnull
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.CRUCIBLE_SERIALIZER.get();
    }

    @Override
    @Nonnull
    public RecipeType<?> getType() {
        return ModRecipes.CRUCIBLE_TYPE.get();
    }

    public Ingredient getTopInput() {
        return topInput;
    }

    public int getTopCount() {
        return topCount;
    }

    public Ingredient getBottomInput() {
        return bottomInput;
    }

    public ItemStack getOutput() {
        return output;
    }

    public int getTier() {
        return tier;
    }

    public static class Serializer implements RecipeSerializer<CrucibleRecipe> {

        @Override
        @Nonnull
        public CrucibleRecipe fromJson(@Nonnull ResourceLocation id, @Nonnull JsonObject json) {
            JsonObject topJson = GsonHelper.getAsJsonObject(json, "ingredient_top");
            Ingredient top = Ingredient.fromJson(topJson);
            int topCount = GsonHelper.getAsInt(topJson, "count", 1);

            Ingredient bottom = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient_bottom"));
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
            int tier = GsonHelper.getAsInt(json, "tier", 0);

            return new CrucibleRecipe(id, top, topCount, bottom, output, tier);
        }

        @Override
        @Nonnull
        public CrucibleRecipe fromNetwork(@Nonnull ResourceLocation id, @Nonnull FriendlyByteBuf buf) {
            Ingredient top = Ingredient.fromNetwork(buf);
            int topCount = buf.readInt();
            Ingredient bottom = Ingredient.fromNetwork(buf);
            ItemStack output = buf.readItem();
            int tier = buf.readInt();
            return new CrucibleRecipe(id, top, topCount, bottom, output, tier);
        }

        @Override
        public void toNetwork(@Nonnull FriendlyByteBuf buf, @Nonnull CrucibleRecipe recipe) {
            recipe.topInput.toNetwork(buf);
            buf.writeInt(recipe.topCount);
            recipe.bottomInput.toNetwork(buf);
            buf.writeItem(recipe.output);
            buf.writeInt(recipe.tier);
        }
    }
}
