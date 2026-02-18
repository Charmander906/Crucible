package com.charmander906.crucible.handlers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveItemsLootModifier extends LootModifier {
    public static final Codec<RemoveItemsLootModifier> CODEC = RecordCodecBuilder.create(inst -> codecStart(inst)
        .and(ResourceLocation.CODEC.listOf().fieldOf("blocked").forGetter(m -> m.blockedIds))
        .apply(inst, RemoveItemsLootModifier::new));

    private final List<ResourceLocation> blockedIds;
    private final Set<Item> blockedItems;

    protected RemoveItemsLootModifier(LootItemCondition[] conditions, List<ResourceLocation> blocked) {
        super(conditions);
        this.blockedIds = blocked;
        this.blockedItems = blocked.stream()
                .map(ForgeRegistries.ITEMS::getValue)
                .filter(it -> it != null)
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        return new ObjectArrayList<>(generatedLoot.stream()
            .filter(stack -> stack.isEmpty() || !blockedItems.contains(stack.getItem()))
            .collect(Collectors.toList()));
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
