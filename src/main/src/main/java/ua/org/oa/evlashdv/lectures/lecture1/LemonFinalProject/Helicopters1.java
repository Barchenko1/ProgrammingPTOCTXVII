package ua.org.oa.evlashdv.lectures.lecture1.LemonFinalProject;


import ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.DBWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Helicopters1 {

    private String  name;
    private String  type;
    private String developer;
    private String country;
    private String mass;
    private String speed;
    private String distance;
    private String length;
    private String height;
    private String mainRotor;
    private String tailRotor;
    private String  motor;
    private String team;

    public Helicopters1() {

    }

    public Helicopters1(String name, String type, String developer, String country, String mass, String speed,String distance, String length, String height, String mainRotor, String tailRotor, String motor, String team) {

        this.name = name;
        this.type = type;
        this.developer = developer;
        this.country=country;
        this.mass = mass;
        this.speed = speed;
        this.distance = distance;
        this.length = length;
        this.height = height;
        this.mainRotor = mainRotor;
        this.tailRotor = tailRotor;
        this.motor = motor;
        this.team = team;
    }


    public static boolean createHelicopter(Helicopters1 helicopters){
        int result=15;
        try {
            DBWorker worker=new DBWorker();
            Statement statement=worker.getConnection().createStatement();
            String query="INSERT INTO helicopters1 (name, type, developer, country, mass, speed, distance, length, height, mainRotor, tailRotor, motor, team)" +
                    "VALUES ("+"'"+helicopters.getName()+"'"+", "+"'"+helicopters.getType()+"'"+", "+"'"+helicopters.getDeveloper()+"'"+", "+"'"+helicopters.getCountry()+"'"+", "+"'"+helicopters.getMass()+"'"+", "+"'"+helicopters.getSpeed()+"'"+", "+"'"+helicopters.getDistance()+"'"+", "+"'"+helicopters.getLength()+"'"+", "+"'"+helicopters.getHeight()+"'"+", "+"'"+helicopters.getMainRotor()+"'"+", "+"'"+helicopters.getTailRotor()+"'"+", "+"'"+helicopters.getMotor()+"'"+", "+"'"+helicopters.getTeam()+"'"+");";


            result=statement.executeUpdate(query);
            statement.close();
            worker.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result!=15;
    }

    public static Helicopters1 getHelicopters(String  name){
        DBWorker worker=new DBWorker();
        Helicopters1 helicopter=new Helicopters1();
        String query="select * from helicopters1 WHERE name=";
        try {
            Statement statement=worker.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query+"'"+name+"'");
            while (resultSet.next()){
                helicopter.setName(resultSet.getString("name"));
                helicopter.setType(resultSet.getString("type"));
                helicopter.setDeveloper(resultSet.getString("developer"));
                helicopter.setCountry(resultSet.getString("country"));
                helicopter.setMass(resultSet.getString("mass"));
                helicopter.setSpeed(resultSet.getString("speed"));
                helicopter.setDistance(resultSet.getString("distance"));
                helicopter.setLength(resultSet.getString("length"));
                helicopter.setHeight(resultSet.getString("height"));
                helicopter.setMainRotor(resultSet.getString("mainRotor"));
                helicopter.setTailRotor(resultSet.getString("tailRotor"));
                helicopter.setMotor(resultSet.getString("motor"));
                helicopter.setTeam(resultSet.getString("team"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return helicopter;
    }


    public static boolean updateHelicopters(Helicopters1 helicopters){
        int result=15;
        DBWorker worker=new DBWorker();
        String query="UPDATE helicopters1 SET type='"+helicopters.getType()+"', developer='"+helicopters.getDeveloper()+"', country='"+helicopters.getCountry()+"', mass='"+helicopters.getMass()+"', speed='"+helicopters.getSpeed()+"', distance='"+helicopters.getDistance()+"', length='"+helicopters.getLength()+"', height='"+helicopters.getHeight()+"', mainRotor='"+helicopters.getMainRotor()+"', tailRotor='"+helicopters.getTailRotor()+"', motor='"+helicopters.getMotor()+"', team='"+helicopters.getTeam()+"' WHERE name='"+helicopters.getName()+"';";
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

    public static boolean deleteHelicopters(String  name){
        int result=15;
        DBWorker worker=new DBWorker();
        String query="DELETE FROM helicopters1 WHERE name='"+name+"'";
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

    public static ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Helicopters[] selectAllHelicopters(){
        List<ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Helicopters> helicoptersList=new ArrayList<ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Helicopters>();
        DBWorker worker=new DBWorker();
        String query="SELECT * FROM helicopters1";
        try {
            Statement statement=worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Helicopters helicopter=new ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Helicopters();
                helicopter.setName(resultSet.getString("name"));
                helicopter.setType(resultSet.getString("type"));
                helicopter.setDeveloper(resultSet.getString("developer"));
                helicopter.setCountry(resultSet.getString("country"));
                helicopter.setMass(resultSet.getInt("mass"));
                helicopter.setSpeed(resultSet.getInt("speed"));
                helicopter.setDistance(resultSet.getInt("distance"));
                helicopter.setLength(resultSet.getDouble("length"));
                helicopter.setHeight(resultSet.getDouble("height"));
                helicopter.setMainRotor(resultSet.getDouble("mainRotor"));
                helicopter.setTailRotor(resultSet.getDouble("tailRotor"));
                helicopter.setMotor(resultSet.getString("motor"));
                helicopter.setTeam(resultSet.getInt("team"));
                helicoptersList.add(helicopter);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Helicopters[] helicoptersArray=new ua.org.oa.evlashdv.lectures.lecture1.jdbcTest.Helicopters[helicoptersList.size()];
        helicoptersList.toArray(helicoptersArray);
        return helicoptersArray;
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

    public String getMainRotor() {
        return mainRotor;
    }

    public void setMainRotor(String mainRotor) {
        this.mainRotor = mainRotor;
    }

    public String getTailRotor() {
        return tailRotor;
    }

    public void setTailRotor(String tailRotor) {
        this.tailRotor = tailRotor;
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
        return  getClass().getSimpleName()+"{name: "+name+", type: "+type+", developer: "+developer+", country: "+country+", mass: "+mass+", speed: "+speed+", distance: "+distance+", length: "+length+", height: "+height+", mainRotor: "+mainRotor+", tailRotor "+tailRotor+", motor: "+motor+", team: "+team+"}";
    }


}
