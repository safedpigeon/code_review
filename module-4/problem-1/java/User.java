package module_4.problem_1.java;

import java.util.*;

public class User {
    private int id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    // Setter for ID (used by Repository)
    public void setId(int id) { this.id = id; }
}

