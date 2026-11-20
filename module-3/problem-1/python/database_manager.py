class DatabaseManager:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            print("Connecting to database...")
            cls._instance = super(DatabaseManager, cls).__new__(cls)
            cls._instance.connection_string = "mysql://localhost:3306/mydb"
        return cls._instance

    def execute_query(self, query):
        print(f"Executing query: {query} using connection {self.connection_string}")

def get_database_manager():
    return DatabaseManager()
