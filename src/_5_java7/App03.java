//try with resources

package _5_java7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class App03 {
    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream("d:/tmp-1.txt");
             FileOutputStream out = new FileOutputStream("d:/tmp-2")) {
            out.write(in.read());
            out.flush();
        }
    }
}
