package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice1.part2;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(3,3,9);
        circle.print();
        circle.scaling(3);
        circle.print();

        Triangle triangle = new Triangle(1,2,3,4,5,6);
        triangle.print();
        triangle.scaling(2);
        triangle.print();

        circle.move(1,2);
        circle.print();

        System.out.println(circle.perimeter());
        System.out.println(triangle.perimeter());

    }
}
