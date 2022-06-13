package fr.antique.hg.listeners.menuHUB.infos;

import fr.antique.hg.commons.utils.itembuilder.ItemBuilder;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Kits implements InventoryProvider {

    public static final SmartInventory KIT = SmartInventory.builder()
            .id("kit")
            .title("§c§lKit navigator.")
            .provider(new Kits())
            .size(5, 9)
            .closeable(true)
            .build();

    @Override
    public void init(Player player, InventoryContents inventoryContents) {
        ItemStack placeHolder = new ItemBuilder(Material.STAINED_GLASS_PANE)
                .setName(" ")
                .addLoreLine(" ")
                .toItemStack();

        inventoryContents.fillBorders(ClickableItem.empty(placeHolder));
    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {
    }
}