import sqlite3
from security.naive_user_service import NaiveUserService

def setup_db():
    conn = sqlite3.connect(":memory:")
    cursor = conn.cursor()
    cursor.execute("CREATE TABLE users (id TEXT, username TEXT, email TEXT)")
    cursor.execute("INSERT INTO users VALUES ('1', 'alice', 'alice@example.com')")
    cursor.execute("INSERT INTO users VALUES ('2', 'bob', 'bob@example.com')")
    conn.commit()
    return conn

def test_functional():
    conn = setup_db()
    service = NaiveUserService(conn)
    
    # Test basic functionality
    user = service.get_user_by_id('1')
    print(f"Expected: User(user_id='1', username='alice', email='alice@example.com'), Got: {user}")
    assert user is not None and user.username == 'alice'
    
    # Demonstrate vulnerability (SQL Injection)
    # This input should bypass the ID check and potentially return the first user or all users
    # if the query were different, but here it'll just be an invalid ID unless we inject ' OR '1'='1
    malicious_id = "' OR '1'='1"
    user_vuln = service.get_user_by_id(malicious_id)
    print(f"Malicious input: {malicious_id}, Got: {user_vuln}")
    assert user_vuln is not None # Should return a user because of the injection

if __name__ == "__main__":
    test_functional()
    print("Functional tests passed (including vulnerability demonstration)!")
