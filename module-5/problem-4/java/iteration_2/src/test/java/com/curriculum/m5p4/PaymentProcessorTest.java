package com.curriculum.m5p4;

import com.curriculum.m5p4.service.TaxCalculator;
import com.curriculum.m5p4.service.DiscountCalculator;
import com.curriculum.m5p4.gateway.PaymentGateway;
import com.curriculum.m5p4.gateway.PaymentGatewayImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicBoolean;

public class PaymentProcessorTest {
    private TaxCalculator taxCalculator;
    private DiscountCalculator discountCalculator;

    @BeforeEach
    void setUp() {
        taxCalculator = new TaxCalculator();
        discountCalculator = new DiscountCalculator();
    }

    // --- Unit Tests ---
    
    @Test
    void testTaxCalculation() {
        assertEquals(10.0, taxCalculator.calculateTax(100.0, "US"));
        assertEquals(20.0, taxCalculator.calculateTax(100.0, "EU"));
        assertEquals(5.0, taxCalculator.calculateTax(100.0, "Asia"));
        assertEquals(5.0, taxCalculator.calculateTax(100.0, null));
    }

    @Test
    void testDiscountCalculation() {
        assertEquals(10.0, discountCalculator.calculateDiscount(100.0, "PREMIUM"));
        assertEquals(20.0, discountCalculator.calculateDiscount(100.0, "GOLD"));
        assertEquals(0.0, discountCalculator.calculateDiscount(100.0, "REGULAR"));
        assertEquals(0.0, discountCalculator.calculateDiscount(100.0, null));
    }

    // --- Integration Tests ---

    @Test
    void testPaymentProcessorWithMockGateway() throws Exception {
        AtomicBoolean gatewayCalled = new AtomicBoolean(false);
        PaymentGateway mockGateway = (amount, currency) -> {
            gatewayCalled.set(true);
        };

        PaymentProcessor processor = new PaymentProcessor(taxCalculator, discountCalculator, mockGateway);
        double result = processor.processPayment(100.0, "USD", "US", "GOLD");

        // 100 + 10 (US tax) - 20 (GOLD discount) = 90
        assertEquals(90.0, result);
        assertTrue(gatewayCalled.get(), "Gateway should have been called");
    }

    @Test
    void testPaymentProcessorInvalidAmount() {
        PaymentGateway mockGateway = (amount, currency) -> {};
        PaymentProcessor processor = new PaymentProcessor(taxCalculator, discountCalculator, mockGateway);
        
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processPayment(-10.0, "USD", "US", "GOLD");
        });
    }

    // --- E2E Test ---

    @Test
    void testFullPaymentFlow() throws Exception {
        PaymentProcessor processor = new PaymentProcessor(
            new TaxCalculator(),
            new DiscountCalculator(),
            new PaymentGatewayImpl()
        );
        
        // This might randomly fail due to the 1% chance in PaymentGatewayImpl, 
        // but in a real E2E test we would handle retries or use a stable environment.
        double result = processor.processPayment(100.0, "USD", "EU", "PREMIUM");
        // 100 + 20 (EU) - 10 (PREMIUM) = 110
        assertEquals(110.0, result);
    }
}
