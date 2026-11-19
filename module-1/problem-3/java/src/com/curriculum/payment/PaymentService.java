package com.curriculum.payment;

public class PaymentService {
    private PaymentGateway gateway = new PaymentGateway();

    public void processPayment(PaymentRequest request) {
        try {
            if (request.getAmount() <= 0) {
                throw new Exception("Amount must be positive");
            }
            
            boolean success = gateway.charge(request.getAmount(), request.getCardNumber());
            if (success) {
                System.out.println("Payment processed successfully!");
            }
        } catch (Exception e) {
            // Naive error handling: just printing to console
            System.out.println("Error processing payment: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
