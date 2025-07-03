package behavioral.command;

public class Main {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();

        Command add2 = new AddButton(receiver, 2);
        Command sub1 = new SubtractButton(receiver, 1);

        System.out.println("Counter = " + receiver.getCounter());
        add2.execute();
        System.out.println("Counter = " + receiver.getCounter());
        sub1.execute();
        System.out.println("Counter = " + receiver.getCounter());
    }
}

interface Command {
    void execute();
}

// Concrete Command for Addition
class AddButton implements Command {
    private final Receiver receiver;
    private final int value;

    public AddButton(Receiver receiver, int value) {
        this.receiver = receiver;
        this.value = value;
    }

    @Override
    public void execute() {
        receiver.increment(value);
    }
}

// Concrete Command for Subtraction
class SubtractButton implements Command {
    private final Receiver receiver;
    private final int value;

    public SubtractButton(Receiver receiver, int value) {
        this.receiver = receiver;
        this.value = value;
    }

    @Override
    public void execute() {
        receiver.decrement(value);
    }
}

// Receiver class that performs the actual logic
class Receiver {
    private int counter = 0;

    public void increment(int value) {
        counter += value;
    }

    public void decrement(int value) {
        counter -= value;
    }

    public int getCounter() {
        return counter;
    }
}
