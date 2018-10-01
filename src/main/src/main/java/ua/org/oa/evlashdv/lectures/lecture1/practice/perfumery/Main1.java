package ua.org.oa.evlashdv.lectures.lecture1.practice.perfumery;

import java.io.*;

public class Main1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user=new User();
        user.lifeLevel=55;

        FileOutputStream fileOutputStream=new FileOutputStream("tempfile");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();

        FileInputStream fileInputStream=new FileInputStream("tempfile");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        User newUser= (User) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(newUser.lifeLevel);
    }
}
