package com.curriculum.m3p5;

public class AcOffCommand implements Command {
    private AirConditioner ac;
    public AcOffCommand(AirConditioner ac) { this.ac = ac; }
    @Override public void execute() { ac.turnOff(); }
    @Override public void undo() { ac.turnOn(); }
}
