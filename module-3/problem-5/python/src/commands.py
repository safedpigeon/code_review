from abc import ABC, abstractmethod

class Command(ABC):
    @abstractmethod
    def execute(self):
        pass

    @abstractmethod
    def undo(self):
        pass

class LightOnCommand(Command):
    def __init__(self, light):
        self.light = light
    def execute(self):
        self.light.turn_on()
    def undo(self):
        self.light.turn_off()

class LightOffCommand(Command):
    def __init__(self, light):
        self.light = light
    def execute(self):
        self.light.turn_off()
    def undo(self):
        self.light.turn_on()

class FanOnCommand(Command):
    def __init__(self, fan):
        self.fan = fan
    def execute(self):
        self.fan.turn_on()
    def undo(self):
        self.fan.turn_off()

class FanOffCommand(Command):
    def __init__(self, fan):
        self.fan = fan
    def execute(self):
        self.fan.turn_off()
    def undo(self):
        self.fan.turn_on()

class AcOnCommand(Command):
    def __init__(self, ac):
        self.ac = ac
    def execute(self):
        self.ac.turn_on()
    def undo(self):
        self.ac.turn_off()

class AcOffCommand(Command):
    def __init__(self, ac):
        self.ac = ac
    def execute(self):
        self.ac.turn_off()
    def undo(self):
        self.ac.turn_on()
