/**
 * 
 */
package com.bfgilmer.xcompress.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.particles.IParticleData;

/**
 * @author bfgil
 *
 */
public class EggBlock extends BaseBlock {
	public EggBlock() {
		super(Properties.of(Material.CLAY).sound(SoundType.STONE).strength(0.6f, 0.6f));
	}

	public EggBlock(Integer number, IParticleData particle) {
		super(Properties.of(Material.CLAY).sound(SoundType.STONE).strength(0.6f * number.floatValue(),
				0.6f * (float) Math.pow(2.0f, number.doubleValue())));
	}

}
