import datetime
import re

class OrderManager:
    """
    The God Class - Handles every aspect of the order lifecycle.
    """

    def process_order(self, order_id, user_email, items, credit_card_details):
        print(f"Processing order {order_id}...")

        # 1. Validation Logic
        if not items or len(items) == 0:
            raise ValueError("Order must contain at least one item.")
        
        if not re.match(r"[^@]+@[^@]+\.[^@]+", user_email):
            raise ValueError("Invalid email address.")

        # 2. Payment Processing Logic
        print(f"Connecting to Payment Gateway for card {credit_card_details['number']}...")
        # Simulate payment API call
        payment_success = True 
        if not payment_success:
            raise Exception("Payment failed!")
        print("Payment processed successfully.")

        # 3. Inventory Management Logic
        for item in items:
            print(f"Updating inventory for item {item['id']}: reducing stock by {item['quantity']}.")
            # Simulate DB call: UPDATE inventory SET stock = stock - qty WHERE id = item_id

        # 4. Shipping Calculation Logic
        shipping_cost = 0
        for item in items:
            shipping_cost += item['weight'] * 0.5
        print(f"Total shipping cost calculated: ${shipping_cost}")

        # 5. Notification Logic
        print(f"Connecting to Email Service...")
        print(f"Sending confirmation email to {user_email}: 'Your order {order_id} is confirmed!'")

        # 6. Audit Logging
        with open("order_logs.txt", "a") as log_file:
            log_file.write(f"[{datetime.datetime.now()}] Order {order_id} processed for {user_email}\n")

        print("Order processing completed successfully.")

if __name__ == "__main__":
    manager = OrderManager()
    try:
        manager.process_order(
            order_id="ORD-123",
            user_email="student@example.com",
            items=[{"id": 1, "quantity": 2, "weight": 1.5}],
            credit_card_details={"number": "1234-5678-9012-3456"}
        )
    except Exception as e:
        print(f"Error: {e}")
