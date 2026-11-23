class UserRepository:
    def __init__(self):
        self._database = {}
        self._id_counter = 1

    def save(self, user):
        if user.id is None:
            user.id = self._id_counter
            self._id_counter += 1
        
        self._database[user.id] = user
        print(f"User saved to database: {user.name}")

    def find_by_id(self, user_id):
        return self._database.get(user_id)

    def delete(self, user):
        if user.id in self._database:
            del self._database[user.id]
            print(f"User deleted from database: {user.name}")
