package org.suai.lab3.graph;

import org.suai.lab3.exceptions.MatrixException;
import org.suai.lab3.matrix.SquareMatrix;
import org.suai.lab3.matrix.UsualMatrix;

import java.util.ArrayList;
import java.util.List;

public class AdjencyMatrixGraph extends SquareMatrix implements Graph {
    public AdjencyMatrixGraph(int size) throws MatrixException {
        super(size);
    }

    @Override
    public int getSize() {
        return super.getRows();
    }

    @Override
    public Iterable<Integer> getNeighbors(int vertex) {
        List<Integer> result = new ArrayList<>();

        int[][] data = super.getData();

        for (int i = 0; i < getSize(); i++) {
            if (data[vertex][i] == 1) {
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public void connect(int vertex1, int vertex2) {
        checkBounds(vertex1, vertex2);

        getData()[vertex1][vertex2] = 1;
    }

    @Override
    public void disconnect(int vertex1, int vertex2) {
        checkBounds(vertex1, vertex2);

        getData()[vertex1][vertex2] = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdjencyMatrixGraph)) return false;
        return super.equals(o);
    }
}
