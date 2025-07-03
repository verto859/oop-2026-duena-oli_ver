package behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Product[] order = new Product[] {
                new Product("Milo", 20, 14),
                new Product("Bear Brand", 10, 10),
                new Product("Coke Sakto", 5, 18),
        };

        ProductsList iteratorExample = new ProductsList(order);

        for (Product p : iteratorExample) {
            System.out.printf("%s - %d x %.2f = %.2f\n", p.getName(), p.getQuantity(), p.getPrice(),
                    p.getQuantity() * p.getPrice());
        }
    }
}

class Product {
    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }
}

class ProductsList implements Iterable<Product> {
    private final Product[] products;

    public ProductsList(Product[] products) {
        this.products = products;
    }

    @Override
    public Iterator<Product> iterator() {
        return new Iterator<Product>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < products.length;
            }

            @Override
            public Product next() {
                return products[this.index++];
            }
        };
    }
}
