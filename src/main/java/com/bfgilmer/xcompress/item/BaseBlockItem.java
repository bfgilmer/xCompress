/**
 * 
 */
package com.bfgilmer.xcompress.item;

import java.util.function.Function;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

/**
 * @author bfgil
 *
 */
public class BaseBlockItem extends BlockItem {
	public BaseBlockItem(Block block, Function<Properties, Properties> properties) {
		super(block, properties.apply(new Properties()));
	}
}
