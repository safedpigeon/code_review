package module1.problem01;

public class EmailService {
    public void sendWelcomeEmail(String email, String username) {
        System.out.println("Connecting to SMTP Server...");
        System.out.println("Sending welcome email to " + email + ": 'Welcome to our platform, " + username + "!'");
        System.out.println("Email sent.");
    }
}
