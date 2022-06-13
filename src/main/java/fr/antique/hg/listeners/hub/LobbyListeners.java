package fr.antique.hg.listeners.hub;

import fr.antique.hg.HG;
import fr.antique.hg.listeners.menuHUB.menu.HubItems;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class LobbyListeners implements Listener {

    private HG main;


    public LobbyListeners(HG main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Location lobby = new Location(Bukkit.getWorld("world"), 0.50, 106, 0.50, 90.4f, 1.6f);
        player.teleport(lobby);
        player.setLevel(0);
        player.setGameMode(GameMode.SURVIVAL);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setSaturation(20);
        //INVENTORY.open(player);
        player.getInventory().setItem(0, HubItems.NAVIGATOR.getItemStack());

    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDamageOverPvp(EntityDamageEvent e) {
        e.setCancelled(true);

    }

    @EventHandler
    public void onBlockPlaceLobby(BlockBreakEvent e) {
        Player player = e.getPlayer();

        if(!player.isOp()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreakBlockLobby(BlockPlaceEvent e) {
        Player player = e.getPlayer();

        if(!player.isOp()) {
            e.setCancelled(true);
        }

    }
    @Deprecated
    @EventHandler
    public void onPickupItem(PlayerPickupItemEvent e) {
        Player player = e.getPlayer();

        if(!player.isOp()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {
        Player player = e.getPlayer();

        if(!player.isOp()) {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void foodLevelChangeModeration(FoodLevelChangeEvent e) {
        Player p = (Player) e.getEntity();
            e.setCancelled(true);
            p.setFoodLevel(25);
            p.setSaturation(20);

    }

}
