package ua.org.oa.evlashdv.lectures.lecture1.lecture8b;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String URL="jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME="root";
    private static final String PASSWORD="878988qqq";
    private static final String SQL_CREATE="CREATE TABLE IF NOT EXISTS movie(id int AUTO_INCREMENT primary key, title VARCHAR(30), description VARCHAR (30), duration INT)";
    private static final String SQL_INSERT="INSERT INTO movie(title,description,duration) VALUES(?,?,?)";
    private static final String SQL_READ="SELECT * FROM human";

    public static void main(String[] args) {
        Movie movie=new Movie("Titanic","Good film",150);
        System.out.println(movie);
        try (Connection connection=DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            Statement statement=connection.createStatement();
            statement.execute(SQL_CREATE);
            addMovie(connection,movie);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(movie);
    }

    private static void addMovie(Connection connection, Movie movie) {
        try (PreparedStatement statement=connection.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1,movie.getTitle());
            statement.setString(2,movie.getDescription());
            statement.setInt(3,movie.getDuration());
            statement.executeUpdate();
            ResultSet rs=statement.getGeneratedKeys();
            if (rs.next()){
                movie.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

