package com.mycompany.gamestoresystem;

import java.util.*;

class Cart {

    private List<Game> cartItems = new ArrayList<>();

    public void addToCart(Game game) {
        cartItems.add(game);
        System.out.println("Added to cart: " + game.getTitle());
    }

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("Your Cart:");
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.println((i + 1) + ". " + cartItems.get(i));
        }
    }

    public void checkout() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Purchasing games...");
            for (Game g : cartItems) {
                System.out.println("Purchased: " + g.getTitle());
            }
            cartItems.clear();
            System.out.println("Checkout complete.");
        }
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}
