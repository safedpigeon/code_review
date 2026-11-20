package module_4.problem_1.java;

public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe", "john@example.com");
        user.save();

        User foundUser = User.findById(1);
        System.out.println("Found User: " + foundUser.getName());

        user.delete();
    }
}
