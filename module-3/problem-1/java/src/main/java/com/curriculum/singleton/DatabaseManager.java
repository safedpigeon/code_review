package com.curriculum.singleton;

public class DatabaseManager implements Database {
    private String connectionString;

    public DatabaseManager() {
        // In a real scenario, this would connect to a DB
        this.connectionString = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("Connecting to database...");
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing query: " + query + " using connection " + connectionString);
    }
}
