package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice1.part1;

public class Main {
    public static void main(String[] args) {
        int[][] m1 = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] m2 = new int[][] {{2, 1, 2}, {4, 1, 2}, {7, 1, 2}};
        Matrix matrix1 = new Matrix(m1);
        Matrix matrix2 = new Matrix(m2);
        matrix1.show();
        System.out.println();
        matrix1.sum(matrix2);
        matrix1.show();
        System.out.println();
        matrix1.multiply(matrix2);
        matrix1.show();
        System.out.println();
        matrix1.transposition();
        matrix1.show();
    }
}
