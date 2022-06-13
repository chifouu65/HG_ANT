package fr.antique.hg.listeners.menuHUB.menu;

import fr.antique.hg.commons.utils.itembuilder.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum HubItems {

    NAVIGATOR(new ItemBuilder(Material.BOOK, 1)
            .setName( "§e§l•MAIN")
            .addLoreLine("§f")
            .toItemStack()),;

    private ItemStack itemStack;

    HubItems(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}