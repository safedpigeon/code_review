from user import User

class UserService:
    def __init__(self):
        self.user_db = {
            "1": User("1", "Alice"),
            "2": User("2", "Bob")
        }

    def get_user(self, user_id):
        try:
            if user_id is None:
                raise Exception("ID cannot be None")
            if user_id not in self.user_db:
                print("User not found!")
                return None # Naive return
            return self.user_db[user_id]
        except Exception as e:
            print(f"Error occurred: {e}") # Naive error handling
            return None

    def update_user_name(self, user_id, new_name):
        try:
            user = self.get_user(user_id)
            if user is None:
                raise Exception("Cannot update user: User not found")
            print(f"Updating user {user_id} to {new_name}")
        except Exception as e:
            print(f"Error updating user: {e}")
