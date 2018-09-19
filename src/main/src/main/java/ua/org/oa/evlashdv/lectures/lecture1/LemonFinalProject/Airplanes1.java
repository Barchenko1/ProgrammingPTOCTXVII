package ua.org.oa.evlashdv.lectures.lecture1.LemonFinalProject;

import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Airplanes;
import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.DBWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Airplanes1 {
    private String  name;
    private String  type;
    private String developer;
    private String country;
    private String mass;
    private String speed;
    private String distance;
    private String length;
    private String height;
    private String wingSpan;
    private String windArea;
    private String  motor;
    private String team;

    public Airplanes1() {
    }

    public Airplanes1(String name, String type, String developer, String country, String mass, String speed, String distance, String length, String height, String wingSpan, String windArea, String motor, String team) {
        this.name = name;
        this.type = type;
        this.developer = developer;
        this.country = country;
        this.mass = mass;
        this.speed = speed;
        this.distance = distance;
        this.length = length;
        this.height = height;
        this.wingSpan = wingSpan;
        this.windArea = windArea;
        this.motor = motor;
        this.team = team;
    }



    public static boolean createAiroplane(Airplanes1 airplanes){
        int result=15;
        try {
            DBWorker worker=new DBWorker();
            Statement statement=worker.getConnection().createStatement();
            String query="INSERT INTO airplanes1 (name, type, developer, country, mass, speed, distance, length, height, wingSpan, wingArea, motor, team)" +
                    "VALUES ("+"'"+airplanes.getName()+"'"+", "+"'"+airplanes.getType()+"'"+", "+"'"+airplanes.getDeveloper()+"'"+", "+"'"+airplanes.getCountry()+"'"+", "+"'"+airplanes.getMass()+"'"+", "+"'"+airplanes.getSpeed()+"'"+", "+"'"+airplanes.getDistance()+"'"+", "+"'"+airplanes.getLength()+"'"+", "+"'"+airplanes.getHeight()+"'"+", "+"'"+airplanes.getWingSpan()+"'"+", "+"'"+airplanes.getWindArea()+"'"+", "+"'"+airplanes.getMotor()+"'"+", "+"'"+airplanes.getTeam()+"'"+");";


            result=statement.executeUpdate(query);
            statement.close();
            worker.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result!=15;
    }

    public static Airplanes1 getAiroplanes(String  name){
        DBWorker worker=new DBWorker();
        Airplanes1 airplane= new Airplanes1();
        String query="select * from airplanes1 WHERE name=";
        try {
            Statement statement=worker.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query+"'"+name+"'");
            while (resultSet.next()){
                airplane.setName(resultSet.getString("name"));
                airplane.setType(resultSet.getString("type"));
                airplane.setDeveloper(resultSet.getString("developer"));
                airplane.setCountry(resultSet.getString("country"));
                airplane.setMass(resultSet.getString("mass"));
                airplane.setSpeed(resultSet.getString("speed"));
                airplane.setDistance(resultSet.getString("distance"));
                airplane.setLength(resultSet.getString("length"));
                airplane.setHeight(resultSet.getString("height"));
                airplane.setWingSpan(resultSet.getString("wingSpan"));
                airplane.setWindArea(resultSet.getString("wingArea"));
                airplane.setMotor(resultSet.getString("motor"));
                airplane.setTeam(resultSet.getString("team"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airplane;
    }

    public static boolean updateAirplanes(Airplanes1 airplanes){
        int result=15;
        DBWorker worker=new DBWorker();
        String query="UPDATE airplanes1 SET type='"+airplanes.getType()+"', developer='"+airplanes.getDeveloper()+"', country='"+airplanes.getCountry()+"', mass='"+airplanes.getMass()+"', speed='"+airplanes.getSpeed()+"', distance='"+airplanes.getDistance()+"', length='"+airplanes.getLength()+"', height='"+airplanes.getHeight()+"', wingSpan='"+airplanes.getWingSpan()+"', wingArea='"+airplanes.getWindArea()+"', motor='"+airplanes.getMotor()+"', team='"+airplanes.getTeam()+"' WHERE name='"+airplanes.getName()+"';";
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

    public static boolean deleteAirplanes(String name){
        int result=15;
        DBWorker worker=new DBWorker();
        String query="DELETE FROM airplanes1 WHERE name='"+name+"'";
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

    public static ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Airplanes[] selectAllAirplanes(){
        ArrayList<Airplanes> airplanesList=new ArrayList<ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Airplanes>();
        DBWorker worker=new DBWorker();
        String query="SELECT * FROM airplanes1";
        try {
            Statement statement=worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Airplanes airplane=new ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Airplanes();
                airplane.setName(resultSet.getString("name"));
                airplane.setType(resultSet.getString("type"));
                airplane.setDeveloper(resultSet.getString("developer"));
                airplane.setCountry(resultSet.getString("country"));
                airplane.setMass(resultSet.getInt("mass"));
                airplane.setSpeed(resultSet.getInt("speed"));
                airplane.setDistance(resultSet.getInt("distance"));
                airplane.setLength(resultSet.getDouble("length"));
                airplane.setHeight(resultSet.getDouble("height"));
                airplane.setWingSpan(resultSet.getDouble("wingSpan"));
                airplane.setWindArea(resultSet.getDouble("wingArea"));
                airplane.setMotor(resultSet.getString("motor"));
                airplane.setTeam(resultSet.getInt("team"));
                airplanesList.add(airplane);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Airplanes[] airplanesArray=new ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Airplanes[airplanesList.size()];
        airplanesList.toArray(airplanesArray);
        return airplanesArray;
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

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
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

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName()+"{name: "+name+", type: "+type+", developer: "+developer+", country: "+country+", mass: "+mass+", speed: "+speed+", distance:"+distance+", length: "+length+", height: "+height+", wingSpan: "+wingSpan+", windArea: "+windArea+", motor: "+motor+", team: "+team+"}";
    }
}
