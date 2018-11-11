package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.task1;

public class Main {
    public static void main(String[] args) {
        int[][] m1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] m2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Matrix matrix1 = new Matrix(m1);
        matrix1.printMatrix(matrix1.getM());
        matrix1.printMatrix(matrix1.transposition().getM());
        Matrix matrix2 = new Matrix(m1);
        Matrix matrix3 = new Matrix(m2);
        Matrix matrixResultMultiply=matrix2.multiply(matrix3);
        matrix1.printMatrix(matrixResultMultiply.getM());
        Matrix matrixResultAdd = matrix2.addMatrix(matrix3);
        matrix1.printMatrix(matrixResultAdd.getM());
        //task2 task3
        Figure tFigure = new Triangle(new Point(0,0),new Point(0,1),new Point(1,2));
        tFigure.print();
        tFigure.move(1,1);
        tFigure.print();
        tFigure.scale(2);
        tFigure.print();

    }
}
