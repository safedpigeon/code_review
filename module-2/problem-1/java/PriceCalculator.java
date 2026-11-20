package module2.problem1;

public class PriceCalculator {
    public double calculateFinalAmount(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        double tax = total * 0.15;
        double finalAmount = total + tax;
        System.out.println("Total calculated: " + finalAmount);
        return finalAmount;
    }
}
