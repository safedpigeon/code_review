class Light:
    def __init__(self):
        self.on = False

    def turn_on(self):
        self.on = True
        print("Light is ON")

    def turn_off(self):
        self.on = False
        print("Light is OFF")

class Fan:
    def __init__(self):
        self.on = False

    def turn_on(self):
        self.on = True
        print("Fan is ON")

    def turn_off(self):
        self.on = False
        print("Fan is OFF")

class AirConditioner:
    def __init__(self):
        self.on = False

    def turn_on(self):
        self.on = True
        print("AC is ON")

    def turn_off(self):
        self.on = False
        print("AC is OFF")
