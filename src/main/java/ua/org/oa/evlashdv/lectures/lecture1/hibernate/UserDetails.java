package ua.org.oa.evlashdv.lectures.lecture1.hibernate;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "User_Details")
public class UserDetails {
    @Id
    @GeneratedValue
    private int userId;
    private String userName;
    private String Address;
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    @Lob
    private String Description;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        userName = name;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public UserDetails(int userId, String userName, String address, Date joinedDate, String description) {
        this.userId = userId;
        this.userName = userName;
        Address = address;
        this.joinedDate = joinedDate;
        Description = description;
    }

    public UserDetails() {
    }

}
