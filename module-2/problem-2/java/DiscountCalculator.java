package module_2.problem_2;

public class DiscountCalculator {
    public double calculateDiscount(Customer customer) {
        switch (customer.getType()) {
            case REGULAR:
                return customer.getAmount() * 0.05;
            case VIP:
                return customer.getAmount() * 0.10;
            case PREMIUM:
                return customer.getAmount() * 0.20;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Customer customer = new Customer(Customer.CustomerType.VIP, 100.0);
        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println("Discount: " + calculator.calculateDiscount(customer));
    }
}
