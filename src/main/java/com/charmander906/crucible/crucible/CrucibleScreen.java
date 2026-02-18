package com.charmander906.crucible.crucible;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import javax.annotation.Nonnull;

public class CrucibleScreen extends AbstractContainerScreen<CrucibleMenu> {

    private static final ResourceLocation GUI_TEXTURE =
        new ResourceLocation("crucible", "textures/gui/container/crucible_gui.png");
    private static final ResourceLocation FIRE_TEXTURE =
        new ResourceLocation("crucible", "textures/gui/container/crucible_fire.png");
    private static final ResourceLocation PROGRESS_TEXTURE =
        new ResourceLocation("crucible", "textures/gui/container/crucible_progress_bar.png");
    private static final ResourceLocation HYPERCHARGED_PROGRESS_TEXTURE =
        new ResourceLocation("crucible", "textures/gui/container/hypercharged_crucible_progress_bar.png");

    private static final int FIRE_WIDTH = 14;
    private static final int FIRE_HEIGHT = 14;

    private static final int PROGRESS_WIDTH = 24;
    private static final int PROGRESS_HEIGHT = 24;
    private static final int PROGRESS_FRAMES = 41;

    public CrucibleScreen(CrucibleMenu menu, @Nonnull net.minecraft.world.entity.player.Inventory inv, @Nonnull Component title) {
        super(menu, inv, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(@Nonnull GuiGraphics graphics, float partialTicks, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        graphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 176, 166);

        if (menu.isBurning()) {
            int burn = menu.getBurnProgressScaled(FIRE_HEIGHT);
            if (burn > 0) {
                RenderSystem.setShaderTexture(0, FIRE_TEXTURE);
                graphics.blit(FIRE_TEXTURE,
                    x + 44, y + 26 + (FIRE_HEIGHT - burn),
                    0, FIRE_HEIGHT - burn,
                    FIRE_WIDTH, burn,
                    FIRE_WIDTH, FIRE_HEIGHT);
            }
        }

        ResourceLocation EFFECTIVE_PROGRESS_TEXTURE;
        if (menu.getTier() == 4) {
            EFFECTIVE_PROGRESS_TEXTURE = HYPERCHARGED_PROGRESS_TEXTURE;
        }else{
            EFFECTIVE_PROGRESS_TEXTURE = PROGRESS_TEXTURE;
        }

        int frame = menu.getCookProgressScaled(PROGRESS_FRAMES);
        if (frame > 0) {
            RenderSystem.setShaderTexture(0, EFFECTIVE_PROGRESS_TEXTURE);
            int texY = frame * PROGRESS_HEIGHT;
            graphics.blit(EFFECTIVE_PROGRESS_TEXTURE,
                x + 82, y + 32,
                0, texY,
                PROGRESS_WIDTH, PROGRESS_HEIGHT,
                24, 24 * 41);
        }
    }

    @Override
    public void render(@Nonnull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTicks);
        renderTooltip(graphics, mouseX, mouseY);
    }
}
