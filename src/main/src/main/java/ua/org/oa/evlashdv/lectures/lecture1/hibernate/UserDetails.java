package ua.org.oa.evlashdv.lectures.lecture1.hibernate;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name = "User_Details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "user_address",joinColumns = @JoinColumn(name = "user_id"))
    @GenericGenerator(name = "increment-gen", strategy = "increment")
    @CollectionId(columns = @Column(name = "address_id"),generator = "increment-gen", type = @Type(type = "long"))
    private Collection<Address> listOfAddresses=new ArrayList<>();
//    @Embedded
//    @AttributeOverrides({
//    @AttributeOverride(name = "street",column = @Column (name = "home_street_name")),
//    @AttributeOverride(name = "city",column = @Column (name = "home_city_name")),
//    @AttributeOverride(name = "state",column = @Column (name = "home_state_name")),
//    @AttributeOverride(name = "pinCode",column = @Column (name = "home_pin_code"))
//    })
//    private Address homeAddress;
//    @Embedded
//    private Address officeAddress;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Collection<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

    //    public Address getHomeAddress() {
//        return homeAddress;
//    }
//
//    public void setHomeAddress(Address homeAddress) {
//        this.homeAddress = homeAddress;
//    }
//
//    public Address getOfficeAddress() {
//        return officeAddress;
//    }
//
//    public void setOfficeAddress(Address officeAddress) {
//        this.officeAddress = officeAddress;
//    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public UserDetails() {
    }

}
