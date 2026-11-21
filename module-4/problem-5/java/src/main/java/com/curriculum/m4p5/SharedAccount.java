package com.curriculum.m4p5;

/**
 * SharedAccount demonstrates a thread-safe bank account implementation.
 * 
 * This implementation resolves the race conditions identified in Iteration 1
 * by using the 'synchronized' keyword. This ensures that operations on 
 * the shared balance are atomic, preventing lost updates in concurrent environments.
 */
public class SharedAccount {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        int currentBalance = balance;
        // Simulate some processing time to increase the chance of race condition
        try { Thread.sleep(1); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        balance = currentBalance + amount;
    }

    public synchronized void withdraw(int amount) {
        int currentBalance = balance;
        // Simulate some processing time to increase the chance of race condition
        try { Thread.sleep(1); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        balance = currentBalance - amount;
    }

    public synchronized int getBalance() {
        return balance;
    }
}
