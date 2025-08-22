# Interface Segregation

Clients should not be forced to depend on interfaces they do not use.

## BAD

```java
interface User {
    void viewContent();
    void editContent();
    void publishContent();
    void deleteContent();
}
```

> A `Reader` class should not be forced to implement `deleteContent` or `editContent`

## GOOD

```java
interface Reader {
    void viewContent();
}

interface Editor extends Reader {
    void editContent();
}

interface Admin extends Editor {
    void publishContent();
    void deleteContent();
}
```
