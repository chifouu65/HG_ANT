package fr.antique.hg.manager.players;

import java.util.Random;

public class PlayerManager {

    public static int returnChance(int start) {
        if(start <= 0)
            return 0;
        return new Random().nextInt(start * 2) - start;
        
    }

}
