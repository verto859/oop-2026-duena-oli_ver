# Open/Closed Principle

## BAD

```java
enum NotificationType {
  EMAIL,
  SMS,
}

class Notification {
  private String subject;
  private String content;

  public Notification(String subject, String content) {
    this.subject = subject;
    this.content = content;
  }

  public void send(NotificationType type) {
    if (type == NotificationType.EMAIL) {
      // Sending via email
    } else if (type == NotificationType.SMS) {
      // Sending via SMS
    }
  }
}
```

## GOOD

```java
interface Notifier {
    void send(Notification notification);
}

class EmailNotifier implements Notifier {
    public void send(Notification notification) {
        System.out.println("Sending EMAIL: " + notification.getSubject());
    }
}

class SmsNotifier implements Notifier {
    public void send(Notification notification) {
        System.out.println("Sending SMS: " + notification.getSubject());
    }
}

class Notification {
    private String subject;
    private String content;

    public Notification(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public String getSubject() { return subject; }
    public String getContent() { return content; }
}
```
