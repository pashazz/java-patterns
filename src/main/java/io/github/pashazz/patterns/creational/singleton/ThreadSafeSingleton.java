package io.github.pashazz.patterns.creational.singleton;


public class ThreadSafeSingleton {
    public static void main(String[] args) {
        Singleton i1 = Singleton.getInstance();
        Singleton i2 = Singleton.getInstance();

        System.out.printf("%s == %s ? %s", i1, i2, i1 == i2);
    }

    private static class Singleton {
        // don't use thread caching, always return actual
        private static volatile Singleton INSTANCE = null;

        private Singleton() {
            if (INSTANCE != null) {
                throw new RuntimeException("use getInstance() to get an instance of Singleton");
            }
        }

        public static Singleton getInstance() {
            if (INSTANCE == null) {
                synchronized (Singleton.class) {
                    if (INSTANCE == null) { //the situation may have changed once we were waiting on lock
                        INSTANCE = new Singleton();
                    }
                }
            }
            return INSTANCE;
        }
    }
}
