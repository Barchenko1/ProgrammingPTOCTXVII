package ua.org.oa.evlashdv.lectures.lecture1.LemonFinalProject;

import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.DBWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Gliders1 {

    private String name;
    private String type;
    private String developer;
    private String country;
    private String mass;
    private String length;
    private String height;
    private String wingSpan;
    private String windArea;
    private String team;

    public Gliders1() {
    }

    public Gliders1(String name, String type, String developer, String country, String  mass, String length, String height, String wingSpan, String windArea, String team) {
        this.name = name;
        this.type = type;
        this.developer = developer;
        this.country = country;
        this.mass = mass;
        this.length = length;
        this.height = height;
        this.wingSpan = wingSpan;
        this.windArea = windArea;
        this.team = team;
    }

    public static boolean createGlider(Gliders1 gliders){
        int result=15;
        try {
            DBWorker worker=new DBWorker();
            Statement statement=worker.getConnection().createStatement();
            String query="INSERT INTO gliders1 (name, type, developer, country, mass, length, height, wingSpan, wingArea, team)" +
                    "VALUES ("+"'"+gliders.getName()+"'"+", "+"'"+gliders.getType()+"'"+", "+"'"+gliders.getDeveloper()+"'"+", "+"'"+gliders.getCountry()+"'"+", "+"'"+gliders.getMass()+"'"+", "+"'"+gliders.getLength()+"'"+", "+"'"+gliders.getHeight()+"'"+", "+"'"+gliders.getWingSpan()+"'"+", "+"'"+gliders.getWindArea()+"'"+", "+"'"+gliders.getTeam()+"'"+");";

            result=statement.executeUpdate(query);
            statement.close();
            worker.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result!=15;
    }


    public static Gliders1 getGliders(String  name){
        DBWorker worker=new DBWorker();
        Gliders1 gliders1= new Gliders1();
        String query="select * from gliders1 WHERE name=";
        try {
            Statement statement=worker.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query+"'"+name+"'");
            while (resultSet.next()){
                gliders1.setName(resultSet.getString("name"));
                gliders1.setType(resultSet.getString("type"));
                gliders1.setDeveloper(resultSet.getString("developer"));
                gliders1.setCountry(resultSet.getString("country"));
                gliders1.setMass(resultSet.getString("mass"));
                gliders1.setLength(resultSet.getString("length"));
                gliders1.setHeight(resultSet.getString("height"));
                gliders1.setWingSpan(resultSet.getString("wingSpan"));
                gliders1.setWindArea(resultSet.getString("wingArea"));
                gliders1.setTeam(resultSet.getString("team"));
            }
            resultSet.close();
            statement.close();
            worker.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gliders1;
    }


    public static boolean updateGliders(Gliders1 gliders){
        int result=15;
        DBWorker worker=new DBWorker();
        String query="UPDATE gliders1 SET type='"+gliders.getType()+"', developer='"+gliders.getDeveloper()+"', country='"+gliders.getCountry()+"', mass='"+gliders.getMass()+"', length='"+gliders.getLength()+"', height='"+gliders.getHeight()+"', wingSpan='"+gliders.getWingSpan()+"', wingArea='"+gliders.getWindArea()+"', team='"+gliders.getTeam()+"' WHERE name='"+gliders.getName()+"';";
        try {
            Statement statement=worker.getConnection().createStatement();
            result=statement.executeUpdate(query);
            statement.close();
            worker.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result!=15;
    }

    public static boolean deleteGliders(String  name){
        int result=15;
        DBWorker worker=new DBWorker();
        String query="DELETE FROM gliders1 WHERE name='"+name+"'";
        try {
            Statement statement=worker.getConnection().createStatement();
            result=statement.executeUpdate(query);
            statement.close();
            worker.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result!=15;
    }

    public static ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Gliders[] selectAllGliders(){
        ArrayList<ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Gliders> glidersArrayList=new ArrayList<ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Gliders>();
        DBWorker worker=new DBWorker();
        String query="SELECT * FROM gliders1";
        try {
            Statement statement=worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Gliders glider=new ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Gliders();
                glider.setName(resultSet.getString("name"));
                glider.setType(resultSet.getString("type"));
                glider.setDeveloper(resultSet.getString("developer"));
                glider.setCountry(resultSet.getString("country"));
                glider.setMass(resultSet.getInt("mass"));
                glider.setLength(resultSet.getDouble("length"));
                glider.setHeight(resultSet.getDouble("height"));
                glider.setTeam(resultSet.getInt("team"));
                glidersArrayList.add(glider);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Gliders[] glidersArray=new ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Gliders[glidersArrayList.size()];
        glidersArrayList.toArray(glidersArray);
        return glidersArray;
    }

    public static ArrayList selectAllGlidersArrayList(){
        ArrayList<ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Gliders> glidersArrayList=new ArrayList<>();
        DBWorker worker=new DBWorker();
        String query="SELECT * FROM gliders1";
        try {
            Statement statement=worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Gliders glider=new ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Gliders();
                glider.setName(resultSet.getString("name"));
                glider.setType(resultSet.getString("type"));
                glider.setDeveloper(resultSet.getString("developer"));
                glider.setCountry(resultSet.getString("country"));
                glider.setMass(resultSet.getInt("mass"));
                glider.setLength(resultSet.getDouble("length"));
                glider.setHeight(resultSet.getDouble("height"));
                glider.setTeam(resultSet.getInt("team"));
                glidersArrayList.add(glider);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return glidersArrayList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(String wingSpan) {
        this.wingSpan = wingSpan;
    }

    public String getWindArea() {
        return windArea;
    }

    public void setWindArea(String windArea) {
        this.windArea = windArea;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName()+"{name: "+name+", type: "+type+", developer: "+developer+", country: "+country+", mass: "+mass+", length: "+length+", height: "+height+", wingspan: "+wingSpan+", windArea: "+windArea+", team: "+team+"}";
    }

}

