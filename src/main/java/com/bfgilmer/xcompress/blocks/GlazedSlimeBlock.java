/**
 * 
 */
package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * @author bfgil
 *
 */
public class GlazedSlimeBlock extends BaseBlock {

	public GlazedSlimeBlock( ) {
		super(Properties.of(Material.CLAY).sound(SoundType.STONE).strength(0.6f, 0.6f));
	}
	
	public GlazedSlimeBlock(Integer number) {
		super(Properties.of(Material.CLAY).sound(SoundType.STONE).strength(0.6f * number.floatValue(),
				0.6f * (float) Math.pow(2.0f, number.doubleValue())));
	}
}
