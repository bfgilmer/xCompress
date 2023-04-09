package com.bfgilmer.xcompress.blocks;

import java.util.function.Function;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class SnowBlock extends Block {
	public SnowBlock(Integer number) {
		this(Material.SNOW,
				p -> p.sound(SoundType.SNOW).strength(0.2f * number.floatValue(), (0.2f * number.floatValue()))
						.friction(0.6f * number.floatValue()).speedFactor(number.floatValue()));
	}
	
	public SnowBlock(Material material, Function<Properties, Properties> properties) {
		super(properties.apply(Properties.of(material)));
	}

}
