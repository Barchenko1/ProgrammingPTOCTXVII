package ua.org.oa.evlashdv.lectures.lecture1.testPracticeE.testPractice8;

public class User {
    private int id;
    private String login;

    public User(String login) {
        this.login = login;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public static User createUser(String name) {
        return new User(name);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
