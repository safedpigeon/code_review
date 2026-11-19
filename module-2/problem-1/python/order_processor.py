class OrderProcessor:
    def process_order(self, order):
        # 1. Validation
        if not order.items:
            raise ValueError("Order must have at least one item")
        print("Order validated.")

        # 2. Calculation
        total = sum(item['price'] * item['quantity'] for item in order.items)
        tax = total * 0.15 # 15% tax
        final_amount = total + tax
        print(f"Total calculated: {final_amount}")

        # 3. Persistence
        print(f"Saving order to database... Order ID: {order.order_id}")
        # Mock DB save

        # 4. Notification
        print(f"Sending confirmation email to: {order.customer_email}")
        # Mock email send

class Order:
    def __init__(self, order_id, customer_email, items):
        self.order_id = order_id
        self.customer_email = customer_email
        self.items = items

if __name__ == "__main__":
    items = [
        {'name': 'Laptop', 'price': 1200.0, 'quantity': 1},
        {'name': 'Mouse', 'price': 25.0, 'quantity': 2}
    ]
    order = Order("ORD-123", "customer@example.com", items)
    processor = OrderProcessor()
    processor.process_order(order)
