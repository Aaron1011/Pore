package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

public class PoreFireball extends PoreProjectile implements Fireball {

	private static TypeConverter<org.spongepowered.api.entity.projectile.fireball.Fireball, PoreFireball> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.projectile.fireball.Fireball, PoreFireball> getFireballConverter(){
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.projectile.fireball.Fireball, PoreFireball>(){
				@Override
				protected PoreFireball convert(org.spongepowered.api.entity.projectile.fireball.Fireball handle) {
					return new PoreFireball(handle);
				}
			};
		}
		return converter;
	}

	protected PoreFireball(org.spongepowered.api.entity.projectile.fireball.Fireball handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.projectile.fireball.Fireball getHandle() {
		return (org.spongepowered.api.entity.projectile.fireball.Fireball)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreFireball of(org.spongepowered.api.entity.projectile.fireball.Fireball handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.FIREBALL;
	}

	@Override
	public void setDirection(Vector direction) {
		throw new NotImplementedException();
	}

	@Override
	public Vector getDirection() {
		throw new NotImplementedException();
	}

	@Override
	public void setYield(float yield) {
		throw new NotImplementedException();
	}

	@Override
	public float getYield() {
		throw new NotImplementedException();
	}

	@Override
	public void setIsIncendiary(boolean isIncendiary) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isIncendiary() {
		throw new NotImplementedException();
	}

	@Override
	public LivingEntity _INVALID_getShooter() {
		throw new NotImplementedException();
	}

	@Override
	public ProjectileSource getShooter() {
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_setShooter(LivingEntity shooter) {
		throw new NotImplementedException();
	}

	@Override
	public void setShooter(ProjectileSource source) {
		throw new NotImplementedException();
	}

	@Override
	public boolean doesBounce() {
		throw new NotImplementedException();
	}

	@Override
	public void setBounce(boolean doesBounce) {
		throw new NotImplementedException();
	}
}
