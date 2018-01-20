/*Suppressed exceptions*/

package _5_java7;

public class App05 {
    public static void main(String[] args) {
        Error ex = new Error("A");
        ex.addSuppressed(new Error("B"));
        ex.addSuppressed(new Error("C"));
        ex.addSuppressed(new Error("D"));
        throw ex;
    }
}
