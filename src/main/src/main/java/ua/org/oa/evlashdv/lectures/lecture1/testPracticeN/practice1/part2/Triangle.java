package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice1.part2;

public class Triangle extends Figure {

    public Triangle() {
    }

    public Triangle(int xa, int ya, int xb, int yb, int xc, int yc) {
        super(new int[]{xa,xb,xc},new int[]{ya,yb,yc});
    }

    /*
     * @method show circle
     *
     */
    @Override
    public void print() {
        System.out.println("Triangle " + "xA = " + getX()[0] + ", yA = "
                + getY()[0]
                + ", xB = " + getX()[1] + ", yB = " + getY()[1] + ", xC = "
                + getX()[2] + ", yC=" + getY()[2] + " perimeter = "
                + perimeter());
    }

    /*
     * @method scaling triangle
     * @param coefficient magnification factor
     */
    @Override
    void scaling(int coefficient) {
        if (coefficient == 0) {
            return;
        }
        for (int i = 0; i < getX().length; i++) {
            getX()[i] *= coefficient;
        }
        for (int i = 0; i < getY().length; i++) {
            getY()[i] *= coefficient;
        }
    }

    /*
     * @method to find figure perimeter
     *
     */
    @Override
    double perimeter() {
        double a = Math.sqrt((getX()[0] - getX()[1]) * (getX()[0] - getX()[1])
                + (getY()[0] - getY()[1]) * (getY()[0] - getY()[1]));
        double b = Math.sqrt((getX()[0] - getX()[2]) * (getX()[0] - getX()[2])
                + (getY()[0] - getY()[2]) * (getY()[0] - getY()[2]));
        double c = Math.sqrt((getX()[1] - getX()[2]) * (getX()[1] - getX()[2])
                + (getY()[1] - getY()[2]) * (getY()[1] - getY()[2]));
        double p = a + b + c;

        return p;
    }

}
