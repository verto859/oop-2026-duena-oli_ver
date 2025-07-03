package behavioral.mediator;

public class Main {
    public static void main(String[] args) {
        User juan = new User("Juan");
        User pedro = new User("Pedro");

        ChatSystem chat = new ChatSystem(new User[] { juan, pedro });

        juan.setMediator(chat);
        pedro.setMediator(chat);

        juan.send("Kamusta?");
        pedro.send("Mag-kano?");
    }
}

interface Mediator {
    void send(String message, User sender);
}

class ChatSystem implements Mediator {
    User[] subscribers;

    public ChatSystem(User[] subscribers) {
        this.subscribers = subscribers;
    }

    public void send(String message, User sender) {
        for (User user : subscribers) {
            if (user != sender) {
                user.receive(message, sender);
            }
        }
    }
}

class User {
    private String name;
    private Mediator mediator;

    public User(String name) {
        this.name = name;
    }

    public void receive(String message, User sender) {
        System.out.printf("%s received message \"%s\" from %s\n", this.getName(), message, sender.getName());
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void send(String message) {
        if (this.mediator != null) {
            this.mediator.send(message, this);
        }
    }

    public String getName() {
        return this.name;
    }
}
