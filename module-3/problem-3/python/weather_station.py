from phone_display import PhoneDisplay
from window_display import WindowDisplay

class WeatherStation:
    def __init__(self, phone_display: PhoneDisplay, window_display: WindowDisplay):
        self.temperature = 0.0
        self.phone_display = phone_display
        self.window_display = window_display

    def set_temperature(self, temperature):
        self.temperature = temperature
        self.notify_displays()

    def notify_displays(self):
        # Tight coupling: WeatherStation depends on concrete display classes
        self.phone_display.update(self.temperature)
        self.window_display.show_temperature(self.temperature)
