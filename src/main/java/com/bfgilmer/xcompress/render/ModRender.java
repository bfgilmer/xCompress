package com.bfgilmer.xcompress.render;

import com.bfgilmer.xcompress.blocks.ModBlocks;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRender {
	    @SubscribeEvent
	    public static void onRenderTypeSetup(FMLClientSetupEvent event) {
	        event.enqueueWork(() -> {
	            RenderTypeLookup.setRenderLayer(ModBlocks.FLINT_1.get(), RenderType.translucent());
	        });
	    }
}
