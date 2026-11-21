from observer import Observer
from typing import List

class WeatherStation:
    def __init__(self):
        self.temperature = 0.0
        self.observers: List[Observer] = []

    def register_observer(self, observer: Observer):
        if observer not in self.observers:
            self.observers.append(observer)

    def remove_observer(self, observer: Observer):
        self.observers.remove(observer)

    def set_temperature(self, temperature):
        self.temperature = temperature
        self.notify_observers()

    def notify_observers(self):
        for observer in self.observers:
            observer.update(self.temperature)
