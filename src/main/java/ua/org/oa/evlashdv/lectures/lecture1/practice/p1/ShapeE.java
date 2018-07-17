package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;

public enum ShapeE {
    RECTANGLE, SQUARE,
    TRIANGLE {// анонимный класс
        public double getSquare(){
            return a*b/2;}
    };
    public double a,b;
    void setShape(double a,double b) throws IllegalAccessException {
        if ((a<=0||b<=0)||a!=b&&this==SQUARE){
            throw new IllegalAccessException();
        }else {this.a=a;
            this.b=b;}
    }
    double getSquare(){// версия для RECTANGLE и SQUARE
        return a * b;
    }
    String getParameters() {
        return "a=" + a + ", b=" + b;
    }
}
