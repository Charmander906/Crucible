package com.charmander906.crucible.registry;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import com.charmander906.crucible.Crucible;
import com.charmander906.crucible.crucible.CrucibleScreen;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(modid = Crucible.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModClient {

    public static void clientSetup(final FMLClientSetupEvent event) {
        MenuScreens.register(ModMenuTypes.CRUCIBLE.get(), CrucibleScreen::new);
    }
}
