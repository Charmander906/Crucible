package com.charmander906.crucible.registry;

import com.charmander906.crucible.handlers.RemoveItemsLootModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.mojang.serialization.Codec;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM_SERIALIZERS =
        DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, "crucible");

    public static final RegistryObject<Codec<RemoveItemsLootModifier>> REMOVE_ITEMS =
        GLM_SERIALIZERS.register("remove_items", () -> RemoveItemsLootModifier.CODEC);
}
