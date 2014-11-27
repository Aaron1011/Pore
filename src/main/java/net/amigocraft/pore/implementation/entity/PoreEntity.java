package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.Pore;
import net.amigocraft.pore.util.*;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.spongepowered.api.entity.LivingEntity;
import org.spongepowered.api.util.Identifiable;

import java.util.List;
import java.util.UUID;

public class PoreEntity extends PoreWrapper<org.spongepowered.api.entity.Entity> implements Entity { //TODO: determine if metadata methods should be implemented manually
	private static Converter<org.spongepowered.api.entity.Entity, PoreEntity> converter;

	public static Converter<org.spongepowered.api.entity.Entity, PoreEntity> getConverter() {
		if (converter == null) {
			converter = new ParentConverter<org.spongepowered.api.entity.Entity, PoreEntity>(
					LivingEntity.class, PoreLivingEntity.getLivingEntityConverter()
			) {
				@Override
				protected PoreEntity convert(org.spongepowered.api.entity.Entity handle) {
					return new PoreEntity(handle);
				}
			};
		}

		return converter;
	}

	protected PoreEntity(org.spongepowered.api.entity.Entity handle) {
		super(handle);
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreEntity of(org.spongepowered.api.entity.Entity handle) {
		return getConverter().apply(handle);
	}

	@Override
	public Location getLocation() {
		return LocationFactory.fromVector3d(null, getHandle().getPosition()); //TODO: fix first parameter when possible
	}

	@Override
	public Location getLocation(Location loc) {
		loc.setWorld(null); //TODO: correct parameter when possible
		loc.setX(getHandle().getPosition().getX());
		loc.setY(getHandle().getPosition().getX());
		loc.setZ(getHandle().getPosition().getX());
		loc.setPitch(getHandle().getVectorRotation().getX());
		loc.setYaw(getHandle().getVectorRotation().getY());
		return loc;
	}

	@Override
	public void setVelocity(Vector velocity) {
		/*if (getHandle() instanceof Movable){
			((Movable)getHandle()).setVelocity(Vector3fFactory.fromBukkitVector(velocity));
		}
		else {*/
			throw new UnsupportedOperationException("setVelocity called on an entity which is not movable"); // TODO: figure out the proper exception to throw
		//}
	}

	@Override
	public Vector getVelocity() {
		/*if (getHandle() instanceof Movable){
			return BukkitVectorFactory.fromVector3f(((Movable)getHandle()).getVelocity());
		}
		else {*/
			throw new UnsupportedOperationException("getVelocity called on an entity which is not movable"); // TODO: figure out the proper exception to throw
		//}
	}

	@Override
	public boolean isOnGround() {
		throw new NotImplementedException();
	}

	@Override
	public World getWorld() {
		throw new NotImplementedException();
	}

	@Override
	public boolean teleport(Location location) {
		return this.teleport(location, PlayerTeleportEvent.TeleportCause.PLUGIN);
	}

	@Override
	public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
		if (this.getPassenger() != null || this.isDead()){
			return false;
		}
		this.eject();
		getHandle().setPosition(Vector3dFactory.fromLocation(location));
		// Craftbukkit apparently does not throw an event when this method is called
		return true;
	}

	@Override
	public boolean teleport(Entity destination) {
		return this.teleport(destination.getLocation());
	}

	@Override
	public boolean teleport(Entity destination, PlayerTeleportEvent.TeleportCause cause) {
		return this.teleport(destination.getLocation(), cause);
	}

	@Override
	public List<Entity> getNearbyEntities(double x, double y, double z) {
		throw new NotImplementedException();
	}

	@Override
	public int getEntityId() { // note to self - this is the ID of the entity in the world, and unrelated to its UUID
		throw new NotImplementedException();
	}

	@Override
	public int getFireTicks() {
		throw new NotImplementedException();
	}

	@Override
	public int getMaxFireTicks() {
		throw new NotImplementedException();
	}

	@Override
	public void setFireTicks(int ticks) {
		throw new NotImplementedException();
	}

	@Override
	public void remove() {
		getHandle().remove();
	}

	@Override
	public boolean isDead() {
		throw new NotImplementedException(); //TODO: determine how to implement this for non-living entities
	}

	@Override
	public boolean isValid() {
		throw new NotImplementedException();
	}

	@Override
	public Server getServer() {
		return Bukkit.getServer();
	}

	@Override
	public Entity getPassenger() {
		return PoreEntity.of(getHandle().getRider().get());
	}

	@Override
	public boolean setPassenger(Entity passenger) {
		if (getHandle().getRider() == null) {
			((PoreEntity) passenger).getHandle().mount(getHandle());
			return true;
		}
		else if (passenger == null){
			getHandle().eject();
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return getHandle().getRider() == null;
	}

	@Override
	public boolean eject() {
		if (getHandle().getRider() != null) {
			getHandle().eject();
			return true;
		}
		return false;
	}

	@Override
	public float getFallDistance() {
		throw new NotImplementedException();
	}

	@Override
	public void setFallDistance(float distance) {
		throw new NotImplementedException();
	}

	@Override
	public void setLastDamageCause(EntityDamageEvent event) {
		throw new NotImplementedException(); // Sponge implementation planned for 1.1
	}

	@Override
	public EntityDamageEvent getLastDamageCause() {
		throw new NotImplementedException(); // Sponge implementation planned for 1.1
	}

	@Override
	public UUID getUniqueId() {
		return ((Identifiable)getHandle()).getUniqueId();
	}

	@Override
	public int getTicksLived() {
		throw new NotImplementedException();
	}

	@Override
	public void setTicksLived(int value) {
		throw new NotImplementedException();
	}

	@Override
	public void playEffect(EntityEffect type) {
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType() {
		return EntityType.UNKNOWN; // this will almost always be overridden
	}

	@Override
	public boolean isInsideVehicle() {
		return getHandle().getRiding() != null;
	}

	@Override
	public boolean leaveVehicle() {
		if (getHandle().getRiding() != null) {
			getHandle().dismount();
			return true;
		}
		return false;
	}

	@Override
	public Entity getVehicle() {
		return PoreEntity.of(getHandle().getRiding().get());
	}

	@Override
	public void setMetadata(String s, MetadataValue metadataValue) {
		throw new NotImplementedException();
	}

	@Override
	public List<MetadataValue> getMetadata(String s) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasMetadata(String s) {
		throw new NotImplementedException();
	}

	@Override
	public void removeMetadata(String s, Plugin plugin) {
		throw new NotImplementedException();
	}
}
