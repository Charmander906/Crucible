package com.charmander906.crucible.registry;

import com.charmander906.crucible.Crucible;
import com.charmander906.crucible.crucible.CrucibleMenu;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Crucible.MODID);

    public static final RegistryObject<MenuType<CrucibleMenu>> CRUCIBLE =
        MENUS.register("crucible",
            () -> IForgeMenuType.create((id, inv, data) -> {
                return new CrucibleMenu(id, inv, new ItemStackHandler(4), new SimpleContainerData(5));
            })
        );

    public static void register(IEventBus modEventBus) {
        MENUS.register(modEventBus);
    }
}
