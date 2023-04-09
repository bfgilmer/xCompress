package com.bfgilmer.xcompress.setup;

import com.bfgilmer.xcompress.Xcompress;
import com.bfgilmer.xcompress.client.screen.FlintContainerScreen;
import com.bfgilmer.xcompress.inventory.XcompressContainers;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Xcompress.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void init(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
//            MenuScreens.register(XcompressContainers.COMPACTOR_CONTAINER, CompactorMachineScreen::new);
            MenuScreens.register(XcompressContainers.FLINT_CONTAINER_1.get(), FlintContainerScreen::new);
            MenuScreens.register(XcompressContainers.FLINT_CONTAINER_2.get(), FlintContainerScreen::new);
            MenuScreens.register(XcompressContainers.FLINT_CONTAINER_3.get(), FlintContainerScreen::new);
            MenuScreens.register(XcompressContainers.FLINT_CONTAINER_4.get(), FlintContainerScreen::new);
        });
    }

}
