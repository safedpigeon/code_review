public class Main {
    public static void main(String[] args) {
        ShippingCalculator calculator = new ShippingCalculator();
        System.out.println("FedEx: " + calculator.calculateCost("FedEx", 10.0));
        System.out.println("UPS: " + calculator.calculateCost("UPS", 10.0));
        System.out.println("DHL: " + calculator.calculateCost("DHL", 10.0));
    }
}
