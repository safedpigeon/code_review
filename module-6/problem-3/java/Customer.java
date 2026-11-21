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
}
