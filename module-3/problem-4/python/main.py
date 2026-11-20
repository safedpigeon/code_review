from shipping_calculator import ShippingCalculator

if __name__ == "__main__":
    calculator = ShippingCalculator()
    print(f"FedEx: {calculator.calculate_cost('FedEx', 10.0)}")
    print(f"UPS: {calculator.calculate_cost('UPS', 10.0)}")
    print(f"DHL: {calculator.calculate_cost('DHL', 10.0)}")
