class User:
    _database = {}
    _id_counter = 1

    def __init__(self, name, email):
        self.id = None
        self.name = name
        self.email = email

    # Active Record Methods - The Anti-pattern
    def save(self):
        if self.id is None:
            self.id = User._id_counter
            User._id_counter += 1
        
        User._database[self.id] = self
        print(f"User saved to database: {self.name}")

    @classmethod
    def find_by_id(cls, user_id):
        return cls._database.get(user_id)

    def delete(self):
        if self.id in User._database:
            del User._database[self.id]
            print(f"User deleted from database: {self.name}")
