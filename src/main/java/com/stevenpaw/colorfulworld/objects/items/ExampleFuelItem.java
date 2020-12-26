package com.stevenpaw.colorfulworld.objects.items;

import com.stevenpaw.colorfulworld.init.BlockInit;
import com.stevenpaw.colorfulworld.util.helpers.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ExampleFuelItem extends Item
{

    public ExampleFuelItem(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        if(KeyboardHelper.isHoldingShift())
        {
            tooltip.add(new StringTextComponent("This Example Item burns"));
            tooltip.add(new StringTextComponent("for 600 Ticks"));
        } else {
            tooltip.add(new StringTextComponent("Press " + "\u00A7c" + "SHIFT" + "\u00A77" + " for more info!"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 600;
    }
}
