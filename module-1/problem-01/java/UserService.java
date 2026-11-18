package module1.problem01;

import java.util.*;
import java.io.*;

public class UserService {
    
    // The "God Class" - handles everything related to users
    public void registerUser(String username, String email, String password) {
        System.out.println("Starting user registration for: " + username);

        // 1. Validation Logic
        if (username == null || username.length() < 3) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password too short");
        }

        // 2. Database Logic (Persistence)
        System.out.println("Connecting to Database...");
        System.out.println("INSERT INTO users (username, email, password) VALUES ('" + username + "', '" + email + "', '" + password + "');");
        System.out.println("User saved to database successfully.");

        // 3. Email Logic (Notification)
        System.out.println("Connecting to SMTP Server...");
        System.out.println("Sending welcome email to " + email + ": 'Welcome to our platform, " + username + "!'");
        System.out.println("Email sent.");

        // 4. Logging Logic (Audit)
        try {
            FileWriter writer = new FileWriter("user_audit.log", true);
            writer.write("User " + username + " registered at " + new Date() + "\n");
            writer.close();
        } catch (IOException e) {
            System.err.println("Failed to write to audit log: " + e.getMessage());
        }

        System.out.println("User registration completed successfully.");
    }
}
