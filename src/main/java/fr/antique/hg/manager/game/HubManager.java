package fr.antique.hg.manager.game;

import java.util.ArrayList;
import java.util.List;

import fr.antique.hg.HG;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class HubManager {

    private final HG api;
    private int slot;

    private List<Location> locationSpawn;

    public HubManager(HG api) {
        this.api = api;
        this.slot = 2;
        this.locationSpawn = new ArrayList<>();
    }


    public HG getApi() {
        return api;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public List<Location> getLocationSpawn(Player player) {
        return locationSpawn;
    }


    Location hub = new Location(Bukkit.getWorld("world"), 0.50, 100, 0, 50, 0);


}
