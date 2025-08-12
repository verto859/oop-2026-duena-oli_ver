// Now that we know what's the idea of encapsulation.
// Let us explore these access modifiers starting with `public` modifer
public class Main {
    public static void main(String[] args) {
        Car civic = new Car();
        // Assign make and model values to our object
        civic.make = "Honda";
        civic.model = "Civic";
    }
}

class Car {
    public String make;
    // apply the correct modifer
    ??? String model;

    public Car() {
        System.out.println("A car is created.");
    }

}
