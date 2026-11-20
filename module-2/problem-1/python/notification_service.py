from models import Order

class NotificationService:
    def send_confirmation(self, order: Order):
        print(f"Sending confirmation email to: {order.customer_email}")
