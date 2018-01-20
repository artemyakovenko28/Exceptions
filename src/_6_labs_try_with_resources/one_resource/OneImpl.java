package _6_labs_try_with_resources.one_resource;

import _6_labs_try_with_resources.AutoCloseableFactory;
import _6_labs_try_with_resources.TryBody;

public class OneImpl {

    public static void call(AutoCloseableFactory factory, TryBody body) throws Throwable {
        // --- create A ---
        AutoCloseable resource = factory.create();

        // --- run body ---
        try {
            body.runBody();
        } catch (Throwable bodyEx) {
            try {
                resource.close();
            } catch (Throwable closeEx) {
                bodyEx.addSuppressed(closeEx);
                throw bodyEx;
            }
            throw bodyEx;
        }

        // --- close ---
        resource.close();
    }
}
