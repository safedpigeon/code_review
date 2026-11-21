package com.curriculum.m5p4.service;

public class TaxCalculator {
    public double calculateTax(double amount, String region) {
        if (region == null) return amount * 0.05;
        if (region.equalsIgnoreCase("US")) return amount * 0.10;
        if (region.equalsIgnoreCase("EU")) return amount * 0.20;
        return amount * 0.05;
    }
}
