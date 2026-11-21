package com.curriculum.m4p4;

public class InventoryService {
    public void deductStock(String productId, int quantity) {
        Database db = Database.getInstance();
        int currentStock = db.inventory.getOrDefault(productId, 0);
        
        System.out.println("[InventoryService] Deducting stock for " + productId + ": " + currentStock + " -> " + (currentStock - quantity));
        
        if (quantity > currentStock) {
            throw new RuntimeException("Insufficient stock for product: " + productId);
        }
        
        // Simulating a crash or failure after some processing
        if ("FAIL".equals(productId)) {
            throw new RuntimeException("Database connection failed in InventoryService!");
        }

        db.inventory.put(productId, currentStock - quantity);
    }
}
