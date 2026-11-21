package com.curriculum.security;

import java.sql.*;

public class NaiveUserServiceTest {
    public static void main(String[] args) {
        try {
            // Setup H2 in-memory database
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
            Statement setupStatement = conn.createStatement();
            setupStatement.execute("CREATE TABLE users (id VARCHAR(255), username VARCHAR(255), email VARCHAR(255))");
            setupStatement.execute("INSERT INTO users VALUES ('1', 'alice', 'alice@example.com')");
            setupStatement.execute("INSERT INTO users VALUES ('2', 'bob', 'bob@example.com')");

            NaiveUserService service = new NaiveUserService(conn);

            // Test basic functionality
            User user = service.getUserById("1");
            System.out.println("Expected: User{id='1', username='alice', email='alice@example.com'}, Got: " + user);

            // Demonstrate vulnerability (SQL Injection)
            String maliciousId = "' OR '1'='1";
            User userVuln = service.getUserById(maliciousId);
            System.out.println("Malicious input: " + maliciousId + ", Got: " + userVuln);
            
            if (userVuln != null) {
                System.out.println("Functional tests passed (including vulnerability demonstration)!");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
