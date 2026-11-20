package com.curriculum.m3p5;

public class AirConditioner {
    private boolean on = false;
    public void turnOn() { on = true; System.out.println("AC is ON"); }
    public void turnOff() { on = false; System.out.println("AC is OFF"); }
    public boolean isOn() { return on; }
}
