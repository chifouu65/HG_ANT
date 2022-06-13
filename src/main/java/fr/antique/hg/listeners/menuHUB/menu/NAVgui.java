package fr.antique.hg.listeners.menuHUB.menu;

import fr.antique.hg.commons.utils.itembuilder.ItemBuilder;
import fr.antique.hg.listeners.menuHUB.minigames.InvItems;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class NAVgui implements InventoryProvider {

    public static final SmartInventory INVENTORY = SmartInventory.builder()
            .id("KitsSelector")
            .title("§c§l•MAIN menu")
            .provider(new NAVgui())
            .size(5, 9)
            .closeable(true)
            .build();

    @Override
    public void init(Player player, InventoryContents inventoryContents) {
        ItemStack placeHolder = new ItemBuilder(Material.STAINED_GLASS_PANE)
                .setName(" ")
                    .addLoreLine(" ")
                        .toItemStack();

        ItemStack MiniGames = InvItems.MINI_GAMES.getItemStack();

        inventoryContents.set(2,3,ClickableItem.empty(MiniGames));

        inventoryContents.fillBorders(ClickableItem.empty(placeHolder));
    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {
    }
}