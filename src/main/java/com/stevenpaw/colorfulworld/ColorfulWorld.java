package com.stevenpaw.colorfulworld;

import com.stevenpaw.colorfulworld.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod("colorfulworld")
public class ColorfulWorld
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "colorfulworld";
    public static ColorfulWorld instance;

    public ColorfulWorld()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        instance = this;

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {

    }

    public static class ColorfulWorldItemGroup extends ItemGroup
    {
        public static final ColorfulWorldItemGroup instance = new ColorfulWorldItemGroup(ItemGroup.GROUPS.length, "colorfulworldtab");
        private ColorfulWorldItemGroup(int index, String label)
        {
            super(index,label);
        }

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(BlockInit.example_block);
        }
    }
}
