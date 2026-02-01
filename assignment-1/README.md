
# Assignment 1

Consider the code in Assignment1.java:

1. Translate the Java code into Python (in case none of the team members is
familiar with Python, a different language could be used, e.g., JavaScript).
2. Verify whether the same behavior will be observed using the translated
code.
3. In case the behaviors differ, explain why

https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals-java.lang.Object-

**equals**

`public boolean equals(Object obj)`

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
See Also:
    hashCode(), HashMap


### Behavior of Assignment1.java vs  Assignment1.py vs Assignment1.rs

| java  | python | rust  | why different                                                              |
|-------|--------|-------|----------------------------------------------------------------------------|
| true  | true   | N/A   |                                                                            |
| false | false  | N/A   |                                                                            |
| false | false  | N/A   |                                                                            |
| true  | true   | N/A   |                                                                            |
| false | true   | N/A   | `v.__eq__(u)` falls back to `u.__eq__(v)`. explained in code comment further |
| false | false  | N/A   |                                                                            |
| false | false  | N/A   |                                                                            |



## Links

https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals-java.lang.Object-
