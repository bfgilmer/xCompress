package com.bfgilmer.xcompress.tileentity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.bfgilmer.xcompress.Xcompress;
import com.bfgilmer.xcompress.blocks.XcompressBlocks;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class XcompressTileEntities {

	private static final List<Supplier<TileEntityType<?>>> ENTRIES = new ArrayList<>();
	public static final RegistryObject<TileEntityType<Flint1TileEntity>> FLINT1 = register("flint1_vac",
			Flint1TileEntity::new, () -> new Block[] { XcompressBlocks.FLINT_1.get() });
	public static final RegistryObject<TileEntityType<Flint2TileEntity>> FLINT2 = register("flint2_vac",
			Flint2TileEntity::new, () -> new Block[] { XcompressBlocks.FLINT_2.get() });
	public static final RegistryObject<TileEntityType<Flint3TileEntity>> FLINT3 = register("flint3_vac",
			Flint3TileEntity::new, () -> new Block[] { XcompressBlocks.FLINT_3.get() });
	public static final RegistryObject<TileEntityType<Flint4TileEntity>> FLINT4 = register("flint4_vac",
			Flint4TileEntity::new, () -> new Block[] { XcompressBlocks.FLINT_4.get() });
	
	public static final RegistryObject<TileEntityType<CompactorMachineTileEntity>> COMPACTOR = register("compactor",
			CompactorMachineTileEntity::new, () -> new Block[] { XcompressBlocks.COMPACTOR.get() });

	public static final RegistryObject<TileEntityType<MachineFrameTileEntity>> MACHINE_FRAME = register("machine_frame",
			MachineFrameTileEntity::new, () -> new Block[] { XcompressBlocks.MACHINE_FRAME.get() });

	@SubscribeEvent
	public void onRegisterTypes(RegistryEvent.Register<TileEntityType<?>> event) {
		IForgeRegistry<TileEntityType<?>> registry = event.getRegistry();

		ENTRIES.stream().map(Supplier::get).forEach(registry::register);
	}

	@OnlyIn(Dist.CLIENT)
	public static void onClientSetup() {
	}

	private static <T extends TileEntityType<?>> RegistryObject<T> register(String name, Supplier<TileEntity> tile,
			Supplier<Block[]> blocks) {
		ResourceLocation loc = new ResourceLocation(Xcompress.MOD_ID, name);
		ENTRIES.add(() -> TileEntityType.Builder.of(tile, blocks.get()).build(null).setRegistryName(loc));
		return RegistryObject.of(loc, ForgeRegistries.TILE_ENTITIES);
	}
}
