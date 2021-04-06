package io.github.pashazz.patterns.creational.singleton;


public class NaiveSingleton {
    public static void main(String[] args) {
        Singleton i1 = Singleton.getInstance();
        Singleton i2 = Singleton.getInstance();

        System.out.printf("%s == %s ? %s", i1, i2, i1 == i2);
    }

    private static class Singleton {
        private static final Singleton INSTANCE = new Singleton();

        private Singleton() {}

        public static Singleton getInstance() {
            return INSTANCE;
        }
    }
}
