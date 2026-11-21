package com.curriculum.m5p4.gateway;

public interface PaymentGateway {
    void process(double amount, String currency) throws Exception;
}
