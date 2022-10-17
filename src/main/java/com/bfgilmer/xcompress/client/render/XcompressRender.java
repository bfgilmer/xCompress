package com.bfgilmer.xcompress.client.render;

import com.bfgilmer.xcompress.blocks.XcompressBlocks;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class XcompressRender {
	    @SubscribeEvent
	    public static void onRenderTypeSetup(FMLClientSetupEvent event) {
	        event.enqueueWork(() -> {
	            RenderTypeLookup.setRenderLayer(XcompressBlocks.FLINT_1.get(), RenderType.translucent());
	        });
	    }
}
