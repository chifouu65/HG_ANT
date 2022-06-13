package fr.antique.hg.runnable;

import fr.antique.hg.HG;
import fr.antique.hg.manager.game.GameStatus;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class LobbyRunnable extends BukkitRunnable {

    HG main;

    public LobbyRunnable() {
        this.main = main;
    }

    public static int timer = 11;
    public static boolean start = false;

    @Override
    public void run() {
        timer--;

        if (!start) {
            this.cancel();
            return;
        }

        if (!(GameStatus.isState(GameStatus.LOBBY))) {
            timer = 11;
            start = false;
            this.cancel();
            return;
        }

        if (Bukkit.getOnlinePlayers().size() < 2) { // si le nombre de joueurs est en dessou de 2 joueurs =>
            Bukkit.broadcastMessage("§a il n'y a pas assez de joueurs pour débuter la parties");
            timer = 11; // set le timer au timer de base
            start = false;
            setLevel();
            this.cancel();
            return;
        }

        if (Bukkit.getOnlinePlayers().size() == 4) { // si le nombre de joueur est égal a 4 alors  =>
            if (timer > 5) { // si le timer est au dessu de "5" ça set a 5sec =>
                timer = 5; //set a 5 sec
                setLevel(); // set timer in lvl bar
                return;
            }
        }

        if (Bukkit.getOnlinePlayers().size() >= 5) { // si le nombre de joueur est = ou + de 5 joueurs alors on avance le timer =>
            if (timer >= 11) {
                timer = 2;
                setLevel();
                return;
            }
        }

        if (timer == 0) {
            this.cancel();
        }

        timer--;
        setLevel();

        if ((timer == 120) || (timer == 90) || (timer == 60) || (timer == 30) || (timer == 15) || (timer == 10) || (timer == 5) || (timer == 4) || (timer == 3) || (timer == 2) || (timer == 1)) {
            Bukkit.broadcastMessage("start in " + getSecond(timer));
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.playSound(players.getLocation(), Sound.ORB_PICKUP, 1f, 1f);
            }
        }
    }

    public void setLevel() {
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.setLevel(timer);
        }
    }

    private String getSecond(int time) {
        if (time == 1) return "seconde.";
        return "secondes.";
    }
}