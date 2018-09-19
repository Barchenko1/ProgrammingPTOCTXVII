package ua.org.oa.evlashdv.lectures.lecture1.jdbcTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Helicopters {

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
    private double mainRotor;
    private double tailRotor;
    private String  motor;
    private int team;

    public Helicopters() {

    }

    public Helicopters(int id, String name, String type, String developer, String country, int mass, int speed,int distance, double length, double height, double mainRotor, double tailRotor, String motor, int team) {
        this.id = id;
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

    public Helicopters(String name, String type, String developer, String country, int mass, int speed, int distance, double length, double height, double mainRotor, double tailRotor, String motor, int team) {
        this.name = name;
        this.type = type;
        this.developer = developer;
        this.country = country;
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

    public static boolean createHelicopter(Helicopters helicopters){
        int result=15;
        try {
            DBWorker worker=new DBWorker();
            Statement statement=worker.getConnection().createStatement();
            String query="INSERT INTO helicopters (id, name, type, developer, country, mass, speed, distance, length, height, mainRotor, tailRotor, motor, team)" +
                    "VALUES ("+"'"+helicopters.getId()+"'"+", "+"'"+helicopters.getName()+"'"+", "+"'"+helicopters.getType()+"'"+", "+"'"+helicopters.getDeveloper()+"'"+", "+"'"+helicopters.getCountry()+"'"+", "+"'"+helicopters.getMass()+"'"+", "+"'"+helicopters.getSpeed()+"'"+", "+"'"+helicopters.getDistance()+"'"+", "+"'"+helicopters.getLength()+"'"+", "+"'"+helicopters.getHeight()+"'"+", "+"'"+helicopters.getMainRotor()+"'"+", "+"'"+helicopters.getTailRotor()+"'"+", "+"'"+helicopters.getMotor()+"'"+", "+"'"+helicopters.getTeam()+"'"+");";

            if (helicopters.getId()!=0){
                query="INSERT INTO helicopters (id, name, type, developer, country, mass, speed, distance, length, height, mainRotor, tailRotor, motor, team)" +
                        "VALUES ("+"'"+helicopters.getId()+"'"+", "+"'"+helicopters.getName()+"'"+", "+"'"+helicopters.getType()+"'"+", "+"'"+helicopters.getDeveloper()+"'"+", "+"'"+helicopters.getCountry()+"'"+", "+"'"+helicopters.getMass()+"'"+", "+"'"+helicopters.getSpeed()+"'"+", "+"'"+helicopters.getDistance()+"'"+", "+"'"+helicopters.getLength()+"'"+", "+"'"+helicopters.getHeight()+"'"+", "+"'"+helicopters.getMainRotor()+"'"+", "+"'"+helicopters.getTailRotor()+"'"+", "+"'"+helicopters.getMotor()+"'"+", "+"'"+helicopters.getTeam()+"'"+");";

            }
            result=statement.executeUpdate(query);
            statement.close();
            worker.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result!=15;
    }

    public static Helicopters getHelicopters(String  name){
        DBWorker worker=new DBWorker();
        Helicopters helicopter=new Helicopters();
        String query="select * from helicopters WHERE name=";
        try {
            Statement statement=worker.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query+"'"+name+"'");
            while (resultSet.next()){
                helicopter.setId(resultSet.getInt("id"));
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
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return helicopter;
    }


    public static boolean updateAirplanes(Helicopters helicopters){
        int result=15;
        DBWorker worker=new DBWorker();
        String query="UPDATE helicopters SET id='"+helicopters.getId()+"', type='"+helicopters.getType()+"', developer='"+helicopters.getDeveloper()+"', country='"+helicopters.getCountry()+"', mass='"+helicopters.getMass()+"', speed='"+helicopters.getSpeed()+"', distance='"+helicopters.getDistance()+"', length='"+helicopters.getLength()+"', height='"+helicopters.getHeight()+"', mainRotor='"+helicopters.getMainRotor()+"', tailRotor='"+helicopters.getTailRotor()+"', motor='"+helicopters.getMotor()+"', team='"+helicopters.getTeam()+"' WHERE name='"+helicopters.getName()+"';";
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
        String query="DELETE FROM helicopters WHERE name='"+name+"'";
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

    public static Helicopters[] selectAllHelicopters(){
        List<Helicopters> helicoptersList=new ArrayList<Helicopters>();
        DBWorker worker=new DBWorker();
        String query="SELECT * FROM helicopters";
        try {
            Statement statement=worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Helicopters helicopter=new Helicopters();
                helicopter.setId(resultSet.getInt("id"));
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
        Helicopters [] helicoptersArray=new Helicopters[helicoptersList.size()];
        helicoptersList.toArray(helicoptersArray);
        return helicoptersArray;
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

    public double getMainRotor() {
        return mainRotor;
    }

    public void setMainRotor(double mainRotor) {
        this.mainRotor = mainRotor;
    }

    public double getTailRotor() {
        return tailRotor;
    }

    public void setTailRotor(double tailRotor) {
        this.tailRotor = tailRotor;
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
        return  getClass().getSimpleName()+"{id: "+id+",name: "+name+", type: "+type+", developer: "+developer+", country: "+country+", mass: "+mass+", speed: "+speed+", distance: "+distance+", length: "+length+", height: "+height+", mainRotor: "+mainRotor+", tailRotor "+tailRotor+", motor: "+motor+", team: "+team+"}";
    }


}
