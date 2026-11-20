package com.curriculum.m3p5;

public class Main {
    public static void main(String[] args) {
        SmartHomeController controller = new SmartHomeController();

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command fanOn = new FanOnCommand(fan);
        Command acOn = new AcOnCommand(ac);

        System.out.println("--- Executing Commands ---");
        controller.executeCommand(lightOn);
        controller.executeCommand(fanOn);
        controller.executeCommand(acOn);

        System.out.println("\n--- Undoing Commands ---");
        controller.undoCommand(); // Undo AC On
        controller.undoCommand(); // Undo Fan On
        controller.undoCommand(); // Undo Light On
        
        System.out.println("\n--- Final check ---");
        controller.undoCommand(); // Should show "No commands to undo"
    }
}
