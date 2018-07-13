package ua.org.oa.evlashdv.lectures.lecture1.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App1 {
    public static void main(String[] args) {
        UserDetails userDetails=new UserDetails();
        userDetails.setUserId(1);
        userDetails.setName("Pasha");

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();
        session.close();
    }
}
