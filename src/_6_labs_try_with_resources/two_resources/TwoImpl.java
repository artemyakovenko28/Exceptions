package _6_labs_try_with_resources.two_resources;

import _6_labs_try_with_resources.AutoCloseableFactory;
import _6_labs_try_with_resources.TryBody;

public class TwoImpl {
    public static void call(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB, TryBody body) throws Throwable {
        // --- create A ---
        AutoCloseable resourceA = factoryA.create();

        //create B
        AutoCloseable resourceB = null;
        try {
            resourceB = factoryB.create();
        } catch (Throwable createBEx) {
            //close A
            try {
                resourceA.close();
            } catch (Throwable closeAEx) {
                createBEx.addSuppressed(closeAEx);
                //throw createBEx;
            }
            //throw createBEx;
        }

        // --- run body ---
        try {
            body.runBody();
        } catch (Throwable bodyEx) {
            //closeB
            try {
                resourceB.close();
            } catch (Throwable closeBEx) {
                bodyEx.addSuppressed(closeBEx);
                //closeA
                try {
                    resourceA.close();
                } catch (Throwable closeAEx) {
                    bodyEx.addSuppressed(closeAEx);
                    //throw bodyEx;
                }
                //throw bodyEx;
            }
            //closeA
            try {
                resourceA.close();
            } catch (Throwable closeAEx) {
                bodyEx.addSuppressed(closeAEx);
                throw bodyEx;
            }
            throw bodyEx;
        }

        // --- close B ---
        try {
            resourceB.close();
        } catch (Throwable closeBEx) {
            //closeA
            try {
                resourceA.close();
            } catch(Throwable closeAEx) {
                closeBEx.addSuppressed(closeAEx);
                throw closeAEx;
            }
            throw closeBEx;
        }

        // --- close A ---
        resourceA.close();
    }
}
