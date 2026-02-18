package com.charmander906.crucible;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Crucible.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class TrimDebugLogger {
    private static boolean logged = false;

    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.START || logged) return;
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        logged = true;

        Crucible.LOGGER.info("=== [Trim Debug] Starting trim verification ===");

        for (Item item : net.minecraftforge.registries.ForgeRegistries.ITEMS) {
            ResourceLocation id = net.minecraftforge.registries.ForgeRegistries.ITEMS.getKey(item);
            if (id == null || !id.getNamespace().equals(Crucible.MODID)) continue;

            if (item instanceof ArmorItem armor) {
                boolean inTag = armor.builtInRegistryHolder().is(ItemTags.TRIMMABLE_ARMOR);
                Crucible.LOGGER.info("[Trim Debug] {} -> ArmorType={} TrimmableTag={}", 
                    id, armor.getEquipmentSlot().getName(), inTag);
            }
        }

        Crucible.LOGGER.info("=== [Trim Debug] Done ===");
    }
}
