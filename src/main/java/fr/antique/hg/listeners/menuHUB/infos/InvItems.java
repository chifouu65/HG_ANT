package fr.antique.hg.listeners.menuHUB.infos;

import fr.antique.hg.commons.utils.itembuilder.ItemBuilder;
import fr.antique.hg.manager.players.PlayerManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;

public enum InvItems {

    KITS(new ItemBuilder(Material.SKULL_ITEM, 1)
            .setName( "§e§lKits Selector.")
            .addLoreLine("§f  -Clique ici pour choisir ton kit ")
            .toItemStack()),

    PLAYER_INFOS(new ItemBuilder(Material.PAPER, 1)
            .setName( "§e§lInfos")
            .toItemStack()),;

    private ItemStack itemStack;

    InvItems(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}