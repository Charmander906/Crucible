package com.charmander906.crucible.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.charmander906.crucible.Crucible;

@SuppressWarnings("unused")
public class ModSoundEvents {
        public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
                DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Crucible.MODID);
        /*
        public static final RegistryObject<SoundEvent> DRAGON_DISC =
                SOUND_EVENTS.register("dragon_disc",
                        () -> SoundEvent.createVariableRangeEvent(
                                new ResourceLocation(Crucible.MODID, "dragon_disc")));
        */
}
