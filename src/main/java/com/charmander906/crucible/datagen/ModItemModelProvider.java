package com.charmander906.crucible.datagen;

import com.charmander906.crucible.Crucible;
import com.charmander906.crucible.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * Generates simple, non-trim item models for all Crucible armor items.
 * Dynamic Trim (or vanilla trim rendering) will handle overlay logic at runtime.
 */
public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Crucible.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Crucible.LOGGER.info("[ItemModelGen] Generating base armor item models (no trim overrides)...");

        for (RegistryObject<Item> entry : ModItems.ITEMS.getEntries()) {
            Item item = entry.get();
            if (!(item instanceof ArmorItem)) continue;

            String armorName = entry.getId().getPath();
            ResourceLocation baseTexture = new ResourceLocation(Crucible.MODID, "item/" + armorName);

            // Simple non-trimmed item model (Dynamic Trim will overlay trims at runtime)
            getBuilder(armorName)
                    .parent(new ModelFile.UncheckedModelFile("item/generated"))
                    .texture("layer0", baseTexture);
        }

        Crucible.LOGGER.info("[ItemModelGen] Armor model generation complete.");
    }
}
