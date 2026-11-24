package com.curriculum.m5p4.gateway;

public class PaymentGatewayImpl implements PaymentGateway {
    @Override
    public void process(double amount, String currency) throws Exception {
        System.out.println("Sending request to bank for " + amount + " " + currency);
        if (Math.random() < 0.01) {
            throw new Exception("Network error occurred during payment processing");
        }
    }
}
