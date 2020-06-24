package io.mewsub.randomdrops;

import java.util.List;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Server;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import org.bukkit.inventory.ItemStack;

import io.mewsub.randomdrops.Listeners.BlockBreak;
import io.mewsub.randomdrops.Listeners.EntityExplode;
import io.mewsub.randomdrops.Listeners.EntityDeath;

public class RandomDrops extends JavaPlugin {

    public static Plugin plugin;
    public static Server server;
    public static RandomDrops instance;
    
    public static final Material materials[] = Material.values();
    public static int matLength = materials.length;

    public static byte dropAmount = 3;
    public static long seed;

    @Override
    public void onEnable() {
        this.plugin = ( Plugin ) this;
        this.server = this.getServer();
        this.instance = this;

        this.server.getPluginManager().registerEvents( new BlockBreak(), this );
        this.server.getPluginManager().registerEvents( new EntityExplode(), this );
        this.server.getPluginManager().registerEvents( new EntityDeath(), this );

        this.seed = System.currentTimeMillis();
    }

    @Override
    public void onDisable() {
        RandomDrops.instance = null;
    }

    public void drop( List<ItemStack> items, World world, Location location ) {
        ItemStack item;
        Material material;
        long seed = RandomDrops.seed;
        long x, y, tempX, tempY, buffer;
        int index;
        boolean dropped;
        byte amt;
        for( int i = 0; i < items.size(); ++i ) {
            item = items.get( i );
            seed = seed + item.getType().ordinal();
            x = seed << 1;
            y = seed >> 1;
            for( amt = 0; amt < RandomDrops.dropAmount; ++amt ) {
                dropped = false;
                while( !dropped ) {
                    try {
                        tempX = y;
                        x ^= x << 23;
                        tempY = x ^ y ^ ( x >> 17 ) ^ ( y >> 26 );
                        buffer = tempY + y;
                        x = tempX;
                        y = tempY;
                        index = ( int ) ( buffer  % ( ( long ) matLength ) );
                        if( index < 0 ) {
                            index += matLength;
                        }
                        material = materials[ index ];
                        if( material.isItem() ) {
                            world.dropItemNaturally( location, new ItemStack( material ) );
                            dropped = true;
                        }
                    } catch (IllegalArgumentException illegalargumentexception) {

                    }
                }
            }
        }
    }

}
