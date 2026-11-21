package com.curriculum.m4p4;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        Database db = Database.getInstance();

        System.out.println("--- Scenario 1: Successful Order ---");
        try {
            orderService.placeOrder("PROD1", 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n--- Scenario 2: Failed Order (Insufficient Stock) ---");
        try {
            orderService.placeOrder("PROD1", 20);
        } catch (Exception e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        System.out.println("\n--- Scenario 3: Failed Order (System Crash) ---");
        try {
            orderService.placeOrder("FAIL", 1);
        } catch (Exception e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        System.out.println("\n--- Final Database State ---");
        System.out.println("Orders in DB: " + db.orders);
        System.out.println("Inventory in DB: " + db.inventory);
        
        System.out.println("\nObservation: Notice how orders were added to the DB even when the transaction failed!");
    }
}
