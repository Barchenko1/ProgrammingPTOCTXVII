package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice1.part1;

/*
 * Matrix сlass with methods of matrix operations
 *
 * @autor Pavel Barchenko
 * @version 1.0
 */

public class Matrix {

    /* inner multidimensional array*/
    private int[][] array;

    public Matrix() {

    }

    /*
     * Matrix constructor to initialize inner multidimensional array
     *
     */
    public Matrix(int[][] array) {
        this.array = array;
    }

    /*
     * @method show matrix elements
     *
     */
    public void show() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%6d", array[i][j]);
            }
            System.out.println();
        }
    }

    /*
     * @method transpositions of matrix elements
     */
    public void transposition() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array[i].length; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
    }

    /*
     * @method addition of matrix elements with another matrix elements
     * @param m2 second matrix to plus
     */
    public void sum(Matrix m2) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = array[i][j] + m2.array[i][j];
            }
        }
    }

    /*
     * @method multiplication of matrix elements with another matrix elements
     * @param m2 second matrix to multiply
     */
    public void multiply(Matrix m2) {
        int m = array.length;
        int n = m2.array[0].length;
        int o = m2.array.length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    result[i][j] += array[i][k] * m2.array[k][j];

                }
            }
        }
        array = result;
    }

}
