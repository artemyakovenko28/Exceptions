//try with resources

package _5_java7;

public class App04 {
    public static void main(String[] args) {
        try (/* final */Ok x = new Ok("x");
             Ok y = new Ok("y")) {
            //System.err.println("body");
            throw new Error();
        }
    }
}
