package fr.antique.hg;

import fr.antique.hg.chest.ChestManager;
import fr.antique.hg.manager.command.CommandsManager;
import fr.antique.hg.manager.event.EventManager;
import fr.antique.hg.manager.game.GameManager;
import fr.antique.hg.manager.players.PlayerManager;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public final class HG extends JavaPlugin {

    public static HG INSTANCE;
    public Random random;

    private GameManager gameManager;
    private EventManager eventManager;
    private ChestManager chestManager;

    public static HG getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void onEnable() {
        INSTANCE = this;
        random = new Random();

        saveDefaultConfig();
        chestManager = new ChestManager(getConfig());

        PlayerManager.playersInGame = new ArrayList<>();
        CommandsManager.setupCommandsSystem(this);

        this.gameManager = new GameManager(this);
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
