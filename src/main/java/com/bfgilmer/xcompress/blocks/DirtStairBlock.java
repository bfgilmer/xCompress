package com.bfgilmer.xcompress.blocks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.Blocks;

public class DirtStairBlock extends StairBlock {
	private static final java.util.function.Supplier<BlockState> stateSupplier =  ()->Blocks.DIRT.defaultBlockState();
	private static final Properties properties = Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL);

	public DirtStairBlock(Integer number) {
		super(stateSupplier, properties);
	}
	
}
