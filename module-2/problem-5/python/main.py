from notification_manager import NotificationManager
from sms_service import SmsService

if __name__ == "__main__":
    sms_service = SmsService()
    manager = NotificationManager(sms_service)
    manager.send_notification("Hello from DIP Lesson!", "123-456-7890")
