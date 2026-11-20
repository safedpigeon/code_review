package com.curriculum.singleton;

public class Main {
    public static void main(String[] args) {
        // Manual Dependency Injection
        Database database = new DatabaseManager();
        UserService userService = new UserService(database);
        
        userService.createUser("JohnDoe");
        userService.createUser("JaneDoe");
    }
}
