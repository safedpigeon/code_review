package com.curriculum.singleton;

public class UserService {
    public void createUser(String username) {
        System.out.println("Creating user: " + username);
        // Tight coupling to Singleton
        DatabaseManager db = DatabaseManager.getInstance();
        db.executeQuery("INSERT INTO users (name) VALUES ('" + username + "')");
    }
}
