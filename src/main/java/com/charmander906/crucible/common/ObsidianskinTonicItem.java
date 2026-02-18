package com.charmander906.crucible.common;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.charmander906.crucible.registry.ModEffects;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.network.chat.Component;

public class ObsidianskinTonicItem extends Item {
    private float pyrewardDuration;

    public ObsidianskinTonicItem(Properties properties) {
        super(properties);
        pyrewardDuration = 2f;
    }

    @Override
    public ItemStack finishUsingItem(@Nonnull ItemStack stack, @Nonnull Level level, @Nonnull LivingEntity entity) {
        if (entity instanceof Player player) {
            if (!level.isClientSide) {
                player.addEffect(new MobEffectInstance(ModEffects.PYREWARD.get(), (int)(20 * 60 * pyrewardDuration)));
            }

            if (!player.getAbilities().instabuild) {
                stack.shrink(1);

                if (stack.isEmpty()) {
                    return new ItemStack(Items.GLASS_BOTTLE);
                } else {
                    if (!player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE))) {
                        player.drop(new ItemStack(Items.GLASS_BOTTLE), false);
                    }
                }
            }
        }

        return stack;
    }


    @Override
    public UseAnim getUseAnimation(@Nonnull ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public int getUseDuration(@Nonnull ItemStack stack) {
        return 32;
    }

    @Override
    public void appendHoverText(
            @Nonnull ItemStack stack,
            @Nullable Level level,
            @Nonnull List<Component> tooltip,
            @Nonnull TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        MobEffectInstance effect = new MobEffectInstance(ModEffects.PYREWARD.get(), (int)(20 * 60 * pyrewardDuration));

        Component effectName = effect.getEffect().getDisplayName();

        Component duration = MobEffectUtil.formatDuration(effect, 1.0F);

        tooltip.add(effectName.copy()
            .append(" (")
            .append(duration)
            .withStyle(ChatFormatting.BLUE)
            .append(")"));
    }



    @Override
    public InteractionResultHolder<ItemStack> use(@Nonnull Level level, @Nonnull Player player, @Nonnull InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }
}
