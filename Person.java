package com.mycompany.gamestoresystem;

abstract class Person {

    protected String username;

    public Person(String username) {
        this.username = username;
    }

    public abstract void showMenu();
}
