package com.curriculum.security;

import java.sql.*;

public class NaiveUserService {
    private Connection connection;

    public NaiveUserService(Connection connection) {
        this.connection = connection;
    }

    /**
     * Fetches a user by their ID.
     * Note: This is a naive implementation intended for educational purposes.
     */
    public User getUserById(String userId) throws SQLException {
        // VULNERABILITY: SQL Injection via string concatenation. 
        // A junior developer might do this thinking it's the simplest way to build a query.
        String query = "SELECT id, username, email FROM users WHERE id = '" + userId + "'";
        
        System.out.println("Executing query: " + query);
        
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        
        if (resultSet.next()) {
            return new User(
                resultSet.getString("id"),
                resultSet.getString("username"),
                resultSet.getString("email")
            );
        }
        return null;
    }
}
