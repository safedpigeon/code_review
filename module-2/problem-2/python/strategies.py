from discount_strategy import DiscountStrategy

class RegularDiscountStrategy(DiscountStrategy):
    def apply_discount(self, amount: float) -> float:
        return amount * 0.05

class VIPDiscountStrategy(DiscountStrategy):
    def apply_discount(self, amount: float) -> float:
        return amount * 0.10

class PremiumDiscountStrategy(DiscountStrategy):
    def apply_discount(self, amount: float) -> float:
        return amount * 0.20
