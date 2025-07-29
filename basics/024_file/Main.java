// There are a lot of possible ways to create or read files in Java.
// For this lesson, we'll take a look at `FileOutputStream` for writing
// and `FileInputStream` along with buffering techniques for reading text content.

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    try {
      // Create a file representation
      File f = new File("hello.txt");

      // A file output stream is an output stream for writing data to a File or to a FileDescriptor.
      FileOutputStream fs = new FileOutputStream(f, true); // @TODO: disable append

      // Ensure that `BufferWriter` is wrapped with try clause before writing
      try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fs))) {
        bw.write("Hello World!\n"); // @TODO: replace with `I am CS!\n`
        bw.close();
      }
    } catch (IOError e) {
      // FileOutputStream might throw an IOError when trying to write the file
      System.err.println("File create error" + e.getMessage());
    }
  }
}