package com.curriculum.m5p4;

import java.util.*;

public class PaymentProcessor {
    public double processPayment(double amount, String currency, String region, String userType) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (currency == null) {
            throw new IllegalArgumentException("Currency cannot be null");
        }

        double taxRate = 0.05;
        if (region.equalsIgnoreCase("US")) {
            taxRate = 0.10;
        } else if (region.equalsIgnoreCase("EU")) {
            taxRate = 0.20;
        }

        double discount = 0.0;
        if (userType.equalsIgnoreCase("PREMIUM")) {
            discount = 0.10;
        } else if (userType.equalsIgnoreCase("GOLD")) {
            discount = 0.20;
        }

        double finalAmount = amount + (amount * taxRate) - (amount * discount);
        
        System.out.println("Processing payment of " + finalAmount + " " + currency + " for region " + region);
        
        // Simulating a database call or external API call
        if (Math.random() < 0.01) {
            throw new RuntimeException("Network error occurred during payment processing");
        }

        return finalAmount;
    }

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        System.out.println("Result: " + processor.processPayment(100.0, "USD", "US", "GOLD"));
    }
}
