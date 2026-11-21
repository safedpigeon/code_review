class DatabaseManager:
    def __init__(self):
        print("Connecting to database...")
        self.connection_string = "mysql://localhost:3306/mydb"

    def execute_query(self, query):
        print(f"Executing query: {query} using connection {self.connection_string}")
