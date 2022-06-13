package fr.antique.hg.chest;

import fr.antique.hg.HG;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import javax.persistence.Embedded;
import java.util.*;

public class ChestManager implements Listener {

    HG main;

    private final Set<Location> openChests = new HashSet<>();
    private final List<LootItem> lootItems = new ArrayList<>();


    public ChestManager(FileConfiguration config) {
        ConfigurationSection itemSection = config.getConfigurationSection("lootItems");

        if(itemSection == null) {
            Bukkit.getLogger().severe("NO 'lootitems' ! in config.yml");
        }

        for (String key : itemSection.getKeys(false)) {
            ConfigurationSection section = itemSection.getConfigurationSection(key);
            lootItems.add(new LootItem(section));
        }

    }

    @EventHandler
    private void onChestOpen(InventoryOpenEvent event) {

    }

    public void fill(Inventory inv) {

    }

}
