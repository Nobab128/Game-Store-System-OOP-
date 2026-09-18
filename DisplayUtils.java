package com.mycompany.gamestoresystem;

import java.util.*;

public class DisplayUtils {

    public static void printGameTable(List<Game> games) {
        System.out.println("==============================================================");
        System.out.printf("| %-3s | %-20s | %-15s | %-8s |\n", "No", "Title", "Genre", "Price");
        System.out.println("--------------------------------------------------------------");
        int index = 1;
        for (Game g : games) {
            System.out.printf("| %-3d | %-20s | %-15s | $%-7.2f |\n", index++, g.getTitle(), g.getGenre(), g.getPrice());
        }
        System.out.println("==============================================================");
    }

    public static void printCart(List<Game> cart) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        double total = 0;
        System.out.println("=========================== Your Cart ==========================");
        System.out.printf("| %-3s | %-20s | %-15s | %-8s |\n", "No", "Title", "Genre", "Price");
        System.out.println("--------------------------------------------------------------");
        int index = 1;
        for (Game g : cart) {
            System.out.printf("| %-3d | %-20s | %-15s | $%-7.2f |\n", index++, g.getTitle(), g.getGenre(), g.getPrice());
            total += g.getPrice();
        }
        System.out.println("--------------------------------------------------------------");
        System.out.printf("| %-43s | $%-7.2f |\n", "Total", total);
        System.out.println("==============================================================");
    }
}
