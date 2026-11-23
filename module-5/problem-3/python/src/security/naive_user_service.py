import sqlite3
from dataclasses import dataclass

@dataclass
class User:
    user_id: str
    username: str
    email: str

class NaiveUserService:
    def __init__(self, db_connection: sqlite3.Connection):
        self.conn = db_connection

    def get_user_by_id(self, user_id: str):
        """
        Fetches a user by their ID.
        Note: This is a naive implementation intended for educational purposes.
        """
        cursor = self.conn.cursor()
        
        # FIXED: Using parameterized queries to prevent SQL Injection.
        query = "SELECT id, username, email FROM users WHERE id = ?"
        
        print(f"Executing query: {query} with parameter: {user_id}")
        
        cursor.execute(query, (user_id,))
        row = cursor.fetchone()
        
        if row:
            return User(user_id=row[0], username=row[1], email=row[2])
        return None
