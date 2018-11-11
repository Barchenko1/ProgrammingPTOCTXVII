package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.task1;

public abstract class Figure {
    public abstract void print();
    public abstract void move(int dx, int dy);
    public abstract void scale(int k);

    public static double countSizeSide(Point p1, Point p2) {
        double size=0;

        double dx=Math.abs(p1.getX() - Math.abs(p2.getX()));
        dx=Math.abs(dx);
        double dy = Math.abs(p1.getY()) - Math.abs(p2.getY());
        dy = Math.abs(dy);
        size = Math.pow(dx, 2) +Math.pow(dy, 2);
        size= Math.sqrt(size);
        return size;
    }
}
