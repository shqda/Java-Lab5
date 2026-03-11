package inherit.matrix;

import inherit.exceptions.MatrixException;
import java.util.Arrays;


public class Matrix {
    protected final int rows;
    protected final int cols;
    protected final int[][] data;
    
    public Matrix(int r, int c) throws MatrixException {
        if (r <= 0 || c <= 0) {
            throw new MatrixException("Index out of bounds: rows and cols must be > 0!\n");
        }

        rows = r;
        cols = c;
        data = new int[rows][cols];
    }


    public int getRows() { return rows; }
    public int getCols() { return cols; }
    

    private void checkBounds(int r, int c) throws MatrixException {
        if (r < 0 || c < 0) {
            throw new MatrixException("Index out of bounds: row and col must be > 0!\n");
        }

        else if (r >= rows || c >= cols) {
            throw new MatrixException("Index out of bounds: position [" + r + "][" + c + "]" +
                                      "does not exist in " + rows + "x" + cols +" matrix.");
        }
    }


    public int getElement(int row, int column) {
        checkBounds(row, column);
        return data[row][column];
    }   
    
    
    public void setElement(int row, int column, int value) throws MatrixException {
        checkBounds(row, column);
        data[row][column] = value;
    }


    public Matrix sum(Matrix other) throws MatrixException {
        if (rows != other.rows || cols != other.cols) {
            throw new MatrixException("Invalid matrix to sum: matrixs rows and cols must be the same\n");
        }

        Matrix newM = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newM.data[i][j] = data[i][j] + other.data[i][j];
            }
        }

        return newM;
    }


    public Matrix product(Matrix other) throws MatrixException {
        if (cols != other.rows) {
            throw new MatrixException(
                "Incompatible matrix sizes: left matrix columns (" 
                + cols + 
                ") must match right matrix rows (" + other.rows + ")."
            );
        }

        Matrix newM = new Matrix(this.rows, other.cols);
        
        for (int i = 0; i < this.rows; i++) { 
            for (int j = 0; j < other.cols; j++) { 
                int sumVal = 0;
                for (int k = 0; k < this.cols; k++) {
                    sumVal += data[i][k] * other.data[k][j];
                }
                newM.data[i][j] = sumVal;
            }
        }
        return newM;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Matrix)) return false;
        Matrix other = (Matrix) obj;
        return rows == other.rows && cols == other.cols && Arrays.deepEquals(data, other.data);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            sb.append("[ ");
            for (int j = 0; j < cols; j++) {
                sb.append(data[i][j]).append(" ");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
}