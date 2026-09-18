package com.mycompany.gamestoresystem;

import java.io.*;
import java.util.*;

class User extends Person {

    private List<Game> cart = new ArrayList<>();

    public User(String username) {
        super(username);
    }

    public void buyGame(List<Game> games, Scanner in) throws GameNotFoundException {
        if (games.isEmpty()) {
            throw new GameNotFoundException("No games available for purchase.");
        }

        DisplayUtils.printGameTable(games);
        System.out.print("Enter game number to add to cart: ");
        int choice = in.nextInt();
        in.nextLine();

        if (choice < 1 || choice > games.size()) {
            throw new GameNotFoundException("Invalid game selection. Please choose between 1 and " + games.size());
        }

        cart.add(games.get(choice - 1));
        System.out.println("Game added to cart.");
    }

    public void viewCart() {
        DisplayUtils.printCart(cart);
    }

    public void showMenu() {
        System.out.println("User Menu - Buy Games / View Cart");
    }

    public void checkout(Scanner in) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Nothing to buy.");
            return;
        }

        double total = 0;
        StringBuilder receipt = new StringBuilder();
        receipt.append("\n=== Receipt ===\n");
        receipt.append("User: ").append(username).append("\n");
        receipt.append("Date: ").append(new Date()).append("\n");

        receipt.append("\nItems Purchased:\n");
        receipt.append(String.format("%-25s %-15s %-10s\n", "Title", "Genre", "Price ($)"));
        receipt.append("----------------------------------------------------------\n");

        for (Game game : cart) {
            receipt.append(String.format("%-25s %-15s $%-9.2f\n",
                    game.getTitle(), game.getGenre(), game.getPrice()));
            total += game.getPrice();
        }

        receipt.append("----------------------------------------------------------\n");
        receipt.append(String.format("Total: $%.2f\n", total));

        System.out.print("Enter payment method (Card/Bank/Mobile Transaction): ");
        String payment = in.nextLine();
        receipt.append("Payment Method: ").append(payment).append("\n");
        receipt.append("Status: Payment Successful\n");

        System.out.println(receipt);

        saveReceipt(receipt.toString());

        cart.clear();
        System.out.println("Thank you for your purchase! Receipt saved.");
    }

    private void saveReceipt(String content) {
        String filename = "receipt_" + username + "_" + System.currentTimeMillis() + ".txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(content);
        } catch (IOException e) {
            System.out.println("Failed to save receipt: " + e.getMessage());
        }
    }
}
