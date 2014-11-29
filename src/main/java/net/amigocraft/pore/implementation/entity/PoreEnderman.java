package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.material.MaterialData;

public class PoreEnderman extends PoreMonster implements Enderman {

	private static TypeConverter<org.spongepowered.api.entity.living.monster.Enderman, PoreEnderman> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.living.monster.Enderman, PoreEnderman> getEndermanConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.living.monster.Enderman, PoreEnderman>(){
				@Override
				protected PoreEnderman convert(org.spongepowered.api.entity.living.monster.Enderman handle) {
					return new PoreEnderman(handle);
				}
			};
		}
		return converter;
	}

	protected PoreEnderman(org.spongepowered.api.entity.living.monster.Enderman handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.living.monster.Enderman getHandle() {
		return (org.spongepowered.api.entity.living.monster.Enderman)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreEnderman of(org.spongepowered.api.entity.living.monster.Enderman handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.ENDERMAN;
	}

	@Override
	public MaterialData getCarriedMaterial() {
		throw new NotImplementedException();
	}

	@Override
	public void setCarriedMaterial(MaterialData material) {
		throw new NotImplementedException();
	}
}
