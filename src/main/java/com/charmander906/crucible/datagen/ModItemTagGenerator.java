package com.charmander906.crucible.datagen;

import com.charmander906.crucible.Crucible;
import com.charmander906.crucible.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {

    public ModItemTagGenerator(PackOutput output,
                               CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagLookup<Block>> blockTags,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Crucible.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(@Nonnull HolderLookup.Provider provider) {
        // Create the trimmable armor tag builder
        var trimmableArmorTag = this.tag(ItemTags.TRIMMABLE_ARMOR);

        Crucible.LOGGER.info("[TagGen] Starting automatic trimmable armor tagging...");

        // Loop through all registered items
        for (RegistryObject<Item> entry : ModItems.ITEMS.getEntries()) {
            Item item = entry.get();
            if (!(item instanceof ArmorItem)) continue; // Only operate on armor

            // Add to tag
            trimmableArmorTag.add(item);
            Crucible.LOGGER.info("[TagGen] Added {} to #minecraft:trimmable_armors", entry.getId());
        }

        Crucible.LOGGER.info("[TagGen] Finished trimmable armor tagging!");
    }

    @Override
    public String getName() {
        return "Crucible Item Tags";
    }
}
