package org.glydar.api;

import org.glydar.api.model.entity.Entity;

public interface Server {
	
	//TODO: Better place to put these!!
	public void unregisterEntity(int entityId);
	
	public void registerEntity(Entity e);
}
