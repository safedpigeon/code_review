package module_2.problem_2;

public class Customer {
    public enum CustomerType {
        REGULAR, VIP, PREMIUM
    }

    private CustomerType type;
    private double amount;

    public Customer(CustomerType type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public CustomerType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}
