package com.curriculum.m4p17;

import java.util.*;

public class UserRepository {
    private List<User> mockDb = Arrays.asList(
        new User(1, "Alice"),
        new User(2, "Bob"),
        new User(3, "Charlie")
    );

    public List<User> getAllUsers() {
        System.out.println("Executing: SELECT * FROM users");
        return mockDb;
    }
}
