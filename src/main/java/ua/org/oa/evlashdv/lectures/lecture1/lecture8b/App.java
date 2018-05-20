package ua.org.oa.evlashdv.lectures.lecture1.lecture8b;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String URL="jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME="root";
    private static final String PASSWORD="878988qqq";
    private static final String SQL_CREATE_HUMAN_TABLE="CREATE TABLE IF NOT EXISTS human(id int AUTO_INCREMENT primary key, name VARCHAR(30), age INT)";
    private static final String SQL_INSERT_HUMAN_TABLE="INSERT INTO human(name,age) VALUES(?,?)";
    private static final String SQL_READ_HUMAN_TABLE="SELECT * FROM human";

    public static void main(String[] args) {
        List<Human> humanList=new ArrayList<>();
        humanList.add(new Human("Vasya",25));
        humanList.add(new Human("Sveta",30));
        humanList.add(new Human("Misha",22));

        try (Connection connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);){
            Statement statement=connection.createStatement();
            statement.execute(SQL_CREATE_HUMAN_TABLE);
            readHumanToDB(connection).forEach(System.out::println);

            humanList.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Human> readHumanToDB(Connection connection){
        List<Human> humanList=new ArrayList<>();
        try (Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(SQL_READ_HUMAN_TABLE)){
            while (rs.next()){
                Human human=new Human();
                human.setId(rs.getInt("id"));
                human.setName(rs.getString("name"));
                human.setAge(rs.getInt("age"));
                humanList.add(human);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return humanList;
    }
    public static void addHumansToDB(Connection connection,List<Human> humanList){
        try (PreparedStatement preparedStatement=connection.prepareStatement(SQL_INSERT_HUMAN_TABLE,Statement.RETURN_GENERATED_KEYS);){
        for (Human human:humanList) {
            preparedStatement.setString(1,human.getName());
            preparedStatement.setInt(2,human.getAge());
            preparedStatement.executeUpdate();
            ResultSet rs=preparedStatement.getGeneratedKeys();
            if (rs.next()){
                human.setId(rs.getInt(1));
            }
            rs.close();
        }
        humanList.forEach(System.out::println);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}

