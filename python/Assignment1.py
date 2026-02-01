from special_user import SpecialUser
from user import User

if __name__ == "__main__":
    # It is reflexive: for any non-null reference value x, x.equals(x) should return true.
    u = User("Student1")
    print(u.__eq__(u)) # True
    print(u == u) # True
    print()

    # For any non-null reference value x, x.equals(null) should return false.
    u = User("Student1")
    print(u.__eq__(None)) # False -> NotImplemented
    print(u is None) # False
    print()

    u = User("Student1")
    print(u.__eq__("Student1")) # False -> NotImplemented
    print(u == "Student1") # False
    print()

    u = User("Student1")
    v = SpecialUser("Student1", 5)
    print(u.__eq__(v)) # True
    # calls v.__eq__(u) because v is a subclass and has more specific logic to make comparisons, but then since it
    # returns NotImplemented it falls back to u.__eq__(v)
    print(u == v) # False -> True.
    print(v.__eq__(u)) # False -> NotImplemented. there is no fallback because .__eq__ was called directly
    print(v == u) # False -> True
    print()

    # does not raise an exception
    u = User("Student1")
    v = User(None)
    print(v.__eq__(u)) # False
    print(v == u) # False
    print()

    #
    u = User("Student1")
    v = User(None)
    print(u.__eq__(v)) # False
    print(u == v) # False
    print()
