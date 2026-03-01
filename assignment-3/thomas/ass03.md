# Assignment 3 – Exceptions

- Provide a comprehensive and detailed description of the difference between exception handling in Java and Python.

- Provide code examples illustrating such differences.

- In case none of the team members is familiar with Python, a different language could be used, e.g., JavaScript, Rust or C#

> Thomas

>> I have started Assignment 3. It calls for examining the differences between exception handling in Java and Python. 

>> I identified that there is a difference in that Python contains two fields to store a reference to the Exception that that caused the current Exception (if shuch a cause exists). These fields are __context__ and __cause__. 
The __context__ is set automatically, while the __cause__ is set by using the as clause after the "raise" statement. In java, there is only a cause, accessed by using "getCause()" and it must be set when creating the Exception by passing the causing exception in as an argument to the constructor. I have attached code demonstrating this.

>> I would also like to point out that Python does not distinguish between "checked" and "uncheck" exceptions. This essentially means that all exceptions in Python are unchecked, and when raised cause the program to exit unless handled.
