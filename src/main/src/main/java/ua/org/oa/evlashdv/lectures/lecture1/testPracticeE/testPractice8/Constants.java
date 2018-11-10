package ua.org.oa.evlashdv.lectures.lecture1.testPracticeE.testPractice8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Constants {
    private static String URL="jdbc:mysql://localhost:3306/mydbtest";
    private static String NAME="root";
    private static String PASS="878988qqq";
    public static Connection getConnection() {
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL,NAME,PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
