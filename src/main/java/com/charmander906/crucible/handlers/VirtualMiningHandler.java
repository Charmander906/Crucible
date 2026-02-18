package com.charmander906.crucible.handlers;

import com.charmander906.crucible.Crucible;
import com.charmander906.crucible.registry.ModToolTiers;
import com.charmander906.crucible.registry.VirtualMiningRegistry;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.level.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Crucible.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VirtualMiningHandler {

    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public static void onBlockBreak(BreakEvent event) {
        Player player = event.getPlayer();
        if (player == null) return;

        ItemStack toolStack = player.getMainHandItem();
        if (toolStack.isEmpty() || !(toolStack.getItem() instanceof TieredItem tieredTool)) return;

        Tier tier = tieredTool.getTier();
        float toolLevel = (tier instanceof ModToolTiers modTier) ? modTier.getVirtualLevel() : tier.getLevel();

        Block block = event.getState().getBlock();
        float requiredLevel = VirtualMiningRegistry.getVirtualLevel(block);

        if (toolLevel < requiredLevel) {
            event.setCanceled(true);
        }
    }
}
