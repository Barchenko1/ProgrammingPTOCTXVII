package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.task1;

public class Triangle extends Figure {
    private static final int NUMBER = 3;

    protected Point[] points;

    public Triangle() {
    }

    public Triangle(Point point0, Point point1, Point point2) {
        points=new Point[NUMBER];
        points[0] = point0;
        points[1] = point1;
        points[2] = point2;
    }

    @Override
    public void print() {
        StringBuilder sb=new StringBuilder();
        sb.append("Triangle ");
        for (int i = 0; i <NUMBER ; i++) {
            sb.append(points[i]);
        }
        double perimeter=0;
        perimeter += Figure.countSizeSide(points[0], points[NUMBER - 1]);
        for (int i = 0; i < NUMBER-1; i++) {
            perimeter+=Figure.countSizeSide(points[i],points[i+1]);
        }
        sb.append(String.format(" perimeter = %.2f", perimeter));
        System.out.println(sb.toString());
    }

    @Override
    public void move(int dx, int dy) {
        for (int i = 0; i <NUMBER ; i++) {
            points[i].move(dx, dy);
        }
    }

    @Override
    public void scale(int k) {
        for (int i = 1; i < NUMBER; i++) {
            points[i].move(-points[0].getX(),-points[0].getX());
        }
        for (int i = 1; i < NUMBER; i++) {
            double tempX=points[i].getX() * k;
            double tempY=points[i].getY() * k;
            points[i].setX(tempX);
            points[i].setY(tempY);
        }
        for (int i =1; i < NUMBER; i++) {
            points[i].move(points[0].getX(), points[0].getY());
        }
    }
}
