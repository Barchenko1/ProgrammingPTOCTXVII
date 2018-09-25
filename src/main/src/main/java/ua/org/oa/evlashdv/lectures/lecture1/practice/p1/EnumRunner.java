package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;

public class EnumRunner {
    public static void main(String[] args) throws IllegalAccessException {
        int i=4;
        for (ShapeE f:ShapeE.values()) {
            f.setShape(3,i--);
            System.out.println(f.name()+"-> "+f.getParameters()+" площядь= "+f.getSquare());
        }
    }
}
