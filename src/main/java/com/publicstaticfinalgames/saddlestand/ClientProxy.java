package com.publicstaticfinalgames.saddlestand;


import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.publicstaticfinalgames.saddlestand.renderers.ArmorStandRenderer;
import com.publicstaticfinalgames.saddlestand.renderers.SaddleRenderer;
import com.publicstaticfinalgames.saddlestand.renderers.SaddleStandRenderer;
import com.publicstaticfinalgames.saddlestand.tileentity.TileEntityArmorStand;
import com.publicstaticfinalgames.saddlestand.tileentity.TileEntitySaddle;
import com.publicstaticfinalgames.saddlestand.tileentity.TileEntitySaddleStand;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	
	SaddleStandRenderer saddleStandRenderer = new SaddleStandRenderer();
	SaddleRenderer saddleRenderer = new SaddleRenderer();
	ArmorStandRenderer armorStandRenderer = new ArmorStandRenderer();
	
	@Override
    public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySaddle.class, saddleRenderer);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySaddleStand.class, saddleStandRenderer);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArmorStand.class, armorStandRenderer);

		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.stand), saddleRenderer);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.saddleStand), saddleStandRenderer);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.armorStand), armorStandRenderer);
	}
}