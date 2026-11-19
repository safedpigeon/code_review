package module2.problem1;

public class NotificationService {
    public void sendConfirmation(Order order) {
        System.out.println("Sending confirmation email to: " + order.getCustomerEmail());
    }
}
