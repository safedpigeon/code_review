import java.util.*;

public class OrderProcessor {
    public void processOrder(Order order) {
        // 1. Validation
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item");
        }
        System.out.println("Order validated.");

        // 2. Calculation
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        double tax = total * 0.15; // 15% tax
        double finalAmount = total + tax;
        System.out.println("Total calculated: " + finalAmount);

        // 3. Persistence
        System.out.println("Saving order to database... Order ID: " + order.getId());
        // Mock DB save
        
        // 4. Notification
        System.out.println("Sending confirmation email to: " + order.getCustomerEmail());
        // Mock email send
    }

    public static class Order {
        private String id;
        private String customerEmail;
        private List<Item> items;

        public Order(String id, String customerEmail, List<Item> items) {
            this.id = id;
            this.customerEmail = customerEmail;
            this.items = items;
        }

        public String getId() { return id; }
        public String getCustomerEmail() { return customerEmail; }
        public List<Item> getItems() { return items; }
    }

    public static class Item {
        private String name;
        private double price;
        private int quantity;

        public Item(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public double getPrice() { return price; }
        public int getQuantity() { return quantity; }
    }

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(new Item("Laptop", 1200.0, 1), new Item("Mouse", 25.0, 2));
        Order order = new Order("ORD-123", "customer@example.com", items);
        OrderProcessor processor = new OrderProcessor();
        processor.processOrder(order);
    }
}
