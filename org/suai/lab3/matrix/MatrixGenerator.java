package org.suai.lab3.matrix;

public class MatrixGenerator {

    public static Matrix generateUsualMatrix(int rows, int cols) {
        Matrix m = new UsualMatrix(rows, cols);
        fill(m, rows, cols);
        return m;
    }

    public static Matrix generateSparseMatrix(int rows, int cols) {
        Matrix m = new UsualMatrix(rows, cols);
        fill(m, rows, cols);
        return m;
    }

    public static Matrix generateSquareMatrix(int size) {
        Matrix m = new SquareMatrix(size);
        fill(m, size, size);
        return m;
    }

    private static void fill(Matrix m, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = (int)(Math.random() * 9 + 1);
                m.setElement(i, j, val);
            }
        }
    }
}
