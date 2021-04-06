package io.github.pashazz.patterns.creational.singleton;


public class LazySingleton {
    public static void main(String[] args) {
        Singleton i1 = Singleton.getInstance();
        Singleton i2 = Singleton.getInstance();

        System.out.printf("%s == %s ? %s", i1, i2, i1 == i2);
    }

    private static class Singleton {
        private static Singleton INSTANCE = null;

        private Singleton() {
        }

        public static Singleton getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new Singleton();
            }
            return INSTANCE;
        }
    }
}
