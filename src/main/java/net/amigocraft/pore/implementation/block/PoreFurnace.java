package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreFurnace extends PoreBlockState implements Furnace {
	public PoreFurnace(org.spongepowered.api.block.Block spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public short getBurnTime() {
		throw new NotImplementedException();
	}

	@Override
	public void setBurnTime(short burnTime) {
		throw new NotImplementedException();
	}

	@Override
	public short getCookTime() {
		throw new NotImplementedException();
	}

	@Override
	public void setCookTime(short cookTime) {
		throw new NotImplementedException();
	}

	@Override
	public FurnaceInventory getInventory() {
		throw new NotImplementedException();
	}
}
