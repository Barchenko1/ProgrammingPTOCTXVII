package ua.org.oa.evlashdv.lectures.lecture1.lecture3;

public class SubStringCons {
    public static void main(String[] args) {
        byte ascii[]={65,66,67,68,69,70};
        String s1=new String (ascii);
        System.out.println(s1);
        String s2=new String (ascii,2,3);
        System.out.println(s2);

        String a1="My name";
        String a2="My name";
        String a3=new String ("My name");
        System.out.println(a1==a2);
        System.out.println(a1==a3);
        System.out.println(a1.equals(a3));
        String a4=a3.intern();
        System.out.println(a1==a4);

    }
}
