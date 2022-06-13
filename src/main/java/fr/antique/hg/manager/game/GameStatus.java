package fr.antique.hg.manager.game;

public enum GameStatus {

    LOBBY,
    PREGAME,
    GAME,
    END;


    private static GameStatus status;

    public static void setState(GameStatus gameStatus) {
        status = gameStatus;
    }

    public static boolean isState(GameStatus gameStatus) {
        return status == gameStatus;
    }

    public static GameStatus getStatus() {
        return status;
    }

}
