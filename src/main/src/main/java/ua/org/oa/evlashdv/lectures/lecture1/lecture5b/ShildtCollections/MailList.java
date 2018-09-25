package ua.org.oa.evlashdv.lectures.lecture1.lecture5b.ShildtCollections;

import java.util.LinkedList;
import java.util.RandomAccess;

class Address{
    private String name;
    private String street;
    private String city;
    private String state;
    private String code;

    public Address(String name, String street, String city, String state, String code) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
public class MailList {
    public static void main(String[] args) {
        LinkedList<Address>ml=new LinkedList<>();
        ml.add(new Address("J.W. West","11 Oak Ave","Urbana","IL","61801"));
        ml.add(new Address("Ralph Baker","1421 Maple Lane","Mahomet","IL","61853"));
        ml.add(new Address("Tom Carlton","867 Elm St","Champaign","IL","61820"));
        for (Address element:ml) {
            System.out.println(element);
        }
        System.out.println();

    }
}
