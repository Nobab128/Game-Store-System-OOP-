package com.mycompany.gamestoresystem;

import java.util.*;

class GameManager<T extends Game> {

    private List<T> games;

    @SuppressWarnings("unchecked")
    public GameManager() {

        this.games = (List<T>) SaveGameList.load();
    }

    public List<T> getGames() {
        return games;
    }

    public void printAllGames() {
        if (games.isEmpty()) {
            System.out.println("| No games available. |");
            return;
        }
        DisplayUtils.printGameTable(new ArrayList<Game>(games));
    }
}
