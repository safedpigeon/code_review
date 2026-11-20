package com.curriculum.singleton;

public class DatabaseManager {
    private static DatabaseManager instance;
    private String connectionString;

    private DatabaseManager() {
        // In a real scenario, this would connect to a DB
        this.connectionString = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("Connecting to database...");
    }

    public static synchronized DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public void executeQuery(String query) {
        System.out.println("Executing query: " + query + " using connection " + connectionString);
    }
}
