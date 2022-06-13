package fr.antique.hg.listeners.menuHUB;

import fr.antique.hg.HG;
import fr.antique.hg.listeners.menuHUB.menu.HubItems;
import fr.antique.hg.listeners.menuHUB.menu.NAVgui;
import fr.antique.hg.listeners.menuHUB.infos.InvItems;
import fr.antique.hg.listeners.menuHUB.infos.Kits;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemInteract implements Listener {

    private HG main;

    public ItemInteract(HG main) {
        this.main = main;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (player.getItemInHand() == null) return;

        /* event quand le joueur click sur l'item de navigation qui lui open l'inv navigation sur le server*/
        if (player.getItemInHand().hasItemMeta()
                && player.getItemInHand().equals(HubItems.NAVIGATOR.getItemStack())) {
            NAVgui.INVENTORY.open(player);
        }
    }

    @EventHandler
    /* event quand le joueur click sur l'item de navigation qui lui open l'inv de mini jeux */
    public void onInteractMinigames(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getCurrentItem() == null) return;

        if (e.getCurrentItem().equals(InvItems.KITS.getItemStack())) {
            Kits.KIT.open(player);
            player.sendMessage("§e INV KIT OPEN");
        }
    }

}
