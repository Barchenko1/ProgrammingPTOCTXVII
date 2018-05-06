package ua.org.oa.evlashdv.lectures.lecture1.p1;

public class ShapeCreator {
    public static void main(String[] args) {
        Shape sh;
        Rectangle re=new Rectangle(5,9.95);
        sh=re;
        System.out.println(sh.getPerimeter());
        Circle cr=new Circle(7.01);
        sh=cr;
        System.out.println(sh.getPerimeter());

    }
}
