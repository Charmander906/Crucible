package com.charmander906.crucible.compat.jei;

import com.charmander906.crucible.crucible.CrucibleScreen;
import com.charmander906.crucible.crucible.CrucibleRecipe;
import com.charmander906.crucible.registry.ModBlocks;
import com.charmander906.crucible.registry.ModRecipes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.*;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import mezz.jei.api.runtime.IJeiRuntime;

import java.util.List;

import javax.annotation.Nonnull;

@JeiPlugin
public class CrucibleJEIPlugin implements IModPlugin {
    private static final ResourceLocation ID = new ResourceLocation("crucible", "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerCategories(@Nonnull IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new CrucibleRecipeCategory(guiHelper));
    }

    @Override
    public void registerRecipes(@Nonnull IRecipeRegistration registration) {
        Minecraft mc = Minecraft.getInstance();
        Level level = mc.level;
        if (level == null) return;

        List<CrucibleRecipe> recipes =
            level.getRecipeManager().getAllRecipesFor(ModRecipes.CRUCIBLE_TYPE.get());

        List<CrucibleJEIRecipe> jeiRecipes = recipes.stream()
            .map(CrucibleJEIRecipe::new)
            .toList();

        registration.addRecipes(CrucibleRecipeCategory.TYPE, jeiRecipes);
    }

    @Override
    public void registerRecipeCatalysts(@Nonnull IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CRUCIBLE.get()), CrucibleRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.REINFORCED_CRUCIBLE.get()), CrucibleRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.SUPERHEATED_CRUCIBLE.get()), CrucibleRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.HYPERCHARGED_CRUCIBLE.get()), CrucibleRecipeCategory.TYPE);
    }

    @Override
    public void registerGuiHandlers(@Nonnull IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(CrucibleScreen.class, 82, 32, 24, 24, CrucibleRecipeCategory.TYPE);
    }

    @Override
    public void onRuntimeAvailable(@Nonnull IJeiRuntime jeiRuntime) {
        // No runtime actions needed
    }

    public static ItemStack getCrucibleForTier(int tier) {
        return switch (Math.max(1, Math.min(4, tier))) {
            case 4 -> new ItemStack(ModBlocks.HYPERCHARGED_CRUCIBLE.get());
            case 3 -> new ItemStack(ModBlocks.SUPERHEATED_CRUCIBLE.get());
            case 2 -> new ItemStack(ModBlocks.REINFORCED_CRUCIBLE.get());
            default -> new ItemStack(ModBlocks.CRUCIBLE.get());
        };
    }
}