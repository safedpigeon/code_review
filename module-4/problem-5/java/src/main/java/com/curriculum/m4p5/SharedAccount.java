package com.curriculum.m4p5;

/**
 * SharedAccount demonstrates a classic concurrency problem: Race Conditions.
 * 
 * The original implementation was not thread-safe, meaning if multiple threads
 * tried to deposit or withdraw simultaneously, some updates would be lost
 * because the read-modify-write cycle was not atomic.
 * 
 * The fix uses the 'synchronized' keyword on methods, which ensures that only
 * one thread can execute any of these methods at a time for a given instance,
 * making the operations atomic.
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
