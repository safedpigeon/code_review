package com.curriculum.payment;

public class PaymentGateway {
    public boolean charge(double amount, String cardNumber) throws Exception {
        // Simulate some failures
        if (cardNumber == null || cardNumber.isEmpty()) {
            throw new Exception("Invalid card number");
        }
        if (amount > 10000) {
            throw new Exception("Amount too high for this gateway");
        }
        if (Math.random() > 0.8) {
            throw new Exception("Network timeout");
        }
        return true;
    }
}
