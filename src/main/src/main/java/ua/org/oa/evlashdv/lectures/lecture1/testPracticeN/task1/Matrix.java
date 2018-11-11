package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.task1;

public class Matrix {
    private int[][] m;

    public int[][] getM() {
        return m;
    }

    public Matrix(int[][] m) {
        if (!checkMatrix(m)) {
            throw new IllegalArgumentException();
        }
        this.m = m;
    }

    public void printMatrix(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%6d", array[i][j]);
            }
            System.out.println();
        }
    }
    public Matrix addMatrix(Matrix m2) {
        if (!checkMatrixAdd(m2)) {
            throw new IllegalArgumentException();
        }
        int[][] temp=new int[m.length][];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=new int[m2.m[0].length];
        }
        Matrix result=new Matrix(temp);
        for (int i = 0; i <result.m.length ; i++) {
            for (int j = 0; j < result.m[0].length; j++) {
                result.m[i][j] = m[i][j] + m2.m[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(Matrix m2) {
        if (!checkMatrixMulty(m2)) {
            throw new IllegalArgumentException();
        }
        int[][] temp=new int[m.length][];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=new int[m2.m[0].length];
        }
        Matrix result=new Matrix(temp);
        for (int i = 0; i <result.m.length ; i++) {
            for (int j = 0; j <result.m[i].length ; j++) {
                result.m[i][j] = count(i,j,m2);
            }
        }
        return result;
    }
    public Matrix transposition(){
        int[][] temp=new int[m.length][];
        for (int i = 0; i < temp.length ; i++) {
            temp[i]=new int[m.length];
        }
        Matrix transpositionMatrix = new Matrix(temp);
        for (int i = 0; i <transpositionMatrix.m.length ; i++) {
            for (int j = 0; j < transpositionMatrix.m[0].length; j++) {
                transpositionMatrix.m[i][j]=m[j][i];
            }
        }
        return transpositionMatrix;
    }

    private boolean checkMatrix(int[][] matrix) {
        int column=matrix[0].length;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].length != column) {
                return false;
            }
        }
        return true;
    }

    private int count(int i, int j, Matrix om) {
        int count = 0;
        for (int k = 0; k < m[0].length; k++) {
            count += m[i][k] * om.m[k][j];
        }
        return count;
    }

    private boolean checkMatrixAdd(Matrix m2) {
        if (this.getM().length!=m2.m.length) {
            return false;
        }
        for (int i = 0; i < m.length ; i++) {
            if (m[i].length != m2.m.length) {
                return false;
            }
        }
        return true;
    }

    private boolean checkMatrixMulty(Matrix m2) {
        int firstCol=m[0].length;
        int secondRow=m2.m.length;
        if (firstCol != secondRow) {
            return false;
        }
        return true;
    }
}
