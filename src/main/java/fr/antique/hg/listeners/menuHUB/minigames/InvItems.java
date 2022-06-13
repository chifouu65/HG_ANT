package fr.antique.hg.listeners.menuHUB.minigames;

import fr.antique.hg.commons.utils.itembuilder.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum InvItems {

    MINI_GAMES(new ItemBuilder(Material.SKULL_ITEM, 1)
            .setName( "§e§lKits Selector.")
            .addLoreLine("§f  -Clique ici pour choisir ton kit ")
            .toItemStack()),;

    private ItemStack itemStack;

    InvItems(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}