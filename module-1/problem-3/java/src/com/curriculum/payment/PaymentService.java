package com.curriculum.payment;

import com.curriculum.payment.exception.PaymentException;
import com.curriculum.payment.exception.InvalidPaymentAmountException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class PaymentService {
    private static final Logger LOGGER = Logger.getLogger(PaymentService.class.getName());
    private final PaymentGateway gateway;

    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    // Default constructor for backward compatibility
    public PaymentService() {
        this(new PaymentGateway());
    }

    public void processPayment(PaymentRequest request) throws PaymentException {
        try {
            if (request.getAmount() <= 0) {
                throw new InvalidPaymentAmountException("Payment amount must be positive. Provided: " + request.getAmount());
            }
            
            boolean success = gateway.charge(request.getAmount(), request.getCardNumber());
            if (success) {
                LOGGER.info("Payment processed successfully!");
            } else {
                throw new PaymentException("Payment gateway declined the transaction.");
            }
        } catch (InvalidPaymentAmountException e) {
            LOGGER.log(Level.WARNING, "Validation failed: {0}", e.getMessage());
            throw e;
        } catch (PaymentException e) {
            LOGGER.log(Level.SEVERE, "Payment processing error: {0}", e.getMessage());
            throw e;
        } catch (RuntimeException e) {
            LOGGER.log(Level.SEVERE, "Unexpected system error occurred during payment processing", e);
            throw new PaymentException("A system error occurred. Please try again later.", e);
        }
    }
}

