/**
 * 
 */
package com.bfgilmer.xcompress.item;

import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

/**
 * @author bfgil
 *
 */
public class BaseBlockItem extends BlockItem {
	public BaseBlockItem(Block block, Function<Properties, Properties> properties) {
		super(block, properties.apply(new Properties()));
	}
}
