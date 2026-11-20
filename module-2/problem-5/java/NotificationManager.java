package module2.problem5;

public class NotificationManager {
    private SmsService smsService;

    public NotificationManager() {
        // Tight coupling: NotificationManager creates its own dependency
        this.smsService = new SmsService();
    }

    public void sendNotification(String message, String phone) {
        smsService.sendSms(message, phone);
    }
}
