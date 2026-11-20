package com.curriculum.m3p2;

public class NotificationService {
    public Notification getNotification(String type) {
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("SMS")) {
            return new SmsNotification();
        } else if (type.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        } else {
            throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }

    public void sendNotification(String type, String message) {
        Notification notification = getNotification(type);
        notification.send(message);
    }
}
