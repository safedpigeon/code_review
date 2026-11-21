from notification_service import NotificationService

class NotificationManager:
    def __init__(self, notification_service: NotificationService):
        self.notification_service = notification_service

    def send_notification(self, message: str, destination: str):
        self.notification_service.send(message, destination)
