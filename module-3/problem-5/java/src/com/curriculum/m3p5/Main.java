package com.curriculum.m3p5;

public class Main {
    public static void main(String[] args) {
        SmartHomeController controller = new SmartHomeController();

        controller.executeAction("Light", "ON");
        controller.executeAction("Fan", "ON");
        controller.executeAction("AirConditioner", "OFF");
        controller.executeAction("Television", "ON"); // Should fail

        System.out.println("Final Light State: " + controller.getState("Light"));
    }
}
