package io.mewsub.randomdrops.Listeners;

import java.util.List;
import java.util.ArrayList;

import org.bukkit.event.entity.EntityExplodeEvent;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

import org.bukkit.block.Block;

import org.bukkit.inventory.ItemStack;

import io.mewsub.randomdrops.RandomDrops;

public class EntityExplode implements Listener {
    
    @EventHandler
    public void onEntityExplode( EntityExplodeEvent evt ) {
    	/*List<Block> blocks = evt.blockList();
    	List<ItemStack> items = new ArrayList<ItemStack>();
    	Block block;

    	for( int i = 0; i < ( int )( blocks.size() * evt.getYield() ); ++i ) {
    		block = blocks.get( i );
    		items.addAll( block.getDrops( null ) );
    	}

        RandomDrops.instance.drop( items, evt.getEntity().getWorld(), evt.getLocation() );*/

        evt.setYield( 0 );
    }

}