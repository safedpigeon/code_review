package com.curriculum.m5p4;

import com.curriculum.m5p4.service.TaxCalculator;
import com.curriculum.m5p4.service.DiscountCalculator;
import com.curriculum.m5p4.gateway.PaymentGateway;
import com.curriculum.m5p4.gateway.PaymentGatewayImpl;

public class PaymentProcessor {
    private final TaxCalculator taxCalculator;
    private final DiscountCalculator discountCalculator;
    private final PaymentGateway paymentGateway;

    public PaymentProcessor(TaxCalculator taxCalculator, DiscountCalculator discountCalculator, PaymentGateway paymentGateway) {
        this.taxCalculator = taxCalculator;
        this.discountCalculator = discountCalculator;
        this.paymentGateway = paymentGateway;
    }

    public double processPayment(double amount, String currency, String region, String userType) throws Exception {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (currency == null) {
            throw new IllegalArgumentException("Currency cannot be null");
        }

        double tax = taxCalculator.calculateTax(amount, region);
        double discount = discountCalculator.calculateDiscount(amount, userType);

        double finalAmount = amount + tax - discount;
        
        System.out.println("Processing payment of " + finalAmount + " " + currency + " for region " + region);
        
        paymentGateway.process(finalAmount, currency);

        return finalAmount;
    }

    public static void main(String[] args) {
        try {
            PaymentProcessor processor = new PaymentProcessor(
                new TaxCalculator(), 
                new DiscountCalculator(), 
                new PaymentGatewayImpl()
            );
            System.out.println("Result: " + processor.processPayment(100.0, "USD", "US", "GOLD"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
