package com.charmander906.crucible;

import com.charmander906.crucible.registry.ModBlockEntities;
import com.charmander906.crucible.registry.ModBlocks;
import com.charmander906.crucible.registry.ModClient;
import com.charmander906.crucible.registry.ModEffects;
import com.charmander906.crucible.registry.ModItems;
import com.charmander906.crucible.registry.ModLootModifiers;
import com.charmander906.crucible.registry.ModMenuTypes;
import com.charmander906.crucible.registry.ModRecipes;
import com.charmander906.crucible.registry.ModSoundEvents;
import com.charmander906.crucible.registry.ModLootModifiers;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.io.InputStream;

import org.slf4j.Logger;

@SuppressWarnings("unused")
@Mod(Crucible.MODID)
public class Crucible
{
    public static final String MODID = "crucible";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> CRUCIBLE_TAB = CREATIVE_MODE_TABS.register("crucible_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> new ItemStack(ModItems.CRUCIBLE.get()))
            .title(Component.translatable("creativetab.crucible.crucible_tab"))
            .displayItems((parameters, output) -> {
                ModItems.ORDERED_ITEMS.forEach(item -> output.accept(item.get()));
            })
            .build());

    public Crucible(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModBlocks.BLOCKS.register(modEventBus);
        ModSoundEvents.SOUND_EVENTS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModEffects.MOB_EFFECTS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModLootModifiers.GLM_SERIALIZERS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(ModClient::clientSetup);
        LOGGER.info("[CRUCIBLE LOGGER]: Mod constructor finished.");
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        /*
        LOGGER.info("[CRUCIBLE DIAGNOSTICS] =====================");
        LOGGER.info("[CRUCIBLE DIAGNOSTICS] Common setup event fired!");

        event.enqueueWork(() -> {
            // --- SOUND REGISTRY ---
            LOGGER.info("[CRUCIBLE DIAGNOSTICS] Sound registry initialized: {}", ForgeRegistries.SOUND_EVENTS != null);
            LOGGER.info("[CRUCIBLE DIAGNOSTICS] Sound count: {}", ForgeRegistries.SOUND_EVENTS.getValues().size());

            if (ModSoundEvents.DRAGON_DISC != null && ModSoundEvents.DRAGON_DISC.isPresent()) {
                SoundEvent se = ModSoundEvents.DRAGON_DISC.get();
                ResourceLocation id = ForgeRegistries.SOUND_EVENTS.getKey(se);
                LOGGER.info("[CRUCIBLE DIAGNOSTICS] Dragon Disc SoundEvent present: {} (id = {})", se != null, id);
            } else {
                LOGGER.warn("[CRUCIBLE DIAGNOSTICS] WARNING: DRAGON_DISC sound not found or not registered!");
            }

            // --- ITEM REGISTRY ---
            LOGGER.info("[CRUCIBLE DIAGNOSTICS] Item registry initialized: {}", ForgeRegistries.ITEMS != null);
            LOGGER.info("[CRUCIBLE DIAGNOSTICS] Item count: {}", ForgeRegistries.ITEMS.getValues().size());

            if (ModItems.DRAGON_DISC != null && ModItems.DRAGON_DISC.isPresent()) {
                Item item = ModItems.DRAGON_DISC.get();
                ResourceLocation id = ForgeRegistries.ITEMS.getKey(item);
                LOGGER.info("[CRUCIBLE DIAGNOSTICS] Dragon Disc Item present: {} (id = {})", item != null, id);
            } else {
                LOGGER.warn("[CRUCIBLE DIAGNOSTICS] WARNING: DRAGON_DISC item not found or not registered!");
            }

            // --- PACK.MCMETA VALIDATION ---
            InputStream packMeta = Crucible.class.getResourceAsStream("/pack.mcmeta");
            LOGGER.info("[CRUCIBLE DIAGNOSTICS] pack.mcmeta found in JAR: {}", packMeta != null);
            if (packMeta == null) {
                LOGGER.error("[CRUCIBLE DIAGNOSTICS] MISSING pack.mcmeta! Resource pack validation will fail!");
            }

            // --- SOUND FILE EXISTENCE CHECK ---
            InputStream soundFile = Crucible.class.getResourceAsStream("/assets/crucible/sounds/dragon_disc.ogg");
            LOGGER.info("[CRUCIBLE DIAGNOSTICS] dragon_disc.ogg found in JAR: {}", soundFile != null);
            if (soundFile == null) {
                LOGGER.error("[CRUCIBLE DIAGNOSTICS] MISSING sound file for dragon_disc!");
            }

            // --- SOUNDS.JSON VALIDATION ---
            InputStream soundsJson = Crucible.class.getResourceAsStream("/assets/crucible/sounds.json");
            LOGGER.info("[CRUCIBLE DIAGNOSTICS] sounds.json found in JAR: {}", soundsJson != null);
            if (soundsJson == null) {
                LOGGER.error("[CRUCIBLE DIAGNOSTICS] MISSING sounds.json!");
            }

            // --- LANGUAGE FILE CHECK ---
            InputStream langJson = Crucible.class.getResourceAsStream("/assets/crucible/lang/en_us.json");
            LOGGER.info("[CRUCIBLE DIAGNOSTICS] en_us.json found in JAR: {}", langJson != null);
            if (langJson == null) {
                LOGGER.warn("[CRUCIBLE DIAGNOSTICS] Missing en_us.json (subtitle text may fail)!");
            }

            // --- FINAL STATUS ---
            LOGGER.info("[CRUCIBLE DIAGNOSTICS] Common setup completed without immediate exceptions.");
            LOGGER.info("[CRUCIBLE DIAGNOSTICS] =====================");
        });
        */
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
