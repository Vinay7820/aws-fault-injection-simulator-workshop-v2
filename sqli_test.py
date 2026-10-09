import sqlite3

def get_user(username):
    conn = sqlite3.connect("test.db")
    cursor = conn.cursor()
    query = "SELECT * FROM users WHERE username = '" + username + "'"
    cursor.execute(query)
    return cursor.fetchall()

def main():
    result = get_user("admin")
    print(result)

if __name__ == "__main__":
    main()
