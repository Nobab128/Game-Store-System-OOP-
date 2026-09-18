package com.mycompany.gamestoresystem;

import java.io.*;

class Game implements Serializable {

    private String title;
    private String genre;
    private double price;

    public Game(String title, String genre, double price) {
        this.title = title;
        this.genre = genre;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Title: " + title + ", Genre: " + genre + ", Price: $" + price;
    }
}
