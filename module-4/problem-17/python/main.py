import sqlite3

class User:
    def __init__(self, id, name):
        self.id = id
        self.name = name

class Post:
    def __init__(self, id, user_id, title):
        self.id = id
        self.user_id = user_id
        self.title = title

class UserRepository:
    def __init__(self, db_connection):
        self.conn = db_connection

    def get_all_users(self):
        print("Executing: SELECT * FROM users")
        cursor = self.conn.cursor()
        cursor.execute("SELECT id, name FROM users")
        return [User(row[0], row[1]) for row in cursor.fetchall()]

class PostRepository:
    def __init__(self, db_connection):
        self.conn = db_connection

    def get_posts_by_user_id(self, user_id):
        print(f"Executing: SELECT * FROM posts WHERE user_id = {user_id}")
        cursor = self.conn.cursor()
        cursor.execute("SELECT id, user_id, title FROM posts WHERE user_id = ?", (user_id,))
        return [Post(row[0], row[1], row[2]) for row in cursor.fetchall()]

class UserService:
    def __init__(self, user_repo, post_repo):
        self.user_repo = user_repo
        self.post_repo = post_repo

    def get_users_with_posts(self):
        users = self.user_repo.get_all_users()
        result = []
        for user in users:
            posts = self.post_repo.get_posts_by_user_id(user.id)
            result.append({"user": user.name, "posts": [p.title for p in posts]})
        return result

def setup_database():
    conn = sqlite3.connect(":memory:")
    cursor = conn.cursor()
    cursor.execute("CREATE TABLE users (id INTEGER PRIMARY KEY, name TEXT)")
    cursor.execute("CREATE TABLE posts (id INTEGER PRIMARY KEY, user_id INTEGER, title TEXT)")
    
    users = [(1, "Alice"), (2, "Bob"), (3, "Charlie")]
    posts = [
        (1, 1, "Alice's First Post"), (2, 1, "Alice's Second Post"),
        (3, 2, "Bob's Only Post"),
        (4, 3, "Charlie's First Post"), (5, 3, "Charlie's Second Post"), (6, 3, "Charlie's Third Post")
    ]
    
    cursor.executemany("INSERT INTO users VALUES (?, ?)", users)
    cursor.executemany("INSERT INTO posts VALUES (?, ?, ?)", posts)
    conn.commit()
    return conn

if __name__ == "__main__":
    db_conn = setup_database()
    user_repo = UserRepository(db_conn)
    post_repo = PostRepository(db_conn)
    user_service = UserService(user_repo, post_repo)
    
    print("Fetching users and their posts...")
    data = user_service.get_users_with_posts()
    for entry in data:
        print(f"User: {entry['user']}, Posts: {entry['posts']}")
