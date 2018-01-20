package _6_labs_try_with_resources.one_resource;

import _6_labs_try_with_resources.AutoCloseableFactory;
import _6_labs_try_with_resources.TryBody;

public class OneTWR {
    public static void call(AutoCloseableFactory factory, TryBody body) throws Throwable {
        try (AutoCloseable resource = factory.create()) {
            body.runBody();
        }
    }
}
