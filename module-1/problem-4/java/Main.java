package module1.problem4;

public class Main {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        PaymentService paymentService = new PaymentService(config);
        paymentService.processPayment(250.0);
    }
}
