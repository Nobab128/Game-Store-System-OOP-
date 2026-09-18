package com.mycompany.gamestoresystem;

import java.io.*;

class AuthManager {

    private static final String FILE_NAME = "users.txt";

    public static boolean register(String username, String password, boolean isAdmin) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(username + "," + password + "," + isAdmin);
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Error registering user.");
            return false;
        }
    }

    public static String login(String username, String password) {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No users registered yet.");
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[0].equals(username) && parts[1].equals(password)) {
                    return parts[2];
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users file.");
        }
        return null;
    }
}
