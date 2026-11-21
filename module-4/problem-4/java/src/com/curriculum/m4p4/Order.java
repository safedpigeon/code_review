package com.curriculum.m4p4;

public class Order {
    private String orderId;
    private String productId;
    private int quantity;

    public Order(String orderId, String productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getOrderId() { return orderId; }
    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return "Order{id='" + orderId + "', productId='" + productId + "', quantity=" + quantity + "}";
    }
}
