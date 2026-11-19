package module1.problem01;

public class SqlUserRepository implements UserRepository {
    @Override
    public void saveUser(String username, String email, String password) {
        System.out.println("Connecting to Database...");
        System.out.println("INSERT INTO users (username, email, password) VALUES ('" + username + "', '" + email + "', '" + password + "');");
        System.out.println("User saved to database successfully.");
    }
}
