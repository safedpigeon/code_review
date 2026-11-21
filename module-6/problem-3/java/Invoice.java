package module6.problem3;

public class Invoice {
    public double calculateDiscount(Customer customer, PricingPolicy policy) {
        double discount = policy.getBaseDiscount();
        
        // Feature Envy: Invoice is too interested in Customer's details
        if (customer.getMembershipLevel().equals("GOLD")) {
            discount += 0.10;
        } else if (customer.getMembershipLevel().equals("SILVER")) {
            discount += 0.05;
        }
        
        if (customer.getYearsAsCustomer() > 5) {
            discount += policy.getLoyaltyMultiplier() * 0.02;
        }
        
        return discount;
    }
}
