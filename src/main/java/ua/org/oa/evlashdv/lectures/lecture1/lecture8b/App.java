package ua.org.oa.evlashdv.lectures.lecture1.lecture8b;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String URL="jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME="root";
    private static final String PASSWORD="878988qqq";
    private static final String SQL_CREATE="CREATE TABLE IF NOT EXISTS movie(id int AUTO_INCREMENT primary key, title VARCHAR(30), description VARCHAR (30), dutation INT)";
    private static final String SQL_INSERT_HUMAN_TABLE="INSERT INTO human(name,age) VALUES(?,?)";
    private static final String SQL_READ_HUMAN_TABLE="SELECT * FROM human";

    public static void main(String[] args) {
        try (Connection connection=DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            Statement statement=connection.createStatement();
            statement.execute(SQL_CREATE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

