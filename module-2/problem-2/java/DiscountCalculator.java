package module_2.problem_2;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {
    private final Map<Customer.CustomerType, DiscountStrategy> strategies = new HashMap<>();

    public DiscountCalculator() {
        // In a real production system, these could be injected via Spring/Guice
        strategies.put(Customer.CustomerType.REGULAR, new RegularDiscountStrategy());
        strategies.put(Customer.CustomerType.VIP, new VIPDiscountStrategy());
        strategies.put(Customer.CustomerType.PREMIUM, new PremiumDiscountStrategy());
    }

    public void addStrategy(Customer.CustomerType type, DiscountStrategy strategy) {
        strategies.put(type, strategy);
    }

    public double calculateDiscount(Customer customer) {
        DiscountStrategy strategy = strategies.get(customer.getType());
        if (strategy == null) {
            return 0;
        }
        return strategy.applyDiscount(customer.getAmount());
    }

    public static void main(String[] args) {
        Customer customer = new Customer(Customer.CustomerType.VIP, 100.0);
        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println("Discount: " + calculator.calculateDiscount(customer));
    }
}

