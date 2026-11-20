from notification import EmailNotification, SmsNotification, PushNotification

class NotificationService:
    def get_notification(self, notification_type: str):
        if notification_type.upper() == "EMAIL":
            return EmailNotification()
        elif notification_type.upper() == "SMS":
            return SmsNotification()
        elif notification_type.upper() == "PUSH":
            return PushNotification()
        else:
            raise ValueError(f"Unknown notification type: {notification_type}")

    def send_notification(self, notification_type: str, message: str):
        notification = self.get_notification(notification_type)
        notification.send(message)
