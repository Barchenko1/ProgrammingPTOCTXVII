package ua.org.oa.evlashdv.lectures.lecture1.lecture6b.newExample;

import java.io.Serializable;

public class Human implements Serializable {
    private static final long serialVersionUID=-8912518467682816628L;
    private String name;
    private int age;
    private transient String password;
    private Role role;

    public Human(String name, int age, String password, Role role) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
