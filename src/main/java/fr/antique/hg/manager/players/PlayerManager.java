package fr.antique.hg.manager.players;

import org.bukkit.entity.Player;

import java.util.*;

public class PlayerManager {

    public static List<UUID> playersInGame;
    public static Map<String, PlayerManager> gamePlayers = new HashMap<>();

    public void PlayerInGame(String name) {
        gamePlayers.put(name, this);
        playersInGame = new ArrayList<>();
    }

    public static Player player = (Player) playersInGame;

    public static String isOP() {
        if(player.isOp()) {
            return "§e§lSTAFF";
        } else
            return "§rPlayer";
    }

    public static int returnChance(int start) {
        if(start <= 0)
            return 0;
        return new Random().nextInt(start * 2) - start;
        
    }

}
