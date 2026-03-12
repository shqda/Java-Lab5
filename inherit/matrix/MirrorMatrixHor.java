package inherit.matrix;

import inherit.exceptions.BadMatrixSizesException;



public class MirrorMatrixHor extends Matrix {
    private final int actualRows;

    public MirrorMatrixHor(int rows, int cols)  {
        super((rows + 1) / 2, cols);
        actualRows = rows; 
    }

    @Override
    public int getElement(int row, int column) throws BadMatrixSizesException {
        checkActualBounds(row, column);
        return data[mapRow(row)][column];
    }   
    
    @Override
    public void setElement(int row, int column, int value) throws BadMatrixSizesException {
        checkActualBounds(row, column);
        data[mapRow(row)][column] = value;
    }

    private void checkActualBounds(int row, int column) throws BadMatrixSizesException {
        if (row < 0 || row >= actualRows || column < 0 || column >= cols) {
            throw new BadMatrixSizesException("Index out of bounds: [" + row + "][" + column + "]");
        }
    }

    private int mapRow(int row) {
        if (row >= (actualRows + 1) / 2) {
            return actualRows - 1 - row;
        }
        return row;
    }
}
