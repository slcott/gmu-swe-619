# Assignment 3 – Exceptions

- Provide a comprehensive and detailed description of the difference between exception handling in Java and Python.

- Provide code examples illustrating such differences.

- In case none of the team members is familiar with Python, a different language could be used, e.g., JavaScript, Rust or C#




## Java Exception Hierarchy

In Java, the exception hierarchy is rooted in the `Throwable` class. It branches into two main categories: Error (serious system-level problems) and Exception (conditions that an application might want to catch).

A critical distinction in Java is between Checked Exceptions (must be declared or handled) and Unchecked Exceptions (subclasses of `RuntimeException`).

### Java Throwable Hierarchy

```
Throwable
 ├── Error (Unchecked - Unrecoverable system issues)
 │    ├── AssertionError
 │    ├── LinkageError
 │    │    ├── BootstrapMethodError
 │    │    ├── ClassCircularityError
 │    │    ├── ClassFormatError
 │    │    ├── NoClassDefFoundError (Similar to Python ImportError)
 │    │    └── UnsatisfiedLinkError
 │    ├── VirtualMachineError
 │    │    ├── OutOfMemoryError (Python MemoryError)
 │    │    ├── StackOverflowError (Python RecursionError)
 │    │    └── InternalError
 │    └── ThreadDeath
 └── Exception
      ├── RuntimeException (Unchecked - Programming/Logic errors)
      │    ├── ArithmeticException (Python ArithmeticError)
      │    ├── ClassCastException (Similar to Python TypeError)
      │    ├── IllegalArgumentException (Python ValueError)
      │    │    └── NumberFormatException
      │    ├── IllegalStateException
      │    ├── IndexOutOfBoundsException (Python LookupError/IndexError)
      │    │    ├── ArrayIndexOutOfBoundsException
      │    │    └── StringIndexOutOfBoundsException
      │    ├── NullPointerException (Python AttributeError/NameError on None)
      │    ├── NoSuchElementException (Python StopIteration)
      │    ├── SecurityException
      │    └── BufferOverflowException / BufferUnderflowException
      └── Checked Exceptions (Must be handled or declared in `throws`)
           ├── IOException (Python OSError)
           │    ├── EOFException (Python EOFError)
           │    ├── FileNotFoundException (Python FileNotFoundError)
           │    ├── InterruptedIOException (Python InterruptedError)
           │    ├── SocketException (Python ConnectionError)
           │    │    ├── BindException
           │    │    ├── ConnectException (Python ConnectionRefusedError)
           │    │    └── PortUnreachableException
           │    └── UnknownHostException
           ├── ReflectiveOperationException
           │    ├── ClassNotFoundException (Python ImportError)
           │    ├── IllegalAccessException
           │    ├── NoSuchFieldException (Python AttributeError)
           │    └── NoSuchMethodException
           ├── InterruptedException
           ├── CloneNotSupportedException
           └── SQLException (And many other API-specific checked exceptions)
```

### Key Comparisons to Python:

1.  Logic vs. Environment: Java's `RuntimeException` is used for "logic errors" that should be prevented by the programmer (like `NullPointerException` or `IndexOutOfBoundsException`). Python uses `Exception` for almost everything.
2.  Errors: In Java, `Error` specifically denotes issues that a reasonable application should not try to catch (e.g., `OutOfMemoryError`). In Python, these are mostly just another branch of `BaseException`.
3.  Checked Exceptions: This is a unique Java concept. `IOException` and its subclasses are Checked, meaning the compiler forces you to use `try-catch` or a `throws` clause. Python has no equivalent; all Python exceptions are "unchecked."
4.  Syntax Errors: In Python, `SyntaxError` is a runtime exception (raised when importing or parsing). In Java, syntax errors are compile-time errors and don't exist in the exception hierarchy because the code won't even run.

### Python BaseException Hierarchy

```
BaseException
 ├── BaseExceptionGroup
 ├── GeneratorExit
 ├── KeyboardInterrupt
 ├── SystemExit
 └── Exception
      ├── ArithmeticError
      │    ├── FloatingPointError
      │    ├── OverflowError
      │    └── ZeroDivisionError
      ├── AssertionError
      ├── AttributeError
      ├── BufferError
      ├── EOFError
      ├── ExceptionGroup [BaseExceptionGroup]
      ├── ImportError
      │    └── ModuleNotFoundError
      ├── LookupError
      │    ├── IndexError
      │    └── KeyError
      ├── MemoryError
      ├── NameError
      │    └── UnboundLocalError
      ├── OSError
      │    ├── BlockingIOError
      │    ├── ChildProcessError
      │    ├── ConnectionError
      │    │    ├── BrokenPipeError
      │    │    ├── ConnectionAbortedError
      │    │    ├── ConnectionRefusedError
      │    │    └── ConnectionResetError
      │    ├── FileExistsError
      │    ├── FileNotFoundError
      │    ├── InterruptedError
      │    ├── IsADirectoryError
      │    ├── NotADirectoryError
      │    ├── PermissionError
      │    ├── ProcessLookupError
      │    └── TimeoutError
      ├── ReferenceError
      ├── RuntimeError
      │    ├── NotImplementedError
      │    ├── PythonFinalizationError
      │    └── RecursionError
      ├── StopAsyncIteration
      ├── StopIteration
      ├── SyntaxError
      │    └── IndentationError
      │         └── TabError
      ├── SystemError
      ├── TypeError
      ├── ValueError
      │    └── UnicodeError
      │         ├── UnicodeDecodeError
      │         ├── UnicodeEncodeError
      │         └── UnicodeTranslateError
      └── Warning
           ├── BytesWarning
           ├── DeprecationWarning
           ├── EncodingWarning
           ├── FutureWarning
           ├── ImportWarning
           ├── PendingDeprecationWarning
           ├── ResourceWarning
           ├── RuntimeWarning
           ├── SyntaxWarning
           ├── UnicodeWarning
           └── UserWarning
```



All python exceptions are unchecked.
Java has checked and unchecked exceptions.
This is similar to the original python design philosophy which lacks static code analysis.



Similar to java, python has exception chaining. 
```python
def get_some_data(key):
    try:
        # Lower-level abstraction
        data = sql_client.get_row(key)
    except ConnectionError as e:
        # Exception Translation + Chaining
        raise ServiceUnavailableError("Database is down") from e
```

```java
void get_some_data(String key) throws ServiceUnavailableError {
    try {
        // Lower-level abstraction
        data = sql_client.get_row(key);
    } catch (ConnectionException e) {
        // Exception Translation + Chaining
        throw new ServiceUnavailableError("Unable to get data", e);
    }
}
```
