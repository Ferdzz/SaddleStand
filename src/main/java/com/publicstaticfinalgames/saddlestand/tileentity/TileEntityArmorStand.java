package com.publicstaticfinalgames.saddlestand.tileentity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityArmorStand extends TileEntity {

	/**
	 * 0=basic 1=diamond 2=gold 3=iron
	 */
	public int armor;

	/**
	 * 0=basic
	 */
	public int direction;

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("armor", armor);
		tag.setInteger("direction", direction);
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		armor = tag.getInteger("armor");
		direction = tag.getInteger("direction");
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

	public boolean onTouched(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		world.markBlockForUpdate(x, y, z);
		if (!world.isRemote) {
			if (((TileEntityArmorStand) world.getTileEntity(x, y, z)).armor != 0) {
				switch (((TileEntityArmorStand) world.getTileEntity(x, y, z)).armor) {
				case 1:
					world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.diamond_horse_armor, 1)));
					break;
				case 2:
					world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.golden_horse_armor, 1)));
					break;
				case 3:
					world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.iron_horse_armor, 1)));
					break;
				}
				((TileEntityArmorStand) world.getTileEntity(x, y, z)).armor = 0;
				return true;
			}

			if (player.inventory.getCurrentItem() != null) {
				if (((TileEntityArmorStand) world.getTileEntity(x, y, z)).armor == 0) {
					if (player.inventory.getCurrentItem().getItem().equals(Items.diamond_horse_armor)) {
						player.inventory.mainInventory[player.inventory.currentItem] = null;
						((TileEntityArmorStand) world.getTileEntity(x, y, z)).armor = 1;
					} else if (player.inventory.getCurrentItem().getItem().equals(Items.golden_horse_armor)) {
						player.inventory.mainInventory[player.inventory.currentItem] = null;
						((TileEntityArmorStand) world.getTileEntity(x, y, z)).armor = 2;
					} else if (player.inventory.getCurrentItem().getItem().equals(Items.iron_horse_armor)) {
						player.inventory.mainInventory[player.inventory.currentItem] = null;
						((TileEntityArmorStand) world.getTileEntity(x, y, z)).armor = 3;
					}
					return true;
				}
			}

			if (player.inventory.getCurrentItem() == null) {
				if (((TileEntityArmorStand) world.getTileEntity(x, y, z)).direction == 0) {
					((TileEntityArmorStand) world.getTileEntity(x, y, z)).direction = 1;
				}
				else if (((TileEntityArmorStand) world.getTileEntity(x, y, z)).direction == 1) {
					((TileEntityArmorStand) world.getTileEntity(x, y, z)).direction = 2;
				}
				else if (((TileEntityArmorStand) world.getTileEntity(x, y, z)).direction == 2) {
					((TileEntityArmorStand) world.getTileEntity(x, y, z)).direction = 3;
				}
				else if (((TileEntityArmorStand) world.getTileEntity(x, y, z)).direction == 3) {
					((TileEntityArmorStand) world.getTileEntity(x, y, z)).direction = 0;
				}
				return true;
			}
		}
		return false;
	}

	public void onDestroyed(World world, int x, int y, int z) {
		switch(((TileEntityArmorStand) world.getTileEntity(x, y, z)).armor) {
		case 0:
			break;
		case 1:
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.diamond_horse_armor, 1)));
			break;
		case 2:
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.golden_horse_armor, 1)));
			break;
		case 3:
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.iron_horse_armor, 1)));
			break;
		}
	}
}
