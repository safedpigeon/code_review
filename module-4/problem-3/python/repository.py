import sqlite3

class ProductRepository:
    def __init__(self):
        # Use an in-memory database for a runnable example
        self.connection = sqlite3.connect(":memory:")
        self._setup_db()

    def _setup_db(self):
        cursor = self.connection.cursor()
        cursor.execute("CREATE TABLE products (id INTEGER, name TEXT, price REAL)")
        cursor.execute("INSERT INTO products VALUES (1, 'Laptop', 1200.0)")
        cursor.execute("INSERT INTO products VALUES (2, 'Mouse', 25.0)")
        cursor.execute("INSERT INTO products VALUES (3, 'Keyboard', 75.0)")
        self.connection.commit()

    def get_all_products_cursor(self):
        print("[Repo] Fetching raw cursor from SQLite...")
        # LEAK: Returning the sqlite3.Cursor object directly
        return self.connection.execute("SELECT * FROM products")
