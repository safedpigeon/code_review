package module_2.problem_2;

public class VIPDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.10;
    }
}
