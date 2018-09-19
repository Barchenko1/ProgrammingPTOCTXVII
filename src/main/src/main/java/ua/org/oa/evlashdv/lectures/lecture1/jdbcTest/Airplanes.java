package ua.org.oa.evlashdv.lectures.lecture1.jdbcTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Airplanes {
    private int id;
    private String  name;
    private String  type;
    private String developer;
    private String country;
    private int mass;
    private int speed;
    private int distance;
    private double length;
    private double height;
    private double wingSpan;
    private double windArea;
    private String  motor;
    private int team;

    public Airplanes() {
    }

    public Airplanes(String name, String type, String developer, String country, int mass, int speed, int distance, double length, double height, double wingSpan, double windArea, String motor, int team) {
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

    public Airplanes(int id, String name, String type, String developer, String country, int mass, int speed, int distance, double length, double height, double wingSpan, double windArea, String motor, int team) {
        this.id = id;
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

    public static boolean createAiroplane(Airplanes airplanes){
        int result=15;
        try {
            DBWorker worker=new DBWorker();
            Statement statement=worker.getConnection().createStatement();
            String query="INSERT INTO airplanes (id, name, type, developer, country, mass, speed, distance, length, height, wingSpan, wingArea, motor, team)" +
                    "VALUES ("+"'"+airplanes.getId()+"'"+", "+"'"+airplanes.getName()+"'"+", "+"'"+airplanes.getType()+"'"+", "+"'"+airplanes.getDeveloper()+"'"+", "+"'"+airplanes.getCountry()+"'"+", "+"'"+airplanes.getMass()+"'"+", "+"'"+airplanes.getSpeed()+"'"+", "+"'"+airplanes.getDistance()+"'"+", "+"'"+airplanes.getLength()+"'"+", "+"'"+airplanes.getHeight()+"'"+", "+"'"+airplanes.getWingSpan()+"'"+", "+"'"+airplanes.getWindArea()+"'"+", "+"'"+airplanes.getMotor()+"'"+", "+"'"+airplanes.getTeam()+"'"+");";

            if (airplanes.getId()!=0){
                query="INSERT INTO airplanes (id, name, type, developer, country, mass, speed, distance, length, height, wingSpan, wingArea, motor, team)" +
                        "VALUES ("+"'"+airplanes.getId()+"'"+", "+"'"+airplanes.getName()+"'"+", "+"'"+airplanes.getType()+"'"+", "+"'"+airplanes.getDeveloper()+"'"+", "+"'"+airplanes.getCountry()+"'"+", "+"'"+airplanes.getMass()+"'"+", "+"'"+airplanes.getSpeed()+"'"+", "+"'"+airplanes.getDistance()+"'"+", "+"'"+airplanes.getLength()+"'"+", "+"'"+airplanes.getHeight()+"'"+", "+"'"+airplanes.getWingSpan()+"'"+", "+"'"+airplanes.getWindArea()+"'"+", "+"'"+airplanes.getMotor()+"'"+", "+"'"+airplanes.getTeam()+"'"+");";

            }
                result=statement.executeUpdate(query);
            statement.close();
            worker.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result!=15;
    }

    public static Airplanes getAiroplanes(String  name){
        DBWorker worker=new DBWorker();
        Airplanes airplane=new Airplanes();
        String query="select * from airplanes WHERE name=";
        try {
            Statement statement=worker.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query+"'"+name+"'");
            while (resultSet.next()){
                airplane.setId(resultSet.getInt("id"));
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
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airplane;
    }

    public static boolean updateAirplanes(Airplanes airplanes){
        int result=15;
        DBWorker worker=new DBWorker();
        String query="UPDATE airplanes SET id='"+airplanes.getId()+"', type='"+airplanes.getType()+"', developer='"+airplanes.getDeveloper()+"', country='"+airplanes.getCountry()+"', mass='"+airplanes.getMass()+"', speed='"+airplanes.getSpeed()+"', distance='"+airplanes.getDistance()+"', length='"+airplanes.getLength()+"', height='"+airplanes.getHeight()+"', wingSpan='"+airplanes.getWingSpan()+"', wingArea='"+airplanes.getWindArea()+"', motor='"+airplanes.getMotor()+"', team='"+airplanes.getTeam()+"' WHERE name='"+airplanes.getName()+"';";
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
        String query="DELETE FROM airplanes WHERE name='"+name+"'";
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

    public static Airplanes[] selectAllAirplanes(){
        List<Airplanes> airplanesList=new ArrayList<Airplanes>();
        DBWorker worker=new DBWorker();
        String query="SELECT * FROM airplanes";
        try {
            Statement statement=worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Airplanes airplane=new Airplanes();
                airplane.setId(resultSet.getInt("id"));
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
        Airplanes [] airplanesArray=new Airplanes[airplanesList.size()];
        airplanesList.toArray(airplanesArray);
        return airplanesArray;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }

    public double getWindArea() {
        return windArea;
    }

    public void setWindArea(double windArea) {
        this.windArea = windArea;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName()+"{id: "+id+",name: "+name+", type: "+type+", developer: "+developer+", country: "+country+", mass: "+mass+", speed: "+speed+", distance:"+distance+", length: "+length+", height: "+height+", wingSpan: "+wingSpan+", windArea: "+windArea+", motor: "+motor+", team: "+team+"}";
    }
}
