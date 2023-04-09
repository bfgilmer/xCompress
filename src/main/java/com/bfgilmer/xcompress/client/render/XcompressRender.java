package com.bfgilmer.xcompress.client.render;

import com.bfgilmer.xcompress.blocks.XcompressBlocks;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class XcompressRender {
	    @SubscribeEvent
	    public static void onRenderTypeSetup(FMLClientSetupEvent event) {
	        event.enqueueWork(() -> {
	        	ItemBlockRenderTypes.setRenderLayer(XcompressBlocks.FLINT_1.get(), RenderType.translucent());
	        });
	    }
}
