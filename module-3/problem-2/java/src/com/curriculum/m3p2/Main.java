package com.curriculum.m3p2;

public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        
        service.sendNotification("EMAIL", "Hello via Email!");
        service.sendNotification("SMS", "Hello via SMS!");
        service.sendNotification("PUSH", "Hello via Push!");
    }
}
