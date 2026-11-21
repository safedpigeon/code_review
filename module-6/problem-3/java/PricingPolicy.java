package module6.problem3;

public class PricingPolicy {
    private double baseDiscount;
    private double loyaltyMultiplier;

    public PricingPolicy(double baseDiscount, double loyaltyMultiplier) {
        this.baseDiscount = baseDiscount;
        this.loyaltyMultiplier = loyaltyMultiplier;
    }

    public double getBaseDiscount() { return baseDiscount; }
    public double getLoyaltyMultiplier() { return loyaltyMultiplier; }
}
