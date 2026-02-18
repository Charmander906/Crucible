package com.charmander906.crucible;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.*;

public class SmartSheepEquipmentLogger {

    /** Track all seen sheep and their last recorded equipment */
    private static final Map<UUID, EnumMap<EquipmentSlot, ItemStack>> LAST_EQUIPMENT = new HashMap<>();

    /** Avoid duplicate logs */
    private static final Set<String> alreadyLogged = new HashSet<>();

    // ----------------------------------------------------------
    // 1. Detect sheep spawning with armor (NBT / modded spawn)
    // ----------------------------------------------------------
    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        if (!(event.getEntity() instanceof Sheep sheep)) return;

        UUID id = sheep.getUUID();
        EnumMap<EquipmentSlot, ItemStack> snapshot = makeSnapshot(sheep);
        LAST_EQUIPMENT.put(id, snapshot);

        // Immediately check for equipment on spawn
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            ItemStack stack = snapshot.get(slot);
            if (!stack.isEmpty()) {
                logEquipmentAdd(sheep, stack, slot, "spawn");
            }
        }
    }

    // ----------------------------------------------------------
    // 2. Detect equipment changes dynamically (per tick)
    // ----------------------------------------------------------
    @SubscribeEvent
    public static void onLevelTick(TickEvent.LevelTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        if (event.level.isClientSide()) return;

        Level level = event.level;

        // Infinite-range AABB (covers whole level)
        AABB everything = new AABB(
                Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY,
                Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY
        );

        // ONLY sheep, no ambiguity
        List<Sheep> sheepList = level.getEntitiesOfClass(
                Sheep.class,   // class filter
                everything,    // bounding box
                e -> true      // optional additional filter
        );

        // Iterate safely
        for (Sheep sheep : sheepList) {
            tickSheep(sheep);
        }
    }

    // Compare snapshot → detect new equipment
    private static void tickSheep(Sheep sheep) {
        UUID id = sheep.getUUID();
        EnumMap<EquipmentSlot, ItemStack> prev =
                LAST_EQUIPMENT.computeIfAbsent(id, u -> new EnumMap<>(EquipmentSlot.class));

        EnumMap<EquipmentSlot, ItemStack> now = makeSnapshot(sheep);

        for (EquipmentSlot slot : EquipmentSlot.values()) {
            ItemStack before = prev.get(slot);
            ItemStack current = now.get(slot);

            // Changed AND is not empty
            if (!ItemStack.matches(before, current) && !current.isEmpty()) {
                logEquipmentAdd(sheep, current, slot, "tick-detect");
            }
        }

        LAST_EQUIPMENT.put(id, now);
    }

    // Make a deep copy of equipment state
    private static EnumMap<EquipmentSlot, ItemStack> makeSnapshot(Sheep sheep) {
        EnumMap<EquipmentSlot, ItemStack> map = new EnumMap<>(EquipmentSlot.class);
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            map.put(slot, sheep.getItemBySlot(slot).copy());
        }
        return map;
    }

    // ----------------------------------------------------------
    // Logging helper
    // ----------------------------------------------------------
    private static void logEquipmentAdd(Sheep sheep, ItemStack stack, EquipmentSlot slot, String reason) {
        Item item = stack.getItem();
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(item); // Forge registry lookup
        if (id == null) return;

        String namespace = id.getNamespace();
        String logKey = namespace + ":" + id.getPath() + "@" + slot;

        if (alreadyLogged.contains(logKey)) return;
        alreadyLogged.add(logKey);

        System.out.println("=========================================================");
        System.out.println("[SmartSheepEquipmentLogger] Sheep received equipment");
        System.out.println("  • Slot:      " + slot);
        System.out.println("  • Item:      " + id);
        System.out.println("  • From mod:  " + namespace);
        System.out.println("  • Sheep UUID " + sheep.getUUID());
        System.out.println("  • Location:  " + sheep.blockPosition());
        System.out.println("  • Detected:  " + reason);
        System.out.println("=========================================================");
    }
}
