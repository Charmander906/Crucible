package com.charmander906.crucible.registry;

import com.charmander906.crucible.Crucible;
import com.charmander906.crucible.crucible.CrucibleRecipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Crucible.MODID);

    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Crucible.MODID);

    public static final RegistryObject<RecipeSerializer<CrucibleRecipe>> CRUCIBLE_SERIALIZER =
            SERIALIZERS.register("crucible", CrucibleRecipe.Serializer::new);

    public static final RegistryObject<RecipeType<CrucibleRecipe>> CRUCIBLE_TYPE =
        TYPES.register("crucible", () -> new RecipeType<CrucibleRecipe>() {
            @Override
            public String toString() {
                return Crucible.MODID + ":crucible";
            }
        });

    public static void register(IEventBus modEventBus) {
        SERIALIZERS.register(modEventBus);
        TYPES.register(modEventBus);
    }
}
