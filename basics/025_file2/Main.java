// FileInputStream is a byte stream class in Java used for reading raw binary data (like images, audio, or PDFs)
// from a file, and you should use it when working with non-text files or when you need low-level byte-by-byte access
// to file data.
//
// For text files, it is ideal to use `FileInputStream` which is designed to work with text files.

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // @TODO: Use `readLinesWithBufferedReader` instead of `readLines`
        String[] lines = CustomFileReader.readLines("products.txt");
        ArrayList<Product> products = new ArrayList<>();

        for (String line : lines) {
            try {
                products.add(new Product(line));

                System.out.println("Added " + line);
            } catch (Exception e) {
                System.out.println("Skipping..." + line + e.getMessage());
            }
        }

        for (Product p : products) {
            System.out.println(p);
        }
    }
}

class CustomFileReader {
    public static String[] readLines(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        FileInputStream fis = null;

        try {
            File f = new File(filename);
            fis = new FileInputStream(f);

            int buff;
            String line = "";

            while ((buff = fis.read()) != -1) {
                char c = (char) buff;

                if (c == '\n') {
                    lines.add(line);
                    line = "";
                    continue;
                }

                line = line + String.valueOf(c);
            }

            // EOF
            lines.add(line);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                System.out.println("Could not close file" + e.getMessage());
            }
        }

        return lines.toArray(String[]::new);
    }

    public static String[] readLinesWithBufferedReader(String filename) {
        ArrayList<String> lines = new ArrayList<>();

        try{
            FileInputStream fis = new FileInputStream(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        return lines.toArray(String[]::new);
    }
}

class Product {
    private String id;
    private String brand;
    private String name;
    private double price = 0.0;

    public Product(String id, String brand, String name, double price) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public Product(String info) throws Exception {
        String[] details = info.split(",");

        if (details.length < 4) {
            throw new Exception("Invalid product information from String.");
        }

        try {
            this.price = Float.parseFloat(details[3]);
        } catch (Exception e) {
            throw new Exception("Invalid product price from String." + e.getMessage());
        }

        this.id = details[0];
        this.brand = details[1];
        this.name = details[2];
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s %s PHP %.2f", this.id, this.brand, this.name, this.price);
    }
}
