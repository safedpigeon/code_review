package com.curriculum.singleton;

public class UserService {
    private final Database database;

    public UserService(Database database) {
        this.database = database;
    }

    public void createUser(String username) {
        System.out.println("Creating user: " + username);
        // Using injected dependency
        database.executeQuery("INSERT INTO users (name) VALUES ('" + username + "')");
    }
}
