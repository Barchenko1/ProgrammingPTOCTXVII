package ua.org.oa.evlashdv.lectures.lecture1.solid;

public class LiskovPrinciple {
    static Rectangle getRect(){
        return new Rectangle();
    }
    public static void main(String[] args) {
        Rectangle rectangle=getRect();
        rectangle.setHeight(10);
        rectangle.setWight(5);
        System.out.println(rectangle.getSquare());
    }
}
interface Shape{
    int getSquare();
}
class Rectangle implements Shape{
    int wight;
    int height;

    public int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int getSquare(){
        return wight*height;
    }
}
class Square implements Shape{
    int width;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getSquare() {
        return width*width;
    }
}