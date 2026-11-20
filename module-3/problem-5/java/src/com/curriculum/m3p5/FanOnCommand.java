package com.curriculum.m3p5;

public class FanOnCommand implements Command {
    private Fan fan;
    public FanOnCommand(Fan fan) { this.fan = fan; }
    @Override public void execute() { fan.turnOn(); }
    @Override public void undo() { fan.turnOff(); }
}
