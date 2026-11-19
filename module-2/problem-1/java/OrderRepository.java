package module2.problem1;

public class OrderRepository {
    public void save(Order order) {
        System.out.println("Saving order to database... Order ID: " + order.getId());
    }
}
