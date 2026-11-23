package module_4.problem_1.java;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        User user = new User("John Doe", "john@example.com");
        userRepository.save(user);

        User foundUser = userRepository.findById(1);
        System.out.println("Found User: " + foundUser.getName());

        userRepository.delete(user);
    }
}

