package com.publicstaticfinalgames.saddlestand.renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.publicstaticfinalgames.saddlestand.Main;
import com.publicstaticfinalgames.saddlestand.models.ModelSaddle;

public class SaddleRenderer extends TileEntitySpecialRenderer implements IItemRenderer {

	ModelSaddle model = new ModelSaddle();

	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
		bindTexture(new ResourceLocation(Main.MODID + ":saddle.png"));

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) var2 + 0.5F, (float) var4 + 1.5F, (float) var6 + 0.5F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		//GL11.glTranslatef(0.5F, 1.0F, 0.5F);
		model.Base.render(0.0625F);
		model.Frame1.render(0.0625F);
		model.Frame2.render(0.0625F);
		model.Leg1.render(0.0625F);
		model.Leg2.render(0.0625F);
		model.Leg3.render(0.0625F);
		model.Leg4.render(0.0625F);
		model.Saddle_base.render(0.0625F);
		model.Strip1.render(0.0625F);
		model.Strip2.render(0.0625F);
		model.IronPlate1.render(0.0625F);
		model.IronPlate2.render(0.0625F);
		model.Saddle_base_2.render(0.0625F);
		model.Saddle_base_1.render(0.0625F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		bindTexture(new ResourceLocation(Main.MODID + ":saddle.png"));

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) 0 + 0.5F, (float) 0 + 1.5F, (float) 0 + 0.5F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		//GL11.glTranslatef(0.5F, 1.0F, 0.5F);
		model.Base.render(0.0625F);
		model.Frame1.render(0.0625F);
		model.Frame2.render(0.0625F);
		model.Leg1.render(0.0625F);
		model.Leg2.render(0.0625F);
		model.Leg3.render(0.0625F);
		model.Leg4.render(0.0625F);
		model.Saddle_base.render(0.0625F);
		model.Strip1.render(0.0625F);
		model.Strip2.render(0.0625F);
		model.IronPlate1.render(0.0625F);
		model.IronPlate2.render(0.0625F);
		model.Saddle_base_2.render(0.0625F);
		model.Saddle_base_1.render(0.0625F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

}
