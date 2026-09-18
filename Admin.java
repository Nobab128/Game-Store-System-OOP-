package com.mycompany.gamestoresystem;

import java.util.*;

class Admin extends Person {

    private List<Game> gameList;

    public Admin(String username, List<Game> gameList) {
        super(username);
        this.gameList = gameList;
    }

    public void addGame(Scanner in) {
        System.out.print("Enter title: ");
        String title = in.nextLine();
        System.out.print("Enter genre: ");
        String genre = in.nextLine();
        System.out.print("Enter price: ");
        double price = in.nextDouble();
        in.nextLine();
        gameList.add(new Game(title, genre, price));
        System.out.println("Game added.");
    }

    public void removeGame(Scanner in) throws GameNotFoundException {
        if (gameList.isEmpty()) {
            throw new GameNotFoundException("No games available to remove.");
        }

        DisplayUtils.printGameTable(gameList);
        System.out.print("Enter title to remove: ");
        String title = in.nextLine();

        boolean removed = gameList.removeIf(game -> game.getTitle().equalsIgnoreCase(title));
        if (!removed) {
            throw new GameNotFoundException("Game '" + title + "' not found in the system.");
        }

        System.out.println("Game removed successfully.");
    }

    public void editGame(Scanner in) {
        if (gameList.isEmpty()) {
            System.out.println("No games available to edit.");
            return;
        }

        DisplayUtils.printGameTable(gameList);
        System.out.print("Enter the number of the game to edit: ");
        int choice = in.nextInt();
        in.nextLine();

        if (choice < 1 || choice > gameList.size()) {
            System.out.println("Invalid game number.");
            return;
        }

        Game game = gameList.get(choice - 1);

        System.out.println("Editing game: " + game.getTitle());

        System.out.print("Enter new title (or press Enter to keep '" + game.getTitle() + "'): ");
        String newTitle = in.nextLine();
        if (!newTitle.trim().isEmpty()) {

            gameList.set(choice - 1, new Game(newTitle, game.getGenre(), game.getPrice()));
        }

        System.out.print("Enter new genre (or press Enter to keep '" + game.getGenre() + "'): ");
        String newGenre = in.nextLine();
        if (!newGenre.trim().isEmpty()) {
            Game oldGame = gameList.get(choice - 1);
            gameList.set(choice - 1, new Game(oldGame.getTitle(), newGenre, oldGame.getPrice()));
        }

        System.out.print("Enter new price (or press Enter to keep $" + game.getPrice() + "): ");
        String priceStr = in.nextLine();
        if (!priceStr.trim().isEmpty()) {
            try {
                double newPrice = Double.parseDouble(priceStr);
                Game oldGame = gameList.get(choice - 1);
                gameList.set(choice - 1, new Game(oldGame.getTitle(), oldGame.getGenre(), newPrice));
            } catch (NumberFormatException e) {
                System.out.println("Invalid price input. Price not changed.");
            }
        }

        System.out.println("Game updated.");
    }

    public void showMenu() {
        System.out.println("Admin Menu - Add/Remove Games");
    }
}
