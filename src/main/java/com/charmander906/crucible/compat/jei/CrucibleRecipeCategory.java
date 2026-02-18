package com.charmander906.crucible.compat.jei;

import com.charmander906.crucible.registry.ModBlocks;
import com.mojang.blaze3d.systems.RenderSystem;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("deprecation")
public class CrucibleRecipeCategory implements IRecipeCategory<CrucibleJEIRecipe> {
    public static final ResourceLocation UID = new ResourceLocation("crucible", "crucible");
    public static final RecipeType<CrucibleJEIRecipe> TYPE =
            RecipeType.create("crucible", "crucible", CrucibleJEIRecipe.class);

    private static final ResourceLocation BG_TEX = new ResourceLocation("crucible", "textures/gui/container/crucible_gui_jei.png");
    private static final ResourceLocation FIRE_TEX = new ResourceLocation("crucible", "textures/gui/container/crucible_fire.png");
    private static final ResourceLocation PROG_TEX = new ResourceLocation("crucible", "textures/gui/container/crucible_progress_bar.png");
    private static final ResourceLocation PROG_TEX_T4 = new ResourceLocation("crucible", "textures/gui/container/hypercharged_crucible_progress_bar.png");

    private final IDrawable icon;
    private final IDrawable background;
    private final Component title;

    public CrucibleRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createBlankDrawable(_getWidth(), _getHeight());
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CRUCIBLE.get()));
        this.title = Component.translatable("gui.crucible.jei.crucible");
    }

    @Override public RecipeType<CrucibleJEIRecipe> getRecipeType() { return TYPE; }
    @Override public Component getTitle() { return title; }
    @Override public IDrawable getBackground() { return background; }
    @Override public IDrawable getIcon() { return icon; }

    private int _getWidth() {
        return 104;
    }

    private int _getHeight() {
        return 72;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull CrucibleJEIRecipe recipe, @Nonnull IFocusGroup focuses) {
        builder.moveRecipeTransferButton(_getWidth(), _getHeight());

        builder.addSlot(RecipeIngredientRole.INPUT, 42, 6)
            .addItemStack(new ItemStack(recipe.getTop().getItems()[0].getItem(), recipe.getTopCount()))
            .setSlotName("top_input");
        builder.addSlot(RecipeIngredientRole.INPUT, 42, 50).addIngredients(recipe.getBottom());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 78, 28).addItemStack(recipe.getOutput());
        builder.addSlot(RecipeIngredientRole.CATALYST, 85, 3).addItemStack(CrucibleJEIPlugin.getCrucibleForTier(recipe.getTier()));
    }


    @Override
    public void draw(@Nonnull CrucibleJEIRecipe recipe, @Nonnull IRecipeSlotsView recipeSlotsView, @Nonnull GuiGraphics gg, double mouseX, double mouseY) {
        RenderSystem.setShaderTexture(0, BG_TEX);
        gg.blit(BG_TEX, 0, 0, 0, 0, _getWidth(), _getHeight(), _getWidth(), _getHeight());

        RenderSystem.setShaderTexture(0, FIRE_TEX);
        gg.blit(FIRE_TEX, 6, 18, 0, 0, 14, 14, 14, 14);

        int totalFrames = 41;
        int frameHeight = 24;
        int currentFrame = (int)((System.currentTimeMillis() / 205) % totalFrames);
        int texY = currentFrame * frameHeight;

        ResourceLocation progTex = recipe.getTier() >= 4 ? PROG_TEX_T4 : PROG_TEX;
        RenderSystem.setShaderTexture(0, progTex);
        gg.blit(progTex, 44, 24, 0, texY, 24, 24, 24, frameHeight * totalFrames);
    }
}
