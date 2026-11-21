package module2.problem5;

public class SmsService implements NotificationService {
    @Override
    public void send(String message, String phoneNumber) {
        System.out.println("Sending SMS: " + message + " to " + phoneNumber);
    }
}
