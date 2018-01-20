/*Multi-catch*/

package _5_java7;

import java.io.IOException;
import java.sql.SQLException;

public class App01 {
    public static void main(String[] args) throws IOException, SQLException {
        try {
            if (System.nanoTime() % 2 == 0) {
                throw new IOException();
            } else {
                throw new SQLException();
            }
        } catch (IOException | SQLException e) {
            throw e;
        }
    }
}
