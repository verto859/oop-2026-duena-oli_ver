// An interface is a contract in Object-Oriented programming that defines
// a set of methods a class must implement without providing the implementation.
//
// A class can implement multiple interfaces. Unlike multi-level
// inheritance, introducing interfaces to codebase actually promotes flexibility
// and avoids the complexity associated with tight coupling when using deep
// inheritance.
//
// Here is an example.
//
// - A `Chalk` is a writing tool.
// - A `Pencil` is a writing tool and could be sharpen.
// - A `Marker` is a writing tool and could be refillable.
//
//
public class Main {
    public static void main(String[] args) {
        Chalk chalk = new Chalk();
        chalk.write("Hello World");

        Pencil pencil = new Pencil();
        pencil.write("Hello World");
        pencil.sharpen();

        Marker marker = new Marker();
        marker.write("Hello World");
        marker.refill();
    }
}

interface WritingTool {
    public void write(String text);
}

interface Sharpenable {
    public void sharpen();
}

interface Refillable {
    public void refill();
}

class Chalk implements WritingTool {
    public void write(String text) {
        System.out.println(text);
    }
}

class Pencil implements WritingTool, Sharpenable {
    public void write(String text) {
        System.out.println(text);
    }

    public void sharpen() {
        System.out.println("getting it sharp...");
    }
}

// @TODO: implement proper interfaces
class Marker implements ???, ??? {
    public void write(String text) {
        System.out.println(text);
    }

    public void refill() {
        System.out.println("ink refilled");
    }
}
