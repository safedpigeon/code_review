class Database:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(Database, cls).__new__(cls)
            cls._instance.inventory = {"PROD1": 10}
            cls._instance.orders = []
        return cls._instance

db = Database()
