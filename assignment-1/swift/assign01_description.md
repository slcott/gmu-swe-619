## Consider the code in Assignment1.java:

1. Translate the Java code into Python (in case none of the team members is familiar with Python, a different language could be used, e.g., JavaScript).
2. Verify whether the same behavior will be observed using the translated code.
3. In case the behaviors differ, explain why.

## Comparison

| case                          | java                         | python (with `.__eq__()`) | Different? | Why |
| ----------------------------- | ---------------------------- | ---------------------------- | ---------- | --- |
| `u.equals(u);`                | true                         | True                         | No         | -   |
| `u.equals(null));`            | false                        | False                        | No         | -   |
| `u.equals("Student1"));`      | false                        | False                        | No         | -   |
| `u.equals(v)); v.equals(u));` | true, false `// No symmetry` | True, False `// No symmetry` | No         | -   |
| `v.equals(u));`               | false                        | False                        | No         | -   |
| `u.equals(v));`               | **NullPointerException**     | False                        | Yes        | java throws NPE because a null pointer was passed into the `equals()` method of `String`. In python, the expression became a comparison between the string `Student1` and `None`, which python evaluates to False. |

## More Comparisons

### 1. Python with `==`
| case                          | java                         | python (with `==` operator)  | Different? | Why |
| ----------------------------- | ---------------------------- | ---------------------------- | ---------- | --- |
| `u.equals(u);`                | true                         | True                         | No         | -   |
| `u.equals(null));`            | false                        | False                        | No         | -   |
| `u.equals("Student1"));`      | false                        | False                        | No         | -   |
| `u.equals(v)); v.equals(u));` | true, false `// No symmetry` | False, False `// !!`  | Yes        | with the `==` operator, python uses the `SpecialUser.__eq__()` for both comparisons `u==v` and `v==u`   |
| `v.equals(u));`               | false                        | False                        | No         | -   |
| `u.equals(v));`               | **NullPointerException**     | False                        | Yes        | java throws NPE because a null pointer was passed into the `equals()` method of `String`. In python, the expression became a comparison between the string `Student1` and `None`, which python evaluates to False. |

### 2. Swift

| case                          | java                         | Swift                        | Different? | Why |
| ----------------------------- | ---------------------------- | ---------------------------- | ---------- | --- |
| `u.equals(u);`                | true                         | true                         | No         | -   |
| `u.equals(null));`            | false                        | false                        | No         | -   |
| `u.equals("Student1"));`      | false                        | false                        | No         | -   |
| `u.equals(v)); v.equals(u));` | true, false `// No symmetry` | true, false                  | No         | -   |
| `v.equals(u));`               | false                        | false                        | No         | -   |
| `u.equals(v));`               | **NullPointerException**     | false                        | Yes        | The optional String `u.name` is not nil, so the comparison `u.name == nil`, and vice versa, equates to false|
