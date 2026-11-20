from shipping_calculator import ShippingCalculator
from shipping_strategy import FedExStrategy, UPSStrategy, DHLStrategy

if __name__ == "__main__":
    calculator = ShippingCalculator(FedExStrategy())
    print(f"FedEx: {calculator.calculate_cost(10.0)}")

    calculator.set_strategy(UPSStrategy())
    print(f"UPS: {calculator.calculate_cost(10.0)}")

    calculator.set_strategy(DHLStrategy())
    print(f"DHL: {calculator.calculate_cost(10.0)}")
