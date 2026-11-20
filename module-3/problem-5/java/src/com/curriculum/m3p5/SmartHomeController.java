package com.curriculum.m3p5;

import java.util.*;

public class SmartHomeController {
    private Map<String, String> deviceStates = new HashMap<>();

    public void executeAction(String device, String action) {
        System.out.println("Executing " + action + " on " + device);
        
        if (device.equalsIgnoreCase("Light")) {
            if (action.equalsIgnoreCase("ON")) {
                deviceStates.put("Light", "ON");
                System.out.println("Light is now ON");
            } else if (action.equalsIgnoreCase("OFF")) {
                deviceStates.put("Light", "OFF");
                System.out.println("Light is now OFF");
            } else {
                System.out.println("Unknown action for Light");
            }
        } else if (device.equalsIgnoreCase("Fan")) {
            if (action.equalsIgnoreCase("ON")) {
                deviceStates.put("Fan", "ON");
                System.out.println("Fan is now ON");
            } else if (action.equalsIgnoreCase("OFF")) {
                deviceStates.put("Fan", "OFF");
                System.out.println("Fan is now OFF");
            } else {
                System.out.println("Unknown action for Fan");
            }
        } else if (device.equalsIgnoreCase("AirConditioner")) {
            if (action.equalsIgnoreCase("ON")) {
                deviceStates.put("AirConditioner", "ON");
                System.out.println("AC is now ON");
            } else if (action.equalsIgnoreCase("OFF")) {
                deviceStates.put("AirConditioner", "OFF");
                System.out.println("AC is now OFF");
            } else {
                System.out.println("Unknown action for AC");
            }
        } else {
            System.out.println("Device not found: " + device);
        }
    }

    public String getState(String device) {
        return deviceStates.getOrDefault(device, "UNKNOWN");
    }
}
