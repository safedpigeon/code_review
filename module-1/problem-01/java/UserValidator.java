package module1.problem01;

public class UserValidator {
    public void validate(String username, String email, String password) {
        if (username == null || username.length() < 3) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password too short");
        }
    }
}
