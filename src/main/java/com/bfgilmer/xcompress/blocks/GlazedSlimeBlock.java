/**
 * 
 */
package com.bfgilmer.xcompress.blocks;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * @author bfgil
 *
 */
public class GlazedSlimeBlock extends BaseBlock {
	public GlazedSlimeBlock() {
		super(Properties.of(Material.CLAY).sound(SoundType.STONE).strength(0.6f, 0.6f));
	}

	public GlazedSlimeBlock(Integer number, IParticleData particle) {
		super(Properties.of(Material.CLAY).sound(SoundType.STONE).strength(0.6f * number.floatValue(),
				0.6f * (float) Math.pow(2.0f, number.doubleValue())));
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState blockState, World world, BlockPos blockPosition, Random rand) {
		double d0 = (double) blockPosition.getX() + 0.5D;
		double d1 = (double) blockPosition.getY() + 0.7D;
		double d2 = (double) blockPosition.getZ() + 0.5D;
		world.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}
}
