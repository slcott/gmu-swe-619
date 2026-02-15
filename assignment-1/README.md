# SWE619, Spring 2026, Assignment 1

### Group 1
|**Group members**|
|---|
| Scott Riccardelli |
| Thomas Robinson |
| Quan Nguyen |

Consider the code in Assignment1.java:

1. Translate the Java code into Python (in case none of the team members is
familiar with Python, a different language could be used, e.g., JavaScript).
2. Verify whether the same behavior will be observed using the translated
code.
3. In case the behaviors differ, explain why
    
    hashCode(), HashMap

### Behavior of Assignment in java, python, rust and swift

| Test Case                                                | Java   | Python | Rust   | Swift  | Why Different                                                                                             |
|----------------------------------------------------------|--------|--------|--------|--------|-----------------------------------------------------------------------------------------------------------|
| 1. `u.equals(u)` (u is `User("Student1")`)                 | true   | true   | true   | true   |                                                                                                           |
| 2. `u.equals(null)` (u is `User("Student1")`)              | false  | false  | false  | N/A    | Swift: Cannot compare `User` with `nil` directly. Type system prevents this.                              |
| 3. `u.equals("Student1")` (u is `User("Student1")`)        | false  | false  | false  | N/A    | Swift: Cannot compare `User` with `String` directly. Type system prevents this.                           |
| 4. `u.equals(v)` (u is User, v is SpecialUser)           | true   | true   | true   | false  | Swift: Enum cases are distinct types. Default `Equatable` is symmetric.                                   |
| 5. `v.equals(u)` (v is SpecialUser, u is User)           | false  | true   | false  | false  | Python: `v.__eq__(u)` returns `NotImplemented`, falls back to `u.__eq__(v)`.                              |
| 6. `v.equals(u)` (u is `User("Student1")`, v is User(nil)) | false  | false  | false  | false  |                                                                                                           |
| 7. `u.equals(v)` (u is `User("Student1")`, v is User(nil)) | false  | false  | false  | false  |                                                                                                           |

For python case 5, python has an interesting behavior.
<!--This is explained by a model search by the following:-->
> When the object on the left is the parent and the object on the right is a subclass, Python actually prioritizes the subclass. 
<!--It suspects the child might have more specific comparison logic.-->

- Python calls `special_user.__eq__(user)`.
- Inside `SpecialUser.__eq__`, the code checks `isinstance(user, SpecialUser)`, which is False because a base User is not a SpecialUser.
- SpecialUser returns NotImplemented.
- Fallback: Python now goes back to the left side and calls user.__eq__(special_user).
- Inside User.__eq__, it checks isinstance(special_user, User), which is True because A SpecialUser is an instance of User.
- It compares the names and returns True or False.

The comparison can be made more strict by using `type()` instead of `instanceof()` which is used for polymorphism. 

Since swift and Rust are categorized as systems programming languages, they use strict typing and case classes which is different than python. 

---
## Oracle Java Doc of Object `equals()`

https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals-java.lang.Object

```
public boolean equals(Object obj)

Indicates whether some other object is "equal to" this one.

The equals method implements an equivalence relation on non-null object references:
* It is reflexive: for any non-null reference value x, x.equals(x) should return true.
* It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
* It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
* It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified. 
* For any non-null reference value x, x.equals(null) should return false. 

The equals method for class Object implements the most discriminating possible equivalence relation on objects; that is, for any non-null reference values x and y, this method returns true if and only if x and y refer to the same object (x == y has the value true).

Note that it is generally necessary to override the hashCode method whenever this method is overridden, so as to maintain the general contract for the hashCode method, which states that equal objects must have equal hash codes.

Parameters:
    obj - the reference object with which to compare.
Returns:
    true if this object is the same as the obj argument; false otherwise.
```
