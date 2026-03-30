package org.suai.lab3.graph;

public interface Graph {
    public void connect(int vertex1, int vertex2);

    public void disconnect(int vertex1, int vertex2);

    public int getSize();

    public Iterable<Integer> getNeighbors(int vertex);

    public boolean equals(Object o);

    public String toString();
}
