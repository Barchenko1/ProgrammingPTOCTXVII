package ua.org.oa.evlashdv.lectures.lecture1.lecture6b.newExample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws IOException {

        Human human=new Human("Vasya",25,"qwerty",new Role("admin"));
        Human human1=new Human("Sweta",20,"rtyui",new Role("user"));

        serialize("humans",human,human1);
        List<Human> humanList=deserialize("humans");
        System.out.println(humanList.get(0).getName());
        humanList.forEach(System.out::println);

        Properties properties=new Properties();
        properties.setProperty("db.user","root");
        properties.setProperty("db.password","123456");

        properties.store(new FileOutputStream("property"),"DB property");

        Properties properties1=new Properties();
        properties1.load(App.class.getClassLoader().getResourceAsStream("property"));
        System.out.println(properties1.getProperty("db.user"));
    }

//    public static<T> String makeJson(T object, Class<T> clazz){
//        Gson gson= new GsonBuilder().setp
//    }

    public static<T> List<T> deserialize(String path) {
        List<T> list=new ArrayList<>();
        try (ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(path));){
            while (true){
                list.add((T)inputStream.readObject());
            }
        } catch (EOFException e) {
            return list;
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static<T extends Serializable> void serialize(String path, T...objects) {
        try (ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(path));){
            for (T object:objects) {
                objectOutputStream.writeObject(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
