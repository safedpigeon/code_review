package com.curriculum.payment.exception;

public class InvalidPaymentAmountException extends PaymentException {
    public InvalidPaymentAmountException(String message) {
        super(message);
    }
}
