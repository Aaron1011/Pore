package net.amigocraft.pore.implementation.entity.minecart;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.CommandMinecart;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import java.util.Set;

public class PoreCommandMinecart extends PoreMinecart implements CommandMinecart {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreCommandMinecart(org.spongepowered.api.entity.living.Living handle){
		super(handle);
	}

	public static PoreCommandMinecart of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.MINECART_COMMAND;
	}

	@Override
	public String getCommand() {
		throw new NotImplementedException();
	}

	@Override
	public void setCommand(String command) {
		throw new NotImplementedException();
	}

	@Override
	public void setName(String name) {
		throw new NotImplementedException();
	}

	@Override
	public void sendMessage(String message) {
		throw new NotImplementedException();
	}

	@Override
	public void sendMessage(String[] messages) {
		throw new NotImplementedException();
	}

	@Override
	public String getName() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isPermissionSet(String name) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isPermissionSet(Permission perm) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasPermission(String name) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasPermission(Permission perm) {
		throw new NotImplementedException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
		throw new NotImplementedException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		throw new NotImplementedException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
		throw new NotImplementedException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
		throw new NotImplementedException();
	}

	@Override
	public void removeAttachment(PermissionAttachment attachment) {
		throw new NotImplementedException();
	}

	@Override
	public void recalculatePermissions() {
		throw new NotImplementedException();
	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isOp() {
		throw new NotImplementedException();
	}

	@Override
	public void setOp(boolean value) {
		throw new NotImplementedException();
	}


}
