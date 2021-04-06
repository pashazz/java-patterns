package io.github.pashazz.patterns.creational.singleton;


import io.github.pashazz.patterns.utils.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDateTime;

public class DatabaseSingleton {
    public static void main(String[] args) {
        // Measure time spent


        Singleton i1 = Singleton.getInstance();
        Singleton i2 = Singleton.getInstance();

        System.out.printf("%s == %s ? %s\n", i1, i2, i1 == i2);

        LocalDateTime start = LocalDateTime.now();
        Connection conn = i1.getConnection();
        LocalDateTime end = LocalDateTime.now();
        Duration dur = Duration.between(start, end);
        System.out.printf("Time spent: ");
        System.out.println(Utils.durationToString(dur));


        Statement st;

        try {
            st = conn.createStatement();
            int count = st.executeUpdate("CREATE TABLE address (id int, streetName varchar(20))");
            System.out.printf("Table created: %s\n", count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        start = LocalDateTime.now();
        Connection conn2 = i2.getConnection();
        end = LocalDateTime.now();
        dur = Duration.between(start, end);
        System.out.printf("Time spent: ");
        System.out.println(Utils.durationToString(dur));


        try {
            st = conn2.createStatement();
            var res = st.execute("SELECT * FROM address");
            System.out.printf("select executed: %s", res);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static class Singleton {
        // don't use thread caching, always return actual
        private static volatile Singleton INSTANCE = null;
        private static volatile Connection CONNECTION = null;

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

        public Connection getConnection() {
            if (CONNECTION == null) {
                synchronized (Singleton.class) {
                    if (CONNECTION == null) {
                        try {
                            CONNECTION = DriverManager.getConnection("jdbc:h2:~/dbsingleton",
                                    "sa", "");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
            }
            return CONNECTION;
        }
    }
}
