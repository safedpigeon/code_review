from customer import Customer, CustomerType
from discount_strategy import DiscountStrategy
from strategies import RegularDiscountStrategy, VIPDiscountStrategy, PremiumDiscountStrategy

class DiscountCalculator:
    def __init__(self):
        self._strategies = {
            CustomerType.REGULAR: RegularDiscountStrategy(),
            CustomerType.VIP: VIPDiscountStrategy(),
            CustomerType.PREMIUM: PremiumDiscountStrategy(),
        }

    def add_strategy(self, customer_type: CustomerType, strategy: DiscountStrategy):
        self._strategies[customer_type] = strategy

    def calculate_discount(self, customer: Customer) -> float:
        strategy = self._strategies.get(customer.customer_type)
        if not strategy:
            return 0.0
        return strategy.apply_discount(customer.amount)

if __name__ == "__main__":
    customer = Customer(CustomerType.VIP, 100.0)
    calculator = DiscountCalculator()
    print(f"Discount: {calculator.calculate_discount(customer)}")

