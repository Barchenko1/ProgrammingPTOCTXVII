package ua.org.oa.evlashdv.lectures.lecture1.practice.perfumery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDbtest {
    private static String URL="jdbc:mysql://localhost:3306/mydbtest";
    private static String NAME="root";
    private static String PASS="878988qqq";
    public static void main(String[] args) {
        try {

            Connection connection= DriverManager.getConnection(URL,NAME,PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
