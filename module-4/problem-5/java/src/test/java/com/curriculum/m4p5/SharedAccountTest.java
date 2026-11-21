package com.curriculum.m4p5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedAccountTest {
    @Test
    public void testConcurrentDeposits() throws InterruptedException {
        SharedAccount account = new SharedAccount();
        int numThreads = 10;
        int depositsPerThread = 100;
        int amount = 1;
        
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        for (int i = 0; i < numThreads; i++) {
            executor.submit(() -> {
                for (int j = 0; j < depositsPerThread; j++) {
                    account.deposit(amount);
                }
            });
        }
        
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        
        assertEquals(numThreads * depositsPerThread * amount, account.getBalance(), 
            "Final balance should be the sum of all deposits");
    }
}
