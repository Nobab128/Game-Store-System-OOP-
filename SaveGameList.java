package com.mycompany.gamestoresystem;

import java.io.*;
import java.util.*;

class SaveGameList {

    public static void save(List<Game> games) {
        Runnable saveTask = () -> {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("games.dat"))) {
                out.writeObject(games);
                System.out.println("Game list saved.");
            } catch (IOException e) {
                System.out.println("Error saving games: " + e.getMessage());
            }
        };
        new Thread(saveTask).start();
    }

    public static List<Game> load() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("games.dat"))) {
            return (List<Game>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
