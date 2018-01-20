package _6_labs_try_with_resources.three_resources;

import _6_labs_try_with_resources.AutoCloseableFactory;
import _6_labs_try_with_resources.TryBody;

public class ThreeTWR {
    public static void call(AutoCloseableFactory factoryA,
                            AutoCloseableFactory factoryB,
                            AutoCloseableFactory factoryC,
                            TryBody body) throws Throwable {

        try (AutoCloseable resourceA = factoryA.create();
             AutoCloseable resourceB = factoryB.create();
             AutoCloseable resourceC = factoryC.create()) {
            body.runBody();
        }
    }
}
