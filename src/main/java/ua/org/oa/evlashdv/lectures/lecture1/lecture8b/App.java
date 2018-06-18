package ua.org.oa.evlashdv.lectures.lecture1.lecture8b;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static final String SQL_CREATE_TABLE="CREATE TABLE IF NOT EXISTS movie(id int AUTO_INCREMENT primary key,title varchar(30),description varchar(30),duration int)";
    public static final String SQL_INSERT="INSERT INTO movie(title,description,duration)VALUES(?,?,?)";
    public static final String SQL_SELECT_ALL="SELECT * FROM movie";
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/test?useSSL=false";
        String user="root";
        String pass="878988qqq";
        List<Movie> movieList=new ArrayList<>();
        movieList.add(new Movie("Dracula","Horror",123));
        movieList.add(new Movie("Matrix","Fantasy",120));
        movieList.add(new Movie("Titanic","Drama",116));
        List<Movie>moviesFromDB = null;
        try (Connection connection= DriverManager.getConnection(url,user,pass);){
            Statement statement=connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            //saveMovie(movieList,connection);
            moviesFromDB=readAllMovies(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        movieList.forEach(System.out::println);
        System.out.println("`````````````````");
        moviesFromDB.forEach(System.out::println);
    }

    private static List<Movie> readAllMovies(Connection connection) {
        List<Movie> movieList=new ArrayList<>();
        try (Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery(SQL_SELECT_ALL)){
            Movie movie;
            while (rs.next()){
                movie=new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDescription(rs.getString("description"));
                movie.setDuration(rs.getInt("duration"));
                movieList.add(movie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movieList;
    }

    public static void saveMovie(List<Movie> movieList,Connection connection){
        try (PreparedStatement preparedStatement=connection.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS)){
            for (Movie movie:movieList){
                preparedStatement.setString(1,movie.getTitle());
                preparedStatement.setString(2,movie.getDescription());
                preparedStatement.setInt(3,movie.getDuration());
                System.out.println(preparedStatement.executeUpdate());
                ResultSet rs=preparedStatement.getGeneratedKeys();
                if (rs.next()){
                    movie.setId(rs.getInt(1));
                }
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
