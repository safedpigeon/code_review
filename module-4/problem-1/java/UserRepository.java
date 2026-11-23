package module_4.problem_1.java;

import java.util.*;

public class UserRepository {
    private Map<Integer, User> database = new HashMap<>();
    private int idCounter = 1;

    public void save(User user) {
        if (user.getId() == 0) {
            user.setId(idCounter++);
        }
        database.put(user.getId(), user);
        System.out.println("User saved to database: " + user.getName());
    }

    public User findById(int id) {
        return database.get(id);
    }

    public void delete(User user) {
        database.remove(user.getId());
        System.out.println("User deleted from database: " + user.getName());
    }
}
