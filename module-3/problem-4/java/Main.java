public class Main {
    public static void main(String[] args) {
        ShippingCalculator calculator = new ShippingCalculator(new FedExStrategy());
        System.out.println("FedEx: " + calculator.calculateCost(10.0));

        calculator.setStrategy(new UPSStrategy());
        System.out.println("UPS: " + calculator.calculateCost(10.0));

        calculator.setStrategy(new DHLStrategy());
        System.out.println("DHL: " + calculator.calculateCost(10.0));
    }
}
