package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;

import java.io.*;

public class Seriole {
    public static void main(String[] args) {
        User user=new User();
        user.lifelevel=55;

        try {
            FileOutputStream fs=new FileOutputStream("user");
            ObjectOutputStream obs=new ObjectOutputStream(fs);
            obs.writeObject(user);
            obs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fi=new FileInputStream("user");
            ObjectInputStream obi=new ObjectInputStream(fi);
            User newUser= (User) obi.readObject();
            obi.close();
            System.out.println(newUser.lifelevel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
