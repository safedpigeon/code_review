
public class TightCouplingRefactored {
    public interface PaymentProcessor {
        boolean processPayment(double amount);
    }

    public static class PayPalProcessor implements PaymentProcessor {
        @Override
        public boolean processPayment(double amount) {
            System.out.println("Processing payment of $" + amount + " via PayPal...");
            return true;
        }
    }

    public static class StripeProcessor implements PaymentProcessor {
        @Override
        public boolean processPayment(double amount) {
            System.out.println("Processing payment of $" + amount + " via Stripe...");
            return true;
        }
    }

    public static class PaymentService {
        private PaymentProcessor processor;

        // LOOSE COUPLING: PaymentService depends on the interface, not a concrete class
        public PaymentService(PaymentProcessor processor) {
            this.processor = processor;
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
        // We can now inject any processor we want
        PaymentService paypalService = new PaymentService(new PayPalProcessor());
        paypalService.makePayment(100.0);

        PaymentService stripeService = new PaymentService(new StripeProcessor());
        stripeService.makePayment(200.0);
    }
}
