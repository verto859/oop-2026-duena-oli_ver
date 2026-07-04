// In Java, `{}` are used to scope variables.
// Meaning a variable declared in a scope could only be access in that region.
//
//   public static void main(String[] args) {
//      {
//        int num = 10;
//
//        System.out.println("num = " + num);
//      }
//    }
//
//
//

public class Main {
  public static void main(String[] args) {
    {
      int num = 10;
    }

    // Move this inside the scope {} where num is defined
    System.out.println("num = " + num));
  }
}