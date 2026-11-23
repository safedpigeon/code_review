from shipping_strategy import ShippingStrategy

class ShippingCalculator:
    def __init__(self, strategy: ShippingStrategy):
        self.strategy = strategy

    def set_strategy(self, strategy: ShippingStrategy):
        self.strategy = strategy

    def calculate_cost(self, weight: float) -> float:
        return self.strategy.calculate(weight)
