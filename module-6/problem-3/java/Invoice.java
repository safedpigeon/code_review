package module6.problem3;

public class Invoice {
    public double calculateDiscount(Customer customer, PricingPolicy policy) {
        double discount = policy.getBaseDiscount();
        
        // Fixed Feature Envy: Logic moved to Customer class
        discount += customer.getMembershipDiscount();
        
        if (customer.isLoyal()) {
            discount += policy.getLoyaltyMultiplier() * 0.02;
        }
        
        return discount;
    }
}
