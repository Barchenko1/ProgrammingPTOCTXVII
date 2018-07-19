package ua.org.oa.evlashdv.lectures.lecture1.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class App1 {
    public static void main(String[] args) {
        UserDetails user=new UserDetails();

        user.setName("First User");
        user.setAddress("First User's address");
        user.setJoinedDate(new Date());
        user.setDescription("description of the user goes here");

        UserDetails user2=new UserDetails();

        user2.setName("Second User");
        user2.setAddress("Second User's address");
        user2.setJoinedDate(new Date());
        user2.setDescription("description of the user goes here");

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(user2);
        session.getTransaction().commit();
        session.close();

        user=null;

        session=sessionFactory.openSession();
        session.beginTransaction();
        user=session.get(UserDetails.class,2);
        System.out.println("user name retrieved is "+user.getName());
    }
}
