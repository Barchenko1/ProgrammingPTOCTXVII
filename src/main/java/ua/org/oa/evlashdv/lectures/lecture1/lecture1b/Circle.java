package ua.org.oa.evlashdv.lectures.lecture1.lecture1b;

import lombok.Data;

public class Circle {
    private Point point;
    private String color;
    public Circle(int x,int y,String color) {
        point=new Point();
        point.x=x;
        point.y=y;
        this.color=color;
    }

    @Data
    public class Point{
        private int x;
        private int y;
        public String returnColor(){
            return color;
        }
    }
}
