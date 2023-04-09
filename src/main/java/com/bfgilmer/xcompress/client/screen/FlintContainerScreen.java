package com.bfgilmer.xcompress.client.screen;

import com.bfgilmer.xcompress.inventory.FlintContainer;
import com.bfgilmer.xcompress.inventory.FlintTypes;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FlintContainerScreen extends AbstractContainerScreen<FlintContainer> { 

  private final FlintTypes hopperType;

  private final int textureXSize;
  private final int textureYSize;

  private int xSize;
  private int ySize;

  public FlintContainerScreen(FlintContainer container, Inventory playerInventory, Component title) {
    super(container, playerInventory, title);

    this.hopperType = container.getHopperType();
    this.xSize = container.getHopperType().xSize;
    this.ySize = container.getHopperType().ySize;
    this.textureXSize = container.getHopperType().textureXSize;
    this.textureYSize = container.getHopperType().textureYSize;

    this.titleLabelX = 50;
    this.titleLabelY = 8 + (166 - this.textureYSize)/2;
    this.inventoryLabelX = 61;
    this.inventoryLabelY = 42 + (166 - this.textureYSize)/2;
    
    this.passEvents = false;
  }

  @Override
  public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
    this.renderBackground(matrixStack);
    super.render(matrixStack, mouseX, mouseY, partialTicks);
    this.renderTooltip(matrixStack, mouseX, mouseY);
  }


@Override
protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, this.hopperType.getGuiTexture());

	    int x = (this.width - this.textureXSize) / 2;
	    int y = (this.height - this.textureYSize) / 2;

	    blit(matrixStack, x, y, 0, 0, this.xSize, this.ySize, this.textureXSize, this.textureYSize);
  }

}

