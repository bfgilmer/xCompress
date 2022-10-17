package com.bfgilmer.xcompress.inventory;

import com.bfgilmer.xcompress.Xcompress;

import net.minecraft.block.Block;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.shapes.VoxelShape;

public class FlintTypes implements IStringSerializable { 
	  private static final FlintTypes FLINT_VAC[] = {
			  new FlintTypes(5, 1, -16D, -16D, -16D, 16D, 16D, 16D, new ResourceLocation(Xcompress.MOD_ID, "textures/gui/flint_container.png")),       // 0 above (1) 
			  new FlintTypes(5, 1, -32D, -32D, -32D, 48D, 48D, 48D, new ResourceLocation(Xcompress.MOD_ID, "textures/gui/flint1_container.png")),       // 1 3 x 3 x 3 (27)
			  new FlintTypes(7, 5, -80D, -80D, -48D, 96D, 96D, 64D, new ResourceLocation(Xcompress.MOD_ID, "textures/gui/flint2_container.png")),       // 6 11 x 11 x 5 (605)
			  new FlintTypes(9, 8, -128D, -64D, -128D, 144D, 144D, 80D, new ResourceLocation(Xcompress.MOD_ID, "textures/gui/flint3_container.png")),   // 8 17 x 17 x 7 (2023)
			  new FlintTypes(9, 12, -192D, -80D, -192D, 208D, 208D, 96D, new ResourceLocation(Xcompress.MOD_ID, "textures/gui/flint3_container.png")),  // 12 25 x 25 x 9 (5625) 			  
	  };
	 
	  public final int xSize=186;
	  public final int ySize=138;
	  public final int textureXSize=186;
	  public final int textureYSize=138;
	  
	  // container dimensions
	  private final int columns;
	  
      private final int range;
  	  private final VoxelShape CollectionArea;

	  private ResourceLocation guiTexture;
     
	  private FlintTypes(int col, int range, double x, double y, double z, double a, double b, double c, ResourceLocation texture ) {
		// Container 
	    this.columns = col;
	    
	    // Suck area
	    this.range = range;
	    this.CollectionArea = Block.box(x, y, z, a, b, c);
	    this.guiTexture = texture;
	  }

	static public FlintTypes createFlintType(int level) {
		return FLINT_VAC[level];
	}
	
	static public VoxelShape getSuckShape(int level) {
		return FLINT_VAC[level].getCollectionArea();
	}

	private VoxelShape getCollectionArea() {
		return CollectionArea;
	}

	@Override
	public String getSerializedName() {
		return "FlintHopper";
	}

	public int getRange() {
		return range;
	}

	public int getColumns() {
		return columns;
	}

	public int getSlots() {
		return this.columns;
	}

	public static int getLevel(int level) {
		if ((level > 0) && (level < FLINT_VAC.length)) return level;
		return 0;
	}

	public ResourceLocation getGuiTexture() {
		return guiTexture;
	}
}

