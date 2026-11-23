from abc import ABC, abstractmethod

class ShippingStrategy(ABC):
    @abstractmethod
    def calculate(self, weight: float) -> float:
        pass

class FedExStrategy(ShippingStrategy):
    def calculate(self, weight: float) -> float:
        return weight * 1.5

class UPSStrategy(ShippingStrategy):
    def calculate(self, weight: float) -> float:
        return weight * 1.2

class DHLStrategy(ShippingStrategy):
    def calculate(self, weight: float) -> float:
        return weight * 2.0
