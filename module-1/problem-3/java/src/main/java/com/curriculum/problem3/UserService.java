package com.curriculum.problem3;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> userDb = new HashMap<>();

    public UserService() {
        userDb.put("1", new User("1", "Alice"));
        userDb.put("2", new User("2", "Bob"));
    }

    public User getUser(String id) {
        try {
            if (id == null) {
                throw new Exception("ID cannot be null");
            }
            if (!userDb.containsKey(id)) {
                System.out.println("User not found!");
                return null; // Naive return
            }
            return userDb.get(id);
        } catch (Exception e) {
            e.printStackTrace(); // Naive error handling
            return null;
        }
    }

    public void updateUserName(String id, String newName) {
        try {
            User user = getUser(id);
            if (user == null) {
                throw new Exception("Cannot update user: User not found");
            }
            // Simulate update
            System.out.println("Updating user " + id + " to " + newName);
        } catch (Exception e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }
}
