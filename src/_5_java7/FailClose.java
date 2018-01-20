/*FailClose ломается при вызове метода close()*/

package _5_java7;

public class FailClose {
    private String msg;
    public FailClose(String msg) {
        this.msg = msg;
        System.err.println("new: " + msg);
    }
    public void close() throws Exception {
        System.err.println("close: " + msg);
        throw new Error(msg);
    }
}
