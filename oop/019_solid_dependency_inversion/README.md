# Dependency Inversion Principle

High-level modules should not depend on low-level modules.

## BAD
```java
class EmailService {
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}

class Notification {
    private EmailService emailService = new EmailService(); // hardcoded

    public void notifyUser(String msg) {
        emailService.send(msg);
    }
}
```

## GOOD

```java
interface MessageService {
    void send(String message);
}

class EmailService implements MessageService {
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}

class SMSService implements MessageService {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class Notification {
    private MessageService service;

    public Notification(MessageService service) {
        this.service = service; // injected
    }

    public void notifyUser(String msg) {
        service.send(msg);
    }
}

public class Main {
    public static void main(String[] args) {
        Notification emailNotif = new Notification(new EmailService());
        emailNotif.notifyUser("Welcome!");

        Notification smsNotif = new Notification(new SMSService());
        smsNotif.notifyUser("Your code is 1234.");
    }
}
```
