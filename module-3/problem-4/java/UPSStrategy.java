public class UPSStrategy implements ShippingStrategy {
    @Override
    public double calculate(double weight) {
        return weight * 1.2;
    }
}
