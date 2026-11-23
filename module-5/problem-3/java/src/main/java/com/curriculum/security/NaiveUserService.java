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
        // FIXED: Using PreparedStatement to prevent SQL Injection.
        String query = "SELECT id, username, email FROM users WHERE id = ?";
        
        System.out.println("Executing query: " + query + " with parameter: " + userId);
        
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, userId);
        ResultSet resultSet = pstmt.executeQuery();
        
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
