package module2.problem1;
import java.util.List;

public class Order {
    private String id;
    private String customerEmail;
    private List<Item> items;

    public Order(String id, String customerEmail, List<Item> items) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.items = items;
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<Item> getItems() { return items; }
}
