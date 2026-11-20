public class ShippingCalculator {
    public double calculateCost(String provider, double weight) {
        if (provider.equalsIgnoreCase("FedEx")) {
            return weight * 1.5;
        } else if (provider.equalsIgnoreCase("UPS")) {
            return weight * 1.2;
        } else if (provider.equalsIgnoreCase("DHL")) {
            return weight * 2.0;
        } else {
            throw new IllegalArgumentException("Unsupported provider: " + provider);
        }
    }
}
