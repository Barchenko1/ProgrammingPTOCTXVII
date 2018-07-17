package ua.org.oa.evlashdv.lectures.lecture1.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserDetails {
    @Id
    private int userId;
    private String Name;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public UserDetails(int userId, String name) {
        this.userId = userId;
        Name = name;
    }

    public UserDetails() {
    }

}
