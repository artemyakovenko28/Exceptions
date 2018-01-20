//Закрытие экземпляров FileInputStream и FileOutputStream при
//возникновении поломки без try with resources (до Java 7)

package _5_java7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class App02 {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("d:/tmp-1.txt");
            out = new FileOutputStream("d:/tmp-2.txt");
            out.write(in.read());
            out.flush();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        }
    }
}
