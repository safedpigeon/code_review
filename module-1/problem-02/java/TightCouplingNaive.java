
public class TightCouplingNaive {
    public static class PayPalProcessor {
        public boolean processPayment(double amount) {
            System.out.println("Processing payment of $" + amount + " via PayPal...");
            return true;
        }
    }

    public static class PaymentService {
        private PayPalProcessor processor;

        public PaymentService() {
            // TIGHT COUPLING: PaymentService is directly dependent on PayPalProcessor
            this.processor = new PayPalProcessor();
        }

        public void makePayment(double amount) {
            System.out.println("PaymentService: Initiating payment process.");
            boolean success = processor.processPayment(amount);
            if (success) {
                System.out.println("PaymentService: Payment completed successfully.");
            } else {
                System.out.println("PaymentService: Payment failed.");
            }
        }
    }

    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.makePayment(100.0);
    }
}
