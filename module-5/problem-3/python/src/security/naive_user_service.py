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
        
        # VULNERABILITY: SQL Injection via f-string formatting.
        # Common mistake for beginners who are not aware of parameterized queries.
        query = f"SELECT id, username, email FROM users WHERE id = '{user_id}'"
        
        print(f"Executing query: {query}")
        
        cursor.execute(query)
        row = cursor.fetchone()
        
        if row:
            return User(user_id=row[0], username=row[1], email=row[2])
        return None
