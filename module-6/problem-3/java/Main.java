package module6.problem3;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John Doe", "GOLD", 6);
        PricingPolicy policy = new PricingPolicy(0.05, 1.5);
        Invoice invoice = new Invoice();
        
        System.out.println("Discount: " + invoice.calculateDiscount(customer, policy));
    }
}
