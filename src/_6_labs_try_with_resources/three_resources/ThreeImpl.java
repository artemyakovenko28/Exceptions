package _6_labs_try_with_resources.three_resources;

import _6_labs_try_with_resources.AutoCloseableFactory;
import _6_labs_try_with_resources.TryBody;

public class ThreeImpl {
    public static void call(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB,
                            AutoCloseableFactory factoryC, TryBody body) throws Throwable {
        // --- create A ---
        AutoCloseable resourceA = factoryA.create();

        // --- create B ---
        AutoCloseable resourceB;
        try {
            resourceB = factoryB.create();
        } catch (Throwable createBEx) {
            //closeA
            try {
                resourceA.close();
            } catch (Throwable closeAEx) {
                createBEx.addSuppressed(closeAEx);
                throw createBEx;
            }
            throw createBEx;
        }

        // --- create C ---
        AutoCloseable resourceC;
        try {
            resourceC = factoryC.create();
        } catch (Throwable createCEx) {
            //closeB
            try {
                resourceB.close();
            } catch (Throwable closeBEx) {
                createCEx.addSuppressed(closeBEx);
                //closeA
                try {
                    resourceA.close();
                } catch (Throwable closeAEx) {
                    createCEx.addSuppressed(closeAEx);
                    throw createCEx;
                }
                throw createCEx;
            }
            //closeA
            try {
                resourceA.close();
            } catch (Throwable closeAEx) {
                createCEx.addSuppressed(closeAEx);
                throw createCEx;
            }
            throw createCEx;
        }

        // --- run body ---
        try {
            body.runBody();
        } catch (Throwable bodyEx) {
            //closeC
            try {
                resourceC.close();
            } catch (Throwable closeCEx) {
                bodyEx.addSuppressed(closeCEx);
                //closeB
                try {
                    resourceB.close();
                } catch (Throwable closeBEx) {
                    bodyEx.addSuppressed(closeBEx);
                    //close A
                    try {
                        resourceA.close();
                    } catch (Throwable closeAEx) {
                        bodyEx.addSuppressed(closeAEx);
                        throw bodyEx;
                    }
                    throw bodyEx;
                }
                throw bodyEx;
            }

            //closeB
            try {
                resourceB.close();
            } catch (Throwable closeBEx) {
                bodyEx.addSuppressed(closeBEx);
                //close A
                try {
                    resourceA.close();
                } catch (Throwable closeAEx) {
                    bodyEx.addSuppressed(closeAEx);
                    throw bodyEx;
                }
                throw bodyEx;
            }

            //close A
            try {
                resourceA.close();
            } catch (Throwable closeAEx) {
                bodyEx.addSuppressed(closeAEx);
                throw bodyEx;
            }
            throw bodyEx;
        }

        // --- close C ---
        try {
            resourceC.close();
        } catch (Throwable closeCEx) {
            //closeB
            try {
                resourceB.close();
            } catch (Throwable closeBEx) {
                closeCEx.addSuppressed(closeBEx);
                try {
                    //closeA
                    resourceA.close();
                } catch (Throwable closeAEx) {
                    closeCEx.addSuppressed(closeAEx);
                    throw closeCEx;
                }
                throw closeCEx;
            }
            throw closeCEx;
        }

        //--- close B ---
        try {
            resourceB.close();
        } catch (Throwable closeBEx) {
            //close A
            try {
                resourceC.close();
            } catch (Throwable closeAEx) {
                closeBEx.addSuppressed(closeAEx);
                throw closeBEx;
            }
            throw closeBEx;
        }

        // --- close C ---
        resourceA.close();
    }
}
