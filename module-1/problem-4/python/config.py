import os

class AppConfig:
    """
    Centralized configuration management for the application.
    Loads configurations from environment variables with sensible defaults.
    """
    def __init__(self):
        self.api_url = os.getenv("PAYMENT_API_URL", "https://api.payments.com/v1")
        self.api_key = os.getenv("PAYMENT_API_KEY", "default_secret_key")
        self.timeout = int(os.getenv("PAYMENT_TIMEOUT", "5000"))
