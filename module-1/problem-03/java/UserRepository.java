import java.util.*;

public class UserRepository {
    private Map<Integer, Double> accounts = new HashMap<>();

    public UserRepository() {
        accounts.put(1, 100.0);
        accounts.put(2, 50.0);
    }

    public Double getBalance(int id) throws Exception {
        if (!accounts.containsKey(id)) {
            throw new Exception("User not found");
        }
        return accounts.get(id);
    }

    public void updateBalance(int id, double amount) throws Exception {
        if (!accounts.containsKey(id)) {
            throw new Exception("User not found");
        }
        accounts.put(id, accounts.get(id) + amount);
    }
}
