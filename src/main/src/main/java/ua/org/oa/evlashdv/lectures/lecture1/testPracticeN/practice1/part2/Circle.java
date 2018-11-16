package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice1.part2;


public class Circle extends Figure {

    public Circle() {
    }

    //* radius of circle*/
    private int radius;

    public Circle(int x,int y,int radius) {
        super(new int[] {x}, new int[] {y});
        this.radius = radius;
    }

    /*
     * @method show circle
     *
     */
    @Override
    public void print() {
        System.out.println("Circle x = " + getX()[0] + " y = " + getY()[0]
                + " radius = " + radius + " perimeter = " + perimeter());
    }

    /*
     * @method scaling circle
     * @param coefficient circle magnification factor
     */
    @Override
    void scaling(int coefficient) {
        if (radius == 0) {
            return;
        }
        radius = radius * coefficient;
    }

    /*
     * @method to find circle perimeter
     *
     */
    @Override
    double perimeter() {
        double temp = radius * Math.PI * 2;
        return temp;
    }

}
