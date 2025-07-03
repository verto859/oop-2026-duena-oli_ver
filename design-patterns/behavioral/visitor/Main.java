package behavioral.visitor;

public class Main {
    public static void main(String[] args) {
        Visitor calculator = new CalculatorVisitor();

        Shape circle = new Circle(200);
        Shape rectangle = new Rectangle(200, 400);

        System.out.println("Circle: " + circle.calculate(calculator));
        System.out.println("Rectangle: " + rectangle.calculate(calculator));
    }
}

interface Visitor {
    double visitCircle(Circle circle);
    double visitRectangle(Rectangle rectangle);
}

abstract class Shape {
    public abstract double calculate(Visitor visitor);
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculate(Visitor visitor) {
        return visitor.visitCircle(this);
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculate(Visitor visitor) {
        return visitor.visitRectangle(this);
    }
}

class CalculatorVisitor implements Visitor {
    @Override
    public double visitCircle(Circle circle) {
        return Math.PI * Math.pow(circle.radius, 2);
    }

    @Override
    public double visitRectangle(Rectangle rectangle) {
        return rectangle.width * rectangle.height;
    }
}


