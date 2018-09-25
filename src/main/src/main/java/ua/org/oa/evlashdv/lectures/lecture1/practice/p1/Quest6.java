package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;

class Q {
    void mQ(int i) {
        System.out.print("mQ" + i);
    }
}
public class Quest6 extends Q {
    public void mQ(int i) {
        System.out.print("mQuest" + i);
    }
    public void mP(int i){
        System.out.println("mP"+i);
    }

    public static void main(String[] args) {
        Q ob=new Quest6();
        ob.mQ(1);

    }
}


