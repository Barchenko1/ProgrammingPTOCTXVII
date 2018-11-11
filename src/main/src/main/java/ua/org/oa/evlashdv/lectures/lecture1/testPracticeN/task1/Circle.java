package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.task1;

public class Circle extends Figure {
    private static final int NUMBER = 1;

    protected Point[] points;

    public Circle() {
    }

    public Circle(Point point1) {
        points=new Point[NUMBER];
        points[0] = point1;
    }

    @Override
    public void print() {

    }

    @Override
    public void move(int dx, int dy) {
        points[0].move(dx, dy);
    }

    @Override
    public void scale(int k) {

    }
}
