package com.curriculum.m4p4;

import java.util.UUID;

public class OrderService {
    private InventoryService inventoryService = new InventoryService();

    public void placeOrder(String productId, int quantity) {
        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, productId, quantity);
        
        // Corrected implementation: Using a compensating transaction (Saga pattern)
        System.out.println("[OrderService] Creating order: " + order);
        Database.getInstance().orders.add(orderId);
        
        try {
            inventoryService.deductStock(productId, quantity);
            System.out.println("[OrderService] Order placed successfully!");
        } catch (Exception e) {
            System.err.println("[OrderService] Error while placing order: " + e.getMessage());
            
            // COMPENSATING TRANSACTION: Undo the order creation to maintain consistency.
            System.out.println("[OrderService] Rolling back order " + orderId + " due to failure...");
            Database.getInstance().orders.remove(orderId);
            
            throw e;
        }
    }
}
