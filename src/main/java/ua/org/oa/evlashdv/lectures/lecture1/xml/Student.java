package ua.org.oa.evlashdv.lectures.lecture1.xml;

public class Student {
    private String login;
    private String name;
    private String faculty;
    private String telephone;
    private Address address=new Address();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public String toString() {
        return "Login: " + login
                + "\nName: " + name
                + "\nTelephone: " + telephone
                + "\nFaculty: " + faculty
                + "\nAddress:"
                + "\n\tCountry: " + address.getCountry()
                + "\n\tCity: " + address.getCity()
                + "\n\tStreet: " + address.getStreet()
                + "\n";
    }
}
