class UserService:
    def __init__(self, db):
        self.db = db

    def create_user(self, username):
        print(f"Creating user: {username}")
        # Using injected dependency
        self.db.execute_query(f"INSERT INTO users (name) VALUES ('{username}')")
