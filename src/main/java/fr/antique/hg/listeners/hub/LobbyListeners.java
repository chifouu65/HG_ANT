package fr.antique.hg.listeners.hub;

import fr.antique.hg.HG;
import fr.antique.hg.listeners.menuHUB.menu.HubItems;
import fr.antique.hg.manager.game.GameStatus;
import fr.antique.hg.manager.players.PlayerManager;
import fr.antique.hg.runnable.LobbyRunnable;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
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

        new PlayerManager().PlayerInGame(player.getName());

        event.setJoinMessage("+1" + player.getName());

        Location lobby = new Location(Bukkit.getWorld("world"), 0.50, 106, 0.50, 90.4f, 1.6f);
        player.teleport(lobby);
        player.getInventory().clear();
        player.setLevel(0);
        player.setGameMode(GameMode.SURVIVAL);
        player.setHealth(2.5);
        player.setFoodLevel(20);
        player.setSaturation(20);
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 10f, 10f);
        player.setMaxHealth(2.5);
        //INVENTORY.open(player);
        player.getInventory().setItem(0, HubItems.NAVIGATOR.getItemStack());

        if(!GameStatus.isState(GameStatus.LOBBY)) {
            player.kickPlayer("the game have already started");
        }

        if((!LobbyRunnable.start)) {
            new LobbyRunnable().runTaskTimer(HG.getINSTANCE(), 0L, 20l);
            LobbyRunnable.start = true;
        }

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

        if (!player.isOp()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreakBlockLobby(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        if (!player.isOp()) {
            e.setCancelled(true);
        }
    }

    @Deprecated
    @EventHandler
    public void onPickupItem(PlayerPickupItemEvent e) {
        Player player = e.getPlayer();

        if (!player.isOp()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        if (!player.isOp()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void foodLevelChangeModeration(FoodLevelChangeEvent e) {
        Player p = (Player) e.getEntity();
        e.setCancelled(true);
        p.setFoodLevel(20);
        p.setSaturation(20);
    }

}
