package com.curriculum.m3p5;

public class FanOffCommand implements Command {
    private Fan fan;
    public FanOffCommand(Fan fan) { this.fan = fan; }
    @Override public void execute() { fan.turnOff(); }
    @Override public void undo() { fan.turnOn(); }
}
