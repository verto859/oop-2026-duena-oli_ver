import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOError;

import static org.junit.Assert.*;
import org.junit.Test;

import com.sun.net.httpserver.Authenticator;

public class MainTest {
    @Test
    public void testMainOutput() {
      try {
        Main.main(new String[] {});
        Main.main(new String[] {});

        File createdFile = new File("hello.txt");

        assertTrue(createdFile.exists());

        FileInputStream fis = new FileInputStream(createdFile);

        int buff;
        String out = "";

        while ((buff = fis.read()) != -1) {
          out += (char)buff;
        }

        fis.close();

        assertEquals("I am CS!\n", out);
      } catch (Exception e) {
        fail("Failed to create the file");
      }
    }
}