package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.DyeColor;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.animal.Sheep;

public class PoreSheep extends PoreAnimals implements org.bukkit.entity.Sheep {

	private static TypeConverter<Sheep, PoreSheep> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Sheep, PoreSheep> getSheepConverter() {
		if (converter == null) {
			converter = new TypeConverter<Sheep, PoreSheep>(){
				@Override
				protected PoreSheep convert(Sheep handle) {
					return new PoreSheep(handle);
				}
			};
		}
		return converter;
	}

	protected PoreSheep(Sheep handle) {
		super(handle);
	}

	@Override
	public Sheep getHandle() {
		return (Sheep)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreSheep of(Sheep handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.SHEEP;
	}

	@Override
	public boolean isSheared() {
		throw new NotImplementedException();
	}

	@Override
	public void setSheared(boolean flag) {
		throw new NotImplementedException();
	}

	@Override
	public DyeColor getColor() {
		throw new NotImplementedException();
	}

	@Override
	public void setColor(DyeColor color) {
		throw new NotImplementedException();
	}
}
