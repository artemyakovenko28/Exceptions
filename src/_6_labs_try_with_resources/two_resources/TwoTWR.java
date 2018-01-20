package _6_labs_try_with_resources.two_resources;

import _6_labs_try_with_resources.AutoCloseableFactory;
import _6_labs_try_with_resources.TryBody;

public class TwoTWR {
    public static void call(AutoCloseableFactory factoryA,
                            AutoCloseableFactory factoryB,
                            TryBody body) throws Throwable {

        try (AutoCloseable resourceA = factoryA.create();
             AutoCloseable resourceB = factoryB.create()) {
            body.runBody();
        }
    }
}
