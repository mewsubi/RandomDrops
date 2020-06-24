package io.mewsub.randomdrops.Listeners;

import java.util.List;
import java.util.ArrayList;

import org.bukkit.event.entity.EntityDeathEvent;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import org.bukkit.inventory.ItemStack;

import io.mewsub.randomdrops.RandomDrops;

public class EntityDeath implements Listener {
    
    @EventHandler
    public void onEntityDeath( EntityDeathEvent evt ) {
        Entity entity = evt.getEntity();
        if( !( entity instanceof Player ) ) {
	        RandomDrops.instance.drop( new ArrayList<ItemStack>( evt.getDrops() ), entity.getWorld(), entity.getLocation() );
	        evt.getDrops().clear();
	    }
    }

}