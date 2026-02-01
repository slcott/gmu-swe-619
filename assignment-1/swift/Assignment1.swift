import Foundation

// In Swift, enums with associated values are a great way to model different
// but related kinds of data. This is often preferred over class inheritance
// for this type of data model.
enum User: Equatable {
    case regular(name: String?)
    case special(name: String?, id: Int)
}

// By conforming to the Equatable protocol, we get a standard implementation
// of the == operator. The compiler can synthesize this for us automatically
// for enums. This implementation is symmetric, meaning a == b is the same as b == a,
// which is the standard behavior in Swift.

// Main
var u: User
var v: User

print("--- Reflexive ---")
u = .regular(name: "Student1")
print(u == u) // true
print()

print("--- Comparison with nil (not applicable in the same way) ---")
// In Swift, you can't compare a User instance with nil directly.
// You would compare an Optional<User> to nil.
var optionalUser: User? = nil
print(optionalUser == nil) // true
print()

print("--- Comparison with String (not applicable) ---")
// You can't compare a User with a String. This is a good thing, as it's type-safe.
print()

print("--- Different kinds of users ---")
u = .regular(name: "Student1")
v = .special(name: "Student1", id: 5)
// This will be false, because they are different enum cases.
// This is different from the original Java/Python/non-idiomatic Swift versions.
print(u == v) // false
print(v == u) // false
print()

print("--- Same kind of user, different name ---")
u = .regular(name: "Student1")
v = .regular(name: "Student2")
print(u == v) // false
print()

print("--- Same kind of user, one with nil name ---")
u = .regular(name: "Student1")
v = .regular(name: nil)
print(u == v) // false
print()

print("--- Two nil-named users ---")
u = .regular(name: nil)
v = .regular(name: nil)
print(u == v) // true
print()
