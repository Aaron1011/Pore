package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.BlockFace;
import org.spongepowered.api.entity.hanging.Hanging;

public class PoreHanging extends PoreEntity implements org.bukkit.entity.Hanging {

	private static TypeConverter<Hanging, PoreHanging> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Hanging, PoreHanging> getHangingConverter() {
		if (converter == null) {
			converter = new TypeConverter<Hanging, PoreHanging>(){
				@Override
				protected PoreHanging convert(Hanging handle) {
					return new PoreHanging(handle);
				}
			};
		}
		return converter;
	}

	protected PoreHanging(Hanging handle) {
		super(handle);
	}

	@Override
	public Hanging getHandle() {
		return (Hanging)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreHanging of(Hanging handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public boolean setFacingDirection(BlockFace face, boolean force) {
		throw new NotImplementedException();
	}

	@Override
	public BlockFace getAttachedFace() {
		throw new NotImplementedException();
	}

	@Override
	public void setFacingDirection(BlockFace face) {
		throw new NotImplementedException();
	}

	@Override
	public BlockFace getFacing() {
		throw new NotImplementedException();
	}
}
