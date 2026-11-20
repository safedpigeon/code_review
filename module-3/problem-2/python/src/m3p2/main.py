from notification_service import NotificationService

def main():
    service = NotificationService()
    
    service.send_notification("EMAIL", "Hello via Email!")
    service.send_notification("SMS", "Hello via SMS!")
    service.send_notification("PUSH", "Hello via Push!")

if __name__ == "__main__":
    main()
