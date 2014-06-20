package com.publicstaticfinalgames.saddlestand;

import com.publicstaticfinalgames.saddlestand.blocks.ArmorStandBlock;
import com.publicstaticfinalgames.saddlestand.blocks.SaddleBlock;
import com.publicstaticfinalgames.saddlestand.blocks.SaddleStandBlock;
import com.publicstaticfinalgames.saddlestand.renderers.SaddleStandRenderer;
import com.publicstaticfinalgames.saddlestand.tileentity.TileEntityArmorStand;
import com.publicstaticfinalgames.saddlestand.tileentity.TileEntitySaddle;
import com.publicstaticfinalgames.saddlestand.tileentity.TileEntitySaddleStand;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
	public static final String NAME = "Saddle Stand Mod";
	public static final String MODID = "saddlestandmod";
	public static final String VERSION = "1.0";

	@SidedProxy(clientSide = "com.publicstaticfinalgames.saddlestand.ClientProxy", serverSide = "com.publicstaticfinalgames.saddlestand.CommonProxy")
	public static CommonProxy proxy;

	public static Block stand;
	public static Block saddleStand;
	public static Block armorStand;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		stand = new SaddleBlock(Material.wood).setBlockName("saddle").setCreativeTab(CreativeTabs.tabDecorations).setHardness(0.5f).setBlockTextureName("log_oak_top");
		saddleStand = new SaddleStandBlock(Material.wood).setBlockName("saddleStand").setCreativeTab(CreativeTabs.tabDecorations).setHardness(0.5f).setBlockTextureName("log_oak_top");
		armorStand = new ArmorStandBlock(Material.wood).setBlockName("horseArmorStand").setCreativeTab(CreativeTabs.tabDecorations).setHardness(0.5f).setBlockTextureName("thing");
		GameRegistry.registerBlock(stand, "stand");
		GameRegistry.registerBlock(saddleStand, "saddleStand");
		GameRegistry.registerBlock(armorStand, "horseArmorStand");

		GameRegistry.registerTileEntity(TileEntitySaddle.class, "saddle");
		GameRegistry.registerTileEntity(TileEntitySaddleStand.class, "stand");
		GameRegistry.registerTileEntity(TileEntityArmorStand.class, "horseArmorStand");

		GameRegistry.addRecipe(new ItemStack(saddleStand, 1), new Object[] { " W ", "WSW", "W W", 'W', Blocks.planks, 'S', Items.stick });

		proxy.registerRenderers();
	}
}
