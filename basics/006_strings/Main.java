public class Main {
  public static void main(String[] args) {
    String message1 = "Hello";
    String message2 = "World";

    int num1 = 29;

    String finalMessage = message1 + message2;

    String finalMessageWithNum = finalMessage + num1;

    System.out.println(finalMessageWithNum); // <-- using `+` operator for string concat
   
    // `format` is a utility function to format a string using locale, or format and 
    // additional parameters
    System.out.println(String.format("%s%s%d", message1, message2, num1));


    String greet = "Hello!";
    String visitor = "John";

    // Format `greet` and `visitor` using `String.format` function to display
    //    Hello! John
    String formalGreeting = String.format("{%s %s}", greet, visitor);

    System.out.println(formalGreeting);
  } 
}
