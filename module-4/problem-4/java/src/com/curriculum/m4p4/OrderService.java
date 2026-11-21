package com.curriculum.m4p4;

import java.util.UUID;

public class OrderService {
    private InventoryService inventoryService = new InventoryService();

    public void placeOrder(String productId, int quantity) {
        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, productId, quantity);
        
        // Naive implementation: Save order first, then deduct stock.
        // No transaction wrapper.
        System.out.println("[OrderService] Creating order: " + order);
        Database.getInstance().orders.add(order.getOrderId());
        
        try {
            inventoryService.deductStock(productId, quantity);
            System.out.println("[OrderService] Order placed successfully!");
        } catch (Exception e) {
            System.err.println("[OrderService] Error while placing order: " + e.getMessage());
            // Naive mistake: We forget to roll back the order creation in Database.
            throw e;
        }
    }
}
