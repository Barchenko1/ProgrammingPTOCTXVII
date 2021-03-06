package ua.org.oa.evlashdv.lectures.lecture1.testPracticeE.testPractice8;

public class Group {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static Group createGroup(String name) {
        Group group = new Group();
        group.setName(name);
        return group;
    }
    @Override
    public String toString() {
        return "Group[" + "id=" + id + ", name='" + name + '\'' + ']';
    }
}
