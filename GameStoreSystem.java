package com.mycompany.gamestoresystem;

import java.util.*;

public class GameStoreSystem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GameManager<Game> manager = new GameManager<>();
        boolean running = true;

        while (running) {
            System.out.println("\n==================================");
            System.out.println("|         GAME STORE MENU        |");
            System.out.println("==================================");
            System.out.println("| 1. Login                       |");
            System.out.println("| 2. Register                    |");
            System.out.println("| 3. Exit                        |");
            System.out.println("==================================");
            System.out.print("Choose: ");

            try {
                int option = in.nextInt();
                in.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("Username: ");
                        String username = in.nextLine();
                        System.out.print("Password: ");
                        String password = in.nextLine();
                        String role = AuthManager.login(username, password);

                        if (role == null) {
                            System.out.println("| Login failed.                 |");
                        } else if (Boolean.parseBoolean(role)) {
                            Admin admin = new Admin(username, manager.getGames());
                            boolean adminRunning = true;
                            while (adminRunning) {
                                System.out.println("\n==================================");
                                System.out.println("|         ADMIN DASHBOARD        |");
                                System.out.println("==================================");
                                System.out.println("| 1. Add Game                    |");
                                System.out.println("| 2. Remove Game                 |");
                                System.out.println("| 3. Edit Game                   |");
                                System.out.println("| 4. View Games                  |");
                                System.out.println("| 5. Save Games                  |");
                                System.out.println("| 6. Logout                      |");
                                System.out.println("==================================");
                                System.out.print("Enter choice: ");
                                int choice = in.nextInt();
                                in.nextLine();

                                switch (choice) {
                                    case 1:
                                        admin.addGame(in);
                                        break;
                                    case 2:
                                        try {
                                            admin.removeGame(in);
                                        } catch (GameNotFoundException e) {
                                            System.out.println("Error: " + e.getMessage());
                                        }
                                        break;
                                    case 3:
                                        admin.editGame(in);
                                        break;
                                    case 4:
                                        manager.printAllGames();
                                        break;
                                    case 5:
                                        SaveGameList.save(manager.getGames());
                                        break;
                                    case 6:
                                        adminRunning = false;
                                        break;
                                    default:
                                        System.out.println("Invalid option.");
                                }
                            }
                        } else {
                            User user = new User(username);
                            boolean userRunning = true;
                            while (userRunning) {
                                System.out.println("\n=================================");
                                System.out.println("|         USER DASHBOARD        |");
                                System.out.println("==================================");
                                System.out.println("| 1. View Games                 |");
                                System.out.println("| 2. Add Game to Cart           |");
                                System.out.println("| 3. View Cart                  |");
                                System.out.println("| 4. Checkout                   |");
                                System.out.println("| 5. Logout                     |");
                                System.out.println("=================================");
                                System.out.print("Enter choice: ");
                                int choice = in.nextInt();
                                in.nextLine();
                                switch (choice) {
                                    case 1:
                                        manager.printAllGames();
                                        break;
                                    case 2:
                                        try {
                                            user.buyGame(manager.getGames(), in);
                                        } catch (GameNotFoundException e) {
                                            System.out.println("Error: " + e.getMessage());
                                        }
                                        break;
                                    case 3:
                                        user.viewCart();
                                        break;
                                    case 4:
                                        user.checkout(in);
                                        break;
                                    case 5:
                                        userRunning = false;
                                        break;
                                    default:
                                        System.out.println("| Invalid option.               |");
                                }
                            }
                        }
                        break;

                    case 2:
                        System.out.print("Choose username: ");
                        String newUser = in.nextLine();
                        System.out.print("Choose password: ");
                        String newPass = in.nextLine();
                        System.out.print("Register as Admin? (true/false): ");
                        boolean isAdmin = Boolean.parseBoolean(in.nextLine());
                        boolean success = AuthManager.register(newUser, newPass, isAdmin);
                        System.out.println(
                                success ? "| Registration successful.      |" : "| Registration failed.          |");
                        break;

                    case 3:
                        running = false;
                        break;

                    default:
                        System.out.println("| Invalid choice.               |");
                }

            } catch (InputMismatchException e) {
                System.out.println("| Invalid input! Please enter numbers only. |");
                in.nextLine();
            } catch (Exception e) {
                System.out.println("| Error: " + e.getMessage());
            }
        }

        in.close();
        System.out.println("==================================");
        System.out.println("|      Exiting Game Store...     |");
        System.out.println("==================================");
    }
}
