from notification_service import NotificationService

class SmsService(NotificationService):
    def send(self, message: str, phone_number: str):
        print(f"Sending SMS: {message} to {phone_number}")
