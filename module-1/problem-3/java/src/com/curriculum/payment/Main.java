package com.curriculum.payment;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        System.out.println("Test 1: Valid Payment");
        service.processPayment(new PaymentRequest(100.0, "1234-5678-9012-3456"));

        System.out.println("\nTest 2: Invalid Amount");
        service.processPayment(new PaymentRequest(-10.0, "1234-5678-9012-3456"));

        System.out.println("\nTest 3: Invalid Card");
        service.processPayment(new PaymentRequest(100.0, ""));

        System.out.println("\nTest 4: Amount too high");
        service.processPayment(new PaymentRequest(20000.0, "1234-5678-9012-3456"));
    }
}
