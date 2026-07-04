// A class is like a blueprint. It is a template used to create
// objects.
// An object is an instance of a class. It represents a specific entity that
// has attributes and methods.
//
// It is important to note that in Java, we could only define one specific
// public class in a file -- `Main` class in this case.

public class Main {
    public static void main(String[] args) {
        // Instantiate a new instance of Student class
        Student Juan = new Student();
        // in this instance, we could call `sayHi` method
        Juan.sayHi();
    }
}

// Here is another example of a class that contains a method `sayHi`
// to print a message in the screen.
class Student {
    void sayHi() {
        // TODO: print `Hi!` here
        System.out.println("Hi!");
    }
}