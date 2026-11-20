from notification import EmailNotification, SmsNotification, PushNotification

class NotificationFactory:
    _creators = {
        "EMAIL": EmailNotification,
        "SMS": SmsNotification,
        "PUSH": PushNotification
    }

    @staticmethod
    def create_notification(notification_type: str):
        creator = NotificationFactory._creators.get(notification_type.upper())
        if not creator:
            raise ValueError(f"Unknown notification type: {notification_type}")
        return creator()
