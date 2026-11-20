from models import Order

class OrderValidator:
    def validate(self, order: Order):
        if not order.items:
            raise ValueError("Order must have at least one item")
        print("Order validated.")
