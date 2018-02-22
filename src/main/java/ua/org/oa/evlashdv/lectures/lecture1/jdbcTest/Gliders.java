package ua.org.oa.evlashdv.lectures.lecture1.jdbcTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Gliders {
    private int id;
    private String name;
    private String type;
    private String developer;
    private String country;
    private int mass;
    private double length;
    private double height;
    private double wingSpan;
    private double windArea;
    private int team;

    public Gliders() {
    }

    public Gliders(int id, String name, String type, String developer, String country, int mass, double length, double height, double wingSpan, double windArea, int team) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.developer = developer;
        this.country=country;
        this.mass = mass;
        this.length = length;
        this.height = height;
        this.wingSpan = wingSpan;
        this.windArea = windArea;
        this.team = team;
    }

    public Gliders(String name, String type, String developer, String country, int mass, double length, double height, double wingSpan, double windArea, int team) {
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

    public static boolean createGlider(Gliders gliders){
        int result=15;
        try {
            DBWorker worker=new DBWorker();
            Statement statement=worker.getConnection().createStatement();
            String query="INSERT INTO gliders (id, name, type, developer, country, mass, length, height, wingSpan, wingArea, team)" +
                    "VALUES ("+"'"+gliders.getId()+"'"+", "+"'"+gliders.getName()+"'"+", "+"'"+gliders.getType()+"'"+", "+"'"+gliders.getDeveloper()+"'"+", "+"'"+gliders.getCountry()+"'"+", "+"'"+gliders.getMass()+"'"+", "+"'"+gliders.getLength()+"'"+", "+"'"+gliders.getHeight()+"'"+", "+"'"+gliders.getWingSpan()+"'"+", "+"'"+gliders.getWindArea()+"'"+", "+"'"+gliders.getTeam()+"'"+");";

            if (gliders.getId()!=0){
                query="INSERT INTO gliders (id, name, type, developer, country, mass, length, height, wingSpan, wingArea, team)" +
                        "VALUES ("+"'"+gliders.getId()+"'"+", "+"'"+gliders.getName()+"'"+", "+"'"+gliders.getType()+"'"+", "+"'"+gliders.getDeveloper()+"'"+", "+"'"+gliders.getCountry()+"'"+", "+"'"+gliders.getMass()+"'"+", "+"'"+gliders.getLength()+"'"+", "+"'"+gliders.getHeight()+"'"+", "+"'"+gliders.getWingSpan()+"'"+", "+"'"+gliders.getWindArea()+"'"+", "+"'"+gliders.getTeam()+"'"+");";

            }
            result=statement.executeUpdate(query);
            statement.close();
            worker.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result!=15;
    }


    public static Gliders getGliders(String  name){
        DBWorker worker=new DBWorker();
        Gliders gliders=new Gliders();
        String query="select * from gliders WHERE name=";
        try {
            Statement statement=worker.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query+"'"+name+"'");
            while (resultSet.next()){
                gliders.setId(resultSet.getInt("id"));
                gliders.setName(resultSet.getString("name"));
                gliders.setType(resultSet.getString("type"));
                gliders.setDeveloper(resultSet.getString("developer"));
                gliders.setCountry(resultSet.getString("country"));
                gliders.setMass(resultSet.getInt("mass"));
                gliders.setLength(resultSet.getDouble("length"));
                gliders.setHeight(resultSet.getDouble("height"));
                gliders.setWingSpan(resultSet.getDouble("wingSpan"));
                gliders.setWindArea(resultSet.getDouble("wingArea"));
                gliders.setTeam(resultSet.getInt("team"));
            }
            resultSet.close();
            statement.close();
            worker.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gliders;
    }


    public static boolean updateGliders(Gliders gliders){
        int result=15;
        DBWorker worker=new DBWorker();
        String query="UPDATE gliders SET id='"+gliders.getId()+"', type='"+gliders.getType()+"', developer='"+gliders.getDeveloper()+"', country='"+gliders.getCountry()+"', mass='"+gliders.getMass()+"', length='"+gliders.getLength()+"', height='"+gliders.getHeight()+"', wingSpan='"+gliders.getWingSpan()+"', wingArea='"+gliders.getWindArea()+"', team='"+gliders.getTeam()+"' WHERE name='"+gliders.getName()+"';";
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
        String query="DELETE FROM gliders WHERE name='"+name+"'";
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

    public static Gliders[] selectAllGliders(){
        List<Gliders> glidersList=new ArrayList<Gliders>();
        DBWorker worker=new DBWorker();
        String query="SELECT * FROM gliders";
        try {
            Statement statement=worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Gliders glider=new Gliders();
                glider.setId(resultSet.getInt("id"));
                glider.setName(resultSet.getString("name"));
                glider.setType(resultSet.getString("type"));
                glider.setDeveloper(resultSet.getString("developer"));
                glider.setCountry(resultSet.getString("country"));
                glider.setMass(resultSet.getInt("mass"));
                glider.setLength(resultSet.getDouble("length"));
                glider.setHeight(resultSet.getDouble("height"));
                glider.setTeam(resultSet.getInt("team"));
                glidersList.add(glider);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gliders [] glidersArray=new Gliders[glidersList.size()];
        glidersList.toArray(glidersArray);
        return glidersArray;
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

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName()+"{id: "+id+",name: "+name+", type: "+type+", developer: "+developer+", country: "+country+", mass: "+mass+", length: "+length+", height: "+height+", wingspan: "+wingSpan+", windArea: "+windArea+", team: "+team+"}";
    }

}
