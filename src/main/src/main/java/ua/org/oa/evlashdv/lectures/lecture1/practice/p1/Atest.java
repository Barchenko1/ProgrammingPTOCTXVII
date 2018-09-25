package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;


interface LineGroup{
    double getPerimeter();
}
interface Shape extends LineGroup{
    double getSquare();
}

class Rectangle implements Shape{
    private double a,b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getSquare() {
        return a*b;
    }

    @Override
    public double getPerimeter() {
        return 2*(a+b);
    }
}
class Circle implements Shape{
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getSquare() {
        return Math.PI*Math.pow(r,2);
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*r;
    }
}
abstract class Triangle implements Shape{
    private double a,b,c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return a+b+c;
    }
}
public class Atest {
    static void printFeature(Shape f){
        System.out.printf("площадь:%.2f периметр: %.2f%n",
                f.getSquare(), f.getPerimeter());
    }
    public static void main(String[] args) {
        Rectangle r=new Rectangle(5,9.95);
        Circle c =new Circle(7.01);
        printFeature(r);
        printFeature(c);
    }
}
