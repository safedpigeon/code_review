from notification_factory import NotificationFactory

class NotificationService:
    def send_notification(self, notification_type: str, message: str):
        notification = NotificationFactory.create_notification(notification_type)
        notification.send(message)
