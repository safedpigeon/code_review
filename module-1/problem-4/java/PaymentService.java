package module1.problem4;

public class PaymentService {
    // Hardcoded configurations - Anti-pattern
    private final String API_URL = "https://api.payments.com/v1";
    private final String API_KEY = "sk_test_4eC39HqLyjWDarjtT1zdp7dc";
    private final int TIMEOUT = 5000;

    public void processPayment(double amount) {
        System.out.println("Connecting to " + API_URL + " with key " + API_KEY);
        System.out.println("Processing payment of $" + amount + " with timeout " + TIMEOUT + "ms");
        // Imagine payment processing logic here
        System.out.println("Payment processed successfully.");
    }
}
