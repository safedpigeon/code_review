package com.curriculum.m4p5;

/**
 * SharedAccount demonstrates a basic bank account implementation.
 * 
 * This version is intended to be functional for single-threaded use 
 * but exhibits common concurrency issues when accessed by multiple threads.
 */
public class SharedAccount {
    private int balance = 0;

    public void deposit(int amount) {
        int currentBalance = balance;
        // Simulate some processing time to increase the chance of race condition
        try { Thread.sleep(1); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        balance = currentBalance + amount;
    }

    public void withdraw(int amount) {
        int currentBalance = balance;
        // Simulate some processing time to increase the chance of race condition
        try { Thread.sleep(1); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        balance = currentBalance - amount;
    }

    public int getBalance() {
        return balance;
    }
}
