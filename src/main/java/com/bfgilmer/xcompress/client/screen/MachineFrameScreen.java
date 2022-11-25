package com.bfgilmer.xcompress.client.screen;

import com.bfgilmer.xcompress.Xcompress;
import com.bfgilmer.xcompress.inventory.MachineFrameContainer;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class MachineFrameScreen extends ContainerScreen<MachineFrameContainer> implements IHasContainer<MachineFrameContainer> {
	
	  public final int xSize=186;
	  public final int ySize=138;
	  public final int textureXSize=186;
	  public final int textureYSize=138;
	  
	public MachineFrameScreen(MachineFrameContainer container, PlayerInventory playerInventory, ITextComponent title) {
	    super(container, playerInventory, title);
		
	    this.titleLabelX = 50;
	    this.titleLabelY = 8 + (166 - this.textureYSize)/2;
	    this.inventoryLabelX = 61;
	    this.inventoryLabelY = 42 + (166 - this.textureYSize)/2;
	    
	    this.passEvents = false;
	}

	@Override
	  public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
	    this.renderBackground(matrixStack);
	    super.render(matrixStack, mouseX, mouseY, partialTicks);
	    this.renderTooltip(matrixStack, mouseX, mouseY);
	  }
	
	@Override
	protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
//		   RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);

		    this.minecraft.getTextureManager().bind(new ResourceLocation(Xcompress.MOD_ID, "textures/gui/compactor.png"));

		    int x = (this.width - this.textureXSize) / 2;
		    int y = (this.height - this.textureYSize) / 2;

		    blit(matrixStack, x, y, 0, 0, this.xSize, this.ySize, this.textureXSize, this.textureYSize);
	  }
		
}
