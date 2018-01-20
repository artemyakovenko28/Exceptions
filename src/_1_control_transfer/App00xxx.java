package _1_control_transfer;

public class App00xxx {
    public static void main(String[] args) {
        System.err.println("0>");
        try {
            f();
        } catch (RuntimeException e) {
            System.err.println("bad...");
        }
        System.err.println("0<");
    }

    private static void f() {
        System.err.println(" 1>");
        g();
        System.err.println(" 1<");
    }

    private static void g() {
        System.err.println("  2>");
        h();
        System.err.println("  2<");
    }

    private static void h() {
//        return;
        throw new RuntimeException();
    }
}
