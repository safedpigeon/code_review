package module2.problem5;

public class NotificationManager {
    private NotificationService notificationService;

    public NotificationManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendNotification(String message, String destination) {
        notificationService.send(message, destination);
    }
}
