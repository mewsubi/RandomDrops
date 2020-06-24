package io.mewsub.randomdrops.Listeners;

import java.util.List;
import java.util.ArrayList;

import org.bukkit.event.block.BlockBreakEvent;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

import org.bukkit.block.Block;

import org.bukkit.inventory.ItemStack;

import io.mewsub.randomdrops.RandomDrops;

public class BlockBreak implements Listener {
    
    @EventHandler
    public void onBlockBreak( BlockBreakEvent evt ) {
        evt.setDropItems( false );

        Block block = evt.getBlock();
        List<ItemStack> items = new ArrayList<ItemStack>( block.getDrops( evt.getPlayer().getInventory().getItemInMainHand() ) );

        RandomDrops.instance.drop( items, block.getWorld(), block.getLocation().clone().add( 0.5D, 0.0D, 0.5D ) );
    }

}