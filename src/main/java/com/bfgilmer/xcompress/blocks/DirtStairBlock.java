package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.Blocks;

public class DirtStairBlock extends StairsBlock {
	private static final java.util.function.Supplier<BlockState> stateSupplier =  ()->Blocks.DIRT.defaultBlockState();
	private static final Properties properties = AbstractBlock.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL);

	public DirtStairBlock(Integer number) {
		super(stateSupplier, properties);
	}
	
}
