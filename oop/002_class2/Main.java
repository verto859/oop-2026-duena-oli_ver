// Constructor is a special method that is executed upon instantiation of an object.
// It is often used to set initial values for members.
//
// To declare a constructor in Java, we must create a public function having
// the same name as the class:
//
//    class Account {
//        public Account() {
//            System.out.println("Account created");
//        }
//    }
//

public class Main {
    public static void main(String[] args) {
        Car civic = new Car("Honda", "Civic");
    }
}

class Car {
    String make;
    String model;

    // TODO our constructor
    public Car(String make, String model) {
        this.make = make; // `this` refer to the instance of class (object).
        this.model = model;
        System.out.printf("A new %s %s is created\n", make, model);
    }
}
