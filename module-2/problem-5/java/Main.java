package module2.problem5;

public class Main {
    public static void main(String[] args) {
        NotificationService smsService = new SmsService();
        NotificationManager manager = new NotificationManager(smsService);
        manager.sendNotification("Hello from DIP Lesson!", "123-456-7890");
    }
}
