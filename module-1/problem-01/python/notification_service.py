class NotificationService:
    def send_confirmation_email(self, user_email, order_id):
        print(f"Connecting to Email Service...")
        print(f"Sending confirmation email to {user_email}: 'Your order {order_id} is confirmed!'")
