class ShippingService:
    def calculate_shipping(self, items):
        shipping_cost = 0
        for item in items:
            shipping_cost += item['weight'] * 0.5
        print(f"Total shipping cost calculated: ${shipping_cost}")
        return shipping_cost
