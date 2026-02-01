class User: Equatable {
    private var name: String? // allows nil

    init(_ name: String?) {
        self.name = name
    }

    static func == (lhs: User, rhs: User) -> Bool {
        return lhs.equals(rhs)
    }

    func equals(_ obj: Any?) -> Bool {
        print("User equals")
        guard let other = obj as? User else { return false }
        return self.name == other.name
    }
}

class SpecialUser: User {
    private var id: Int

    init(_ name: String?, _ id: Int) {
        self.id = id
        super.init(name)
    }

    override func equals(_ obj: Any?) -> Bool {
        print("SpecialUser equals")
        guard let other = obj as? SpecialUser else { return false }
        return super.equals(obj) && (self.id == other.id)
    }
}

// Main
var u: User
var v: User

// u = User("Student1")
// print(u.equals(u))
// print()

// u = User("Student1")
// print(u.equals(nil))
// print()

// u = User("Student1")
// print(u.equals("Student1"))
// print()

u = User("Student1")
v = SpecialUser("Student1", 5)
print(u == v)
print(v == u)
print()

u = User("Student1")
v = User(nil)
print(v.equals(u))
print()

u = User("Student1")
v = User(nil)
print(u.equals(v))
print()
