// To import a package in Java, we use `import` keyword followed by the
// package we want to use.
//
// Scanner is a utility class to scan text.
//
//      Scanner scanner = new Scanner(System.in);
// 
// In the example above, we're declaring a new instance of Scanner to
// parse the inputs from our input stream `System.in`.
//
// An instance of Scanner have multiple helper functions to read and 
// parse text from the input stream.
//
//      scanner.nextLine() <-- reads a string until a line feed `\n`
//      scanner.nextInt() <-- tries to parse the string to integer
//          would throw an exception if string could not be parsed

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // create a new instance of scanner
        Scanner scanner = Scanner(System.in);

        // Our prompt
        System.out.print("Enter Name: ");

        // Something is wrong here, fix it.
        Integer name = scanner.nextInt();

        // Greet our user.
        System.out.println("Hello, "  + name);
    }
}
