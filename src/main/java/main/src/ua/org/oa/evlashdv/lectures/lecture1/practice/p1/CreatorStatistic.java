package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;
class CommonObject implements Cloneable{
    public CommonObject() {
        super();
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class UserStatic extends CommonObject{
    private long id;
    private int mark;

    public UserStatic() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
public class CreatorStatistic {
    public static UserStatic createUserStatic(long id){
        UserStatic temp=new UserStatic();
        temp.setId(id);
        int mark = 0;
        temp.setMark(mark);
        return temp;
    }
    public static void main(String[] args) {
        UserStatic us=createUserStatic(71);
        System.out.println(us.getMark());
    }
}
