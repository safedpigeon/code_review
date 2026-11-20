from models import Order

class PriceCalculator:
    def calculate_final_amount(self, order: Order) -> float:
        total = sum(item.price * item.quantity for item in order.items)
        tax = total * 0.15
        final_amount = total + tax
        print(f"Total calculated: {final_amount}")
        return final_amount
