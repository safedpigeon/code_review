class ShippingCalculator:
    def calculate_cost(self, provider: str, weight: float) -> float:
        if provider.lower() == "fedex":
            return weight * 1.5
        elif provider.lower() == "ups":
            return weight * 1.2
        elif provider.lower() == "dhl":
            return weight * 2.0
        else:
            raise ValueError(f"Unsupported provider: {provider}")
