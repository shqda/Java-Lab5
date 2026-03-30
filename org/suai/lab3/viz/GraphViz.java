package org.suai.lab3.viz;

import org.suai.lab3.graph.Graph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GraphViz {
    private static String toString(Graph g) {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph G {\n");

        for (int v = 0; v < g.getSize(); v++) {
            for (int to : g.getNeighbors(v)) {

                if (v == to) continue;

                sb.append("  ")
                        .append(v)
                        .append(" -> ")
                        .append(to)
                        .append(";\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    public static void toFile(Graph g, String fileName) throws IOException {
        Path dotFile = Path.of("out/dot/" + fileName + ".dot");
        Path pngFile = Path.of("out/img/" + fileName + ".png");

        Files.createDirectories(dotFile.getParent());
        Files.createDirectories(pngFile.getParent());

        Files.writeString(dotFile, toString(g));

        try {
            Process p = new ProcessBuilder(
                    "dot",
                    "-Tpng",
                    dotFile.toString(),
                    "-o",
                    pngFile.toString()
            ).start();

            int code = p.waitFor();

            if (code != 0) {
                throw new RuntimeException("Graphviz failed, exit code: " + code);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Graphviz interrupted", e);
        }
    }
}
