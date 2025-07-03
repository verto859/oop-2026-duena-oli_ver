package behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Browser chrome = new Browser();

        chrome.visit("https://www.google.com");
        chrome.visit("https://collegeofmaryimmaculate.edu.ph");

        System.out.println(chrome.goBack());
    }
}

class Memento {
    String url;

    public Memento(String url) {
        this.url = url;
    }

    String getState() {
        return this.url;
    }
}

class Originator {
    String url;

    public void setState(String url) {
        this.url = url;
    }

    public Memento save() {
        return new Memento(this.url);
    }
}

class Browser {
    private final List<Memento> history = new ArrayList<>();
    private final Originator originator = new Originator();

    public void visit(String url) {
        this.originator.setState(url);

        this.history.add(this.originator.save());
    }

    public String goBack() {
        int index = this.history.size() - 2;

        if (index < 0)
            return null;

        return this.history.get(index).getState();
    }
}
