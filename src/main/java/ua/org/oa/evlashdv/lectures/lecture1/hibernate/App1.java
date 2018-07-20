package ua.org.oa.evlashdv.lectures.lecture1.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class App1 {
    public static void main(String[] args) {
        UserDetails user=new UserDetails();
        Address addr=new Address();
        Address addr2=new Address();

        addr.setStreet("Street Name");
        addr.setCity("city name");
        addr.setState("first State");
        addr.setPinCode("10001");

        addr2.setStreet("second street name");
        addr2.setCity("second city name");
        addr2.setState("second State");
        addr2.setPinCode("20002");

        user.getListOfAddresses().add(addr);
        user.getListOfAddresses().add(addr2);

        user.setName("First User");
        user.setJoinedDate(new Date());
        user.setDescription("description of the user goes here");
//        user.setHomeAddress(addr);
//        user.setOfficeAddress(addr2);


        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        user=null;

        session=sessionFactory.openSession();
        session.beginTransaction();
        user=session.get(UserDetails.class,1);
        session.close();
        System.out.println(user.getListOfAddresses().size());



    }
}
