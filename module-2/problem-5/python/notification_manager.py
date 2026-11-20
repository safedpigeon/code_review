from sms_service import SmsService

class NotificationManager:
    def __init__(self):
        # Tight coupling: NotificationManager creates its own dependency
        self.sms_service = SmsService()

    def send_notification(self, message: str, phone: str):
        self.sms_service.send_sms(message, phone)
