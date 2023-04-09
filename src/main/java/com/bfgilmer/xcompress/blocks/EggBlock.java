/**
 * 
 */
package com.bfgilmer.xcompress.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

/**
 * @author bfgil
 *
 */
public class EggBlock extends Block {
	public EggBlock() {
		super(Properties.of(Material.CLAY).sound(SoundType.STONE).strength(0.6f, 0.6f));
	}

	public EggBlock(Integer number) {
		super(Properties.of(Material.CLAY).sound(SoundType.STONE).strength(0.6f * number.floatValue(),
				0.6f * (float) Math.pow(2.0f, number.doubleValue())));
	}

}
