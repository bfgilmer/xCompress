/**
 * 
 */
package com.bfgilmer.xcompress.blocks;

import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author bfgil
 *
 */
public class BaseBlock extends Block {

	public BaseBlock(Material material, Function<Properties, Properties> properties) {
		super(properties.apply(Properties.of(material)));
	}

	public BaseBlock(Material material, SoundType sound, float hardness, float resistance) {
		super(Properties.of(material).sound(sound).strength(hardness, resistance));
	}

	public BaseBlock(Properties properties) {
		super(properties);
	}

}
