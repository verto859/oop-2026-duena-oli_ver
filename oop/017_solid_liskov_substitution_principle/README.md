# Liskov Substitution Principle

**Definition (Barbara Liskov, 1987)**
> Subtypes must be substitutable for their base types without altering the correctness of the program.

## BAD

```java
class User {
    public void login(String username, String password) {
        // login logic
    }
}

class GuestUser extends User {
    @Override
    public void login(String username, String password) {
        throw new UnsupportedOperationException("Guests cannot log in.");
    }
}
```

## GOOD

```java
interface User {
    void accessSystem();
}

class RegisteredUser implements User {
    public void accessSystem() { /* login */ }
}

class GuestUser implements User {
    public void accessSystem() { /* limited access */ }
}
```
