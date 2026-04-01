package org.suai.lab3;

import org.suai.lab3.graph.AdjacencyListGraph;
import org.suai.lab3.graph.AdjacencyMatrixGraph;
import org.suai.lab3.graph.Graph;
import org.suai.lab3.matrix.*;
import org.suai.lab3.viz.GraphViz;

import java.util.Arrays;

//TODO: final

public class Main {

    public static void dfs(Graph g, int start) {
        if (start < 0 || start >= g.getSize()) return;
        System.out.println(System.lineSeparator() + "DFS for graph " + g.getClass().getSimpleName() + ":");

        boolean[] visited = new boolean[g.getSize()];
        dfsRec(g, start, visited);
    }


    public static void main(String[] args) {
        System.out.println("Matrix usual1:");
        Matrix usual1 = MatrixGenerator.generateUsualMatrix(1000, 1000);

        System.out.println("Matrix usual2:");
        Matrix usual2 = MatrixGenerator.generateSparseMatrix(1000, 1000);

        System.out.println("Matrix usualSum = usual1 + usual2:");
        Matrix usualSum = usual1.sum(usual2);

        System.out.println("Matrix usualProd = usual1 * usual2:");
        Matrix usualProd = usual1.product(usual2);
        System.out.println();

        System.out.println("Matrix sparse1 = usual1:");
        Matrix sparse1 = usual1.copy();

        System.out.println("Matrix sparse2 = usual2:");
        Matrix sparse2 = usual2.copy();

        System.out.println("Matrix sparseSum = sparse1 + sparse2:");
        Matrix sparseSum = sparse1.sum(sparse2);

        System.out.println("Matrix sparseProd = sparse1 * sparse2:");
        Matrix sparseProd = sparse1.product(sparse2);
        System.out.println();

        System.out.println("Matrix combineSum = usual1 + sparse2:");
        Matrix combineSum = usual1.sum(sparse2);

        System.out.println("Matrix combineProd = usual1 + sparse2:");
        Matrix combineProd = usual1.product(sparse2);
        System.out.println();

        System.out.println("usualSum == sparseSum == combineSum: " + // тк они Matrix то все ок
                (usualSum.equals(sparseSum) == usualSum.equals(combineSum)));

        System.out.println("usualProd == sparseProd == combineProd: " +
            (usualProd.equals(sparseProd) == usualProd.equals(combineProd)));


        AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(5);
        g.connect(4, 1);
        g.connect(1, 2);
        g.connect(1, 0);
        g.connect(2, 3);

        AdjacencyMatrixGraph gCopy = new AdjacencyMatrixGraph(5);
        gCopy.connect(4, 1);
        gCopy.connect(1, 2);
        gCopy.connect(1, 0);
        gCopy.connect(2, 3);

        System.out.println("g equals gCopy: " + g.equals(gCopy));

        dfs(g, 4);
        System.out.println(g);

        try {
            GraphViz.toFile(g, "matrix_graph");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        AdjacencyListGraph g1 = new AdjacencyListGraph(5);
        g1.connect(4, 1);
        g1.connect(1, 2);
        g1.connect(1, 0);
        g1.connect(2, 3);

        dfs(g1, 4);
        System.out.println(g1);

        System.out.println("g equals gCopy: " + g1.equals(gCopy));

        try {
            GraphViz.toFile(g, "list_graph");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void dfsRec(Graph g, int v, boolean[] visited) {
        visited[v] = true;

        System.out.print(v + " ");

        for (int to : g.getNeighbors(v)) {
            if (!visited[to]) {
                dfsRec(g, to, visited);
            }
        }
    }
}
