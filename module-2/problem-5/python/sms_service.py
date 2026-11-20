class SmsService:
    def send_sms(self, message: str, phone_number: str):
        print(f"Sending SMS: {message} to {phone_number}")
