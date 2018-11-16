package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice1.part2;

/*
 * abstract Figure сlass with methods of figures operations
 * @autor Pavel Barchenko
 * @version 1.0
 */
public abstract class Figure {

    public Figure() {
    }

    /* x coordinate  */
    private int[] xd;

    /* y coordinate  */
    private int[] yd;

    public int[] getX() {
        return xd;
    }

    public void setX(int[] xd) {
        this.xd = xd;
    }

    public int[] getY() {
        return yd;
    }

    public void setY(int[] y) {
        this.yd = yd;
    }

    public Figure(int[] xd, int[] yd) {
        this.xd = xd;
        this.yd = yd;
    }

    /*
     * @method show figure
     *
     */
    public abstract void print();

    /*
     * @method scaling figure
     * @param k figure magnification factor
     *
     */
    abstract void scaling(int k);

    /*
     * @method scaling figure
     * @param xd x coordinate
     * @param yd y coordinate
     */
    void move(int x,int y) {
        for (int i = 0; i < xd.length; i++) {
            xd[i] += x;
        }
        for (int i = 0; i < yd.length; i++) {
            yd[i] += y;
        }
    }

    /*
     * @method to find figure perimeter
     *
     */
    abstract double perimeter();


}
