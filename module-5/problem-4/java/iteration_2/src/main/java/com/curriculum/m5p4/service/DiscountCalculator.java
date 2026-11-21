package com.curriculum.m5p4.service;

public class DiscountCalculator {
    public double calculateDiscount(double amount, String userType) {
        if (userType == null) return 0.0;
        if (userType.equalsIgnoreCase("PREMIUM")) return amount * 0.10;
        if (userType.equalsIgnoreCase("GOLD")) return amount * 0.20;
        return 0.0;
    }
}
