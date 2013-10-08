package org.glydar.core.model.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.glydar.api.model.entity.Entity;
import org.glydar.api.model.entity.Player;
import org.glydar.api.model.world.World;
import org.glydar.core.model.entity.CoreEntity;

import com.google.common.collect.Lists;

public class CoreWorld implements World {

    private final String name;
    private final int    seed;
    private boolean      pvpAllowed;
    private HashMap<Integer, Entity> entities;

    public CoreWorld(String name, int seed) {
        this.name = name;
        this.seed = seed;
        this.pvpAllowed = false;
        entities = new HashMap<>();
    }
    
    public List<Entity> getEntities(){
    	return Lists.newArrayList(entities.values());
    }
    
    public List<Player> getPlayers() {
    	List<Player> players = new ArrayList<Player>();
    	for (Entity e : entities.values()){
    		if (e instanceof Player){
    			players.add((Player) e);
    		}
    	}
    	return players;
    }
    
    public Entity getEntityById(int id) {
    	return entities.get(id);
    }
    
    public void unregisterEntity(int id){
    	entities.remove(id);
    }
    
	public void registerEntity(Entity e) {
		entities.put(((CoreEntity) e).getId(), e);
	}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSeed() {
        return seed;
    }

    @Override
    public boolean isPvpAllowed() {
        return pvpAllowed;
    }

    @Override
    public void setPvpAllowed(boolean pvpAllowed) {
        this.pvpAllowed = pvpAllowed;
        // TODO: Update player accordingly
    }
    
    public void tick() {
    	
    }
    
}
