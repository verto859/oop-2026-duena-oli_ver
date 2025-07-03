package behavioral.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LoginSystem system = new LoginSystem();
        system.login();
    }
}

interface Listener {
    void update(int token);
}

class EmailNotifier implements Listener {
    @Override
    public void update(int token) {
        System.out.println("[EMAIL] Your OTP is " + token);
    }
}

class SMSNotifier implements Listener {
    @Override
    public void update(int token) {
        System.out.println("[SMS] Your OTP is " + token);
    }
}

class EventManager {
    private Map<Listener, Listener> subscribers = new HashMap<>();

    public void subscribe(Listener subscriber) {
        subscribers.put(subscriber, subscriber);
    }

    public void unsubscribe(Listener subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifyAllSubscribers(int data) {
        for (Listener listener : subscribers.values()) {
            listener.update(data);
        }
    }
}

class LoginSystem {
    private EventManager eventManager;

    public LoginSystem() {
        eventManager = new EventManager();
        eventManager.subscribe(new EmailNotifier());
        eventManager.subscribe(new SMSNotifier());
    }

    public void login() {
        int otp = new Random().nextInt(900000) + 100000; // 6-digit OTP
        eventManager.notifyAllSubscribers(otp);
    }
}
