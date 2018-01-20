/*FailCreate ломается в конструкторе*/

package _5_java7;

public class FailCreate implements AutoCloseable {
    private String msg;
    public FailCreate(String msg) {
        this.msg = msg;
        System.err.println("new: " + msg);
        throw new Error(msg);
    }
    public void close() throws Exception {
        System.err.println("close: " + msg);
    }
}
