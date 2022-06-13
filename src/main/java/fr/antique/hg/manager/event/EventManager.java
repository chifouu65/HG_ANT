package fr.antique.hg.manager.event;

import fr.antique.hg.HG;
import fr.antique.hg.listeners.hub.LobbyListeners;
import fr.antique.hg.listeners.menuHUB.ItemInteract;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public class EventManager {

    private final HG api;
    private final PluginManager pluginManager;

    public EventManager(HG api) {
        this.api = api;
        this.pluginManager = Bukkit.getPluginManager();
        registerEvents();
    }

    private void registerEvents() {
        addNewEvenListener(new LobbyListeners(api));
        addNewEvenListener(new ItemInteract(api));
    }

    public void addNewEvenListener(Listener listener) {
        pluginManager.registerEvents(listener, api);
    }


}
