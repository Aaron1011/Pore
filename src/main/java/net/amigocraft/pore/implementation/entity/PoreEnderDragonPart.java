package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EnderDragonPart;
import org.bukkit.entity.Entity;

public class PoreEnderDragonPart extends PoreComplexEntityPart implements EnderDragonPart {

	private static TypeConverter<org.spongepowered.api.entity.living.complex.EnderDragonPart, PoreEnderDragonPart> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.living.complex.EnderDragonPart, PoreEnderDragonPart>
	getEnderDragonPartConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.living.complex.EnderDragonPart, PoreEnderDragonPart>(){
				@Override
				protected PoreEnderDragonPart convert(org.spongepowered.api.entity.living.complex.EnderDragonPart handle) {
					return new PoreEnderDragonPart(handle);
				}
			};
		}
		return converter;
	}

	protected PoreEnderDragonPart(org.spongepowered.api.entity.living.complex.EnderDragonPart handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.living.complex.EnderDragonPart getHandle() {
		return (org.spongepowered.api.entity.living.complex.EnderDragonPart)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreEnderDragonPart of(org.spongepowered.api.entity.living.complex.EnderDragonPart handle) {
		return converter.apply(handle);
	}

	@Override
	public void damage(double amount) {
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_damage(int amount) {
		throw new NotImplementedException();
	}

	@Override
	public void damage(double amount, Entity source) {
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_damage(int amount, Entity source) {
		throw new NotImplementedException();
	}

	@Override
	public double getHealth() {
		throw new NotImplementedException();
	}

	@Override
	public int _INVALID_getHealth() {
		return (int)getHealth();
	}

	@Override
	public void setHealth(double health) {
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_setHealth(int health) {
		this.setHealth(health);
	}

	@Override
	public double getMaxHealth() {
		throw new NotImplementedException();
	}

	@Override
	public int _INVALID_getMaxHealth() {
		return (int)this.getMaxHealth();
	}

	@Override
	public void setMaxHealth(double health) {
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_setMaxHealth(int health) {
		this.setMaxHealth(health);
	}

	@Override
	public void resetMaxHealth() {
		throw new NotImplementedException();
	}
}
