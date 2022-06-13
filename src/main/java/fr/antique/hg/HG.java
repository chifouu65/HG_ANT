package fr.antique.hg;

import fr.antique.hg.manager.command.CommandsManager;
import fr.antique.hg.manager.event.EventManager;
import fr.antique.hg.manager.game.HubManager;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
@Setter
public final class HG extends JavaPlugin {

    public static HG INSTANCE;

    private HubManager gameManager;
    private EventManager eventManager;

    @Override
    public void onEnable() {
        INSTANCE = this;

        CommandsManager.setupCommandsSystem(this);

        this.gameManager = new HubManager(this);
        this.eventManager = new EventManager(this);

        onEnableServer();
    }

    public void onEnableServer() {
        Bukkit.getWorlds().forEach(world -> {
            world.setGameRuleValue("commandBlockOutput", "false");
            world.setGameRuleValue("announceAdvancements", "false");
            world.setGameRuleValue("doMobSpawning", "false");
            world.setGameRuleValue("doDaylightCycle", "false");
            world.setGameRuleValue("doWeatherCycle", "false");
            world.setGameRuleValue("randomTickSpeed", "false");
        });
    }


    @Override
    public void onDisable() {
        //
    }
}
