from observer import Observer

class WindowDisplay(Observer):
    def update(self, temperature):
        print(f"Window Display: Current temperature is {temperature}°C")
