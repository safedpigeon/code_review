package module6.problem3;

public class Customer {
    private String name;
    private String membershipLevel; // "GOLD", "SILVER", "BRONZE"
    private int yearsAsCustomer;

    public Customer(String name, String membershipLevel, int yearsAsCustomer) {
        this.name = name;
        this.membershipLevel = membershipLevel;
        this.yearsAsCustomer = yearsAsCustomer;
    }

    public String getMembershipLevel() { return membershipLevel; }
    public int getYearsAsCustomer() { return yearsAsCustomer; }
    public String getName() { return name; }

    public double getMembershipDiscount() {
        if ("GOLD".equals(membershipLevel)) return 0.10;
        if ("SILVER".equals(membershipLevel)) return 0.05;
        return 0.0;
    }

    public boolean isLoyal() {
        return yearsAsCustomer > 5;
    }

}
