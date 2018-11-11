package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.task1;

public class Point {
    private double x;
    private double y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public void move(double dx, double dy) {
        x+=dx;
        y+=dy;
    }
    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}
