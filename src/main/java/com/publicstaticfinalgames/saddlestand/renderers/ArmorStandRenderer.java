package com.publicstaticfinalgames.saddlestand.renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.publicstaticfinalgames.saddlestand.Main;
import com.publicstaticfinalgames.saddlestand.models.ModelArmorStand;
import com.publicstaticfinalgames.saddlestand.tileentity.TileEntityArmorStand;

public class ArmorStandRenderer extends TileEntitySpecialRenderer implements IItemRenderer {

	ModelArmorStand model;
	ResourceLocation basic;
	ResourceLocation diamond;
	ResourceLocation iron;
	ResourceLocation gold;

	public ArmorStandRenderer() {
		model = new ModelArmorStand();

		basic = new ResourceLocation(Main.MODID + ":horsecreamy.png");
		diamond = new ResourceLocation(Main.MODID + ":ArmorDiamond.png");
		iron = new ResourceLocation(Main.MODID + ":ARMORiron.PNG");
		gold = new ResourceLocation(Main.MODID + ":ARMORGOLD.PNG");
	}

	@Override
	public void renderTileEntityAt(TileEntity armorStand, double var2, double var4, double var6, float var8) {
		switch (((TileEntityArmorStand) armorStand).armor) {
		case 0:
			bindTexture(basic);
			break;
		case 1:
			bindTexture(diamond);
			break;
		case 2:
			bindTexture(gold);
			break;
		case 3:
			bindTexture(iron);
			break;
		}
		
		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) var2 + 0.5F, (float) var4 + 1.5F, (float) var6 + 0.5F);

		switch (((TileEntityArmorStand) armorStand).direction) {
		case 0:
			GL11.glRotatef(0, 0, -1, 0);
			break;
		case 1:
			GL11.glRotatef(90, 0, -1, 0);
			break;
		case 2:
			GL11.glRotatef(180, 0, -1, 0);
			break;
		case 3:
			GL11.glRotatef(270, 0, -1, 0);
			break;
		}
		GL11.glScalef(1.0F, -1.0F, -1.0F);

		model.mouthBottom.render(0.0625F);
		model.mouthTop.render(0.0625F);
		model.horseLeftEar.render(0.0625F);
		model.horseRightEar.render(0.0625F);
		model.backLeftLeg.render(0.0625F);
		model.backLeftShin.render(0.0625F);
		model.backLeftHoof.render(0.0625F);
		model.backRightLeg.render(0.0625F);
		model.backRightShin.render(0.0625F);
		model.backRightHoof.render(0.0625F);
		model.frontLeftLeg.render(0.0625F);
		model.frontLeftShin.render(0.0625F);
		model.frontLeftHoof.render(0.0625F);
		model.frontRightLeg.render(0.0625F);
		model.frontRightShin.render(0.0625F);
		model.frontRightHoof.render(0.0625F);
		model.body.render(0.0625F);
		model.tailBase.render(0.0625F);
		model.tailMiddle.render(0.0625F);
		model.tailTip.render(0.0625F);
		model.neck.render(0.0625F);
		model.mane.render(0.0625F);

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		bindTexture(basic);

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) 0 + 0.5F, (float) 0 + 1.5F, (float) 0 + 0.5F);
		GL11.glRotatef(180, 0, 1, 0);
		GL11.glScalef(1.0F, -1.0F, -1.0F);

		model.mouthBottom.render(0.0625F);
		model.mouthTop.render(0.0625F);
		model.horseLeftEar.render(0.0625F);
		model.horseRightEar.render(0.0625F);
		model.backLeftLeg.render(0.0625F);
		model.backLeftShin.render(0.0625F);
		model.backLeftHoof.render(0.0625F);
		model.backRightLeg.render(0.0625F);
		model.backRightShin.render(0.0625F);
		model.backRightHoof.render(0.0625F);
		model.frontLeftLeg.render(0.0625F);
		model.frontLeftShin.render(0.0625F);
		model.frontLeftHoof.render(0.0625F);
		model.frontRightLeg.render(0.0625F);
		model.frontRightShin.render(0.0625F);
		model.frontRightHoof.render(0.0625F);
		model.body.render(0.0625F);
		model.tailBase.render(0.0625F);
		model.tailMiddle.render(0.0625F);
		model.tailTip.render(0.0625F);
		model.neck.render(0.0625F);
		model.mane.render(0.0625F);

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

}
