package module1.problem4;

public class PaymentService {
    private final AppConfig config;

    public PaymentService(AppConfig config) {
        this.config = config;
    }

    public void processPayment(double amount) {
        // Use the externalized configuration instead of hardcoded values
        System.out.println("Connecting to " + config.getApiUrl() + " with key " + config.getApiKey());
        System.out.println("Processing payment of $" + amount + " with timeout " + config.getTimeout() + "ms");
        System.out.println("Payment processed successfully.");
    }
}
