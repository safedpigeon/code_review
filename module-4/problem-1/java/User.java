package module_4.problem_1.java;

import java.util.*;

public class User {
    private static Map<Integer, User> database = new HashMap<>();
    private static int idCounter = 1;

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

    // Active Record Methods - The Anti-pattern
    public void save() {
        if (this.id == 0) {
            this.id = idCounter++;
        }
        database.put(this.id, this);
        System.out.println("User saved to database: " + this.name);
    }

    public static User findById(int id) {
        return database.get(id);
    }

    public void delete() {
        database.remove(this.id);
        System.out.println("User deleted from database: " + this.name);
    }
}
