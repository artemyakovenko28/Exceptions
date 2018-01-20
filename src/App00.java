public class App00 {
    public static void main(String[] args) {
        System.err.println(0);
        try {
            System.err.println(1);
            if (true) throw new Error();
        } finally {
            System.err.println(2);
        }
        System.err.println(3);
        System.out.println();
        Error ex = new Error("A");
    }
}
