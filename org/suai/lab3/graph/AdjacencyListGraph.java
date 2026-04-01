package org.suai.lab3.graph;

import java.util.*;

public class AdjacencyListGraph implements Graph {
    private final Set<Integer>[] data;
    private final int size;

    @SuppressWarnings("unchecked")
    public AdjacencyListGraph(int size) {
        this.size = size;
        data = new Set[size];

        for (int i = 0; i < size; i++) {
            data[i] = new HashSet<>();
        }
    }

    @Override
    public void connect(int vertex1, int vertex2) {
        checkBounds(vertex1);
        checkBounds(vertex2);

        getData()[vertex1].add(vertex2);
    }

    @Override
    public void disconnect(int vertex1, int vertex2) {
        checkBounds(vertex1);
        checkBounds(vertex2);

        getData()[vertex1].remove(vertex2);
    }

    private void checkBounds(int v) {
        if (v < 0 || v >= getSize()) {
            throw new RuntimeException("Invalid vertex: " + v);
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterable<Integer> getNeighbors(int vertex) {
        return getData()[vertex];
    }

    public Set<Integer>[] getData() {
        return data;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AdjacencyListGraph other)) return false;

        if (getSize() != other.getSize()) return false;

        for (int i = 0; i < getSize(); i++) {
            if (!getData()[i].equals(other.getData()[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator()).append("AdjacencyMatrixGraph").append(System.lineSeparator());

        for (Set<Integer> list : data) {
            sb.append("[ ");
            for (int cell : list) {
                sb.append(cell).append(" ");
            }
            sb.append("]").append(System.lineSeparator());
        }
        return sb.toString();
    }
}