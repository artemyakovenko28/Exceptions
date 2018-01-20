package _6_labs_try_with_resources;

public interface AutoCloseableFactory {

    public AutoCloseable create() throws Throwable;
}
