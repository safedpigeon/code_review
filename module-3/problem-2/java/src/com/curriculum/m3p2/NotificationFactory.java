package com.curriculum.m3p2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NotificationFactory {
    private static final Map<String, Supplier<Notification>> NOTIFICATIONS = new HashMap<>();

    static {
        NOTIFICATIONS.put("EMAIL", EmailNotification::new);
        NOTIFICATIONS.put("SMS", SmsNotification::new);
        NOTIFICATIONS.put("PUSH", PushNotification::new);
    }

    public static Notification createNotification(String type) {
        Supplier<Notification> supplier = NOTIFICATIONS.get(type.toUpperCase());
        if (supplier == null) {
            throw new IllegalArgumentException("Unknown notification type: " + type);
        }
        return supplier.get();
    }
}
