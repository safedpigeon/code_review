package com.curriculum.m3p5;

public class AcOnCommand implements Command {
    private AirConditioner ac;
    public AcOnCommand(AirConditioner ac) { this.ac = ac; }
    @Override public void execute() { ac.turnOn(); }
    @Override public void undo() { ac.turnOff(); }
}
