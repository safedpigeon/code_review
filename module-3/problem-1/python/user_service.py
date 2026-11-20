from database_manager import get_database_manager

class UserService:
    def create_user(self, username):
        print(f"Creating user: {username}")
        # Tight coupling to Singleton
        db = get_database_manager()
        db.execute_query(f"INSERT INTO users (name) VALUES ('{username}')")
