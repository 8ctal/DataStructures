package Graphs;

public class AdjMatrixGraphs {
    private int[][] adjMatrix;
    private int V; // number of vertices
    private int E; // number of edges

    public AdjMatrixGraphs(int vertices) {
        this.V = vertices;
        this.E = 0;
        this.adjMatrix = new int[V][V];
    }

    public void addEdge(int v, int u) {
        if (v < 0 || v >= V || u < 0 || u >= V) {
            throw new IllegalArgumentException();
        }
        if (adjMatrix[v][u] == 0) {
            E++;
        }
        adjMatrix[v][u] = 1; // for directed graph
        adjMatrix[u][v] = 1; // for undirected graph
    }

    public void print() {
        System.out.println("V = " + V + ", E = " + E);
        for (int v = 0; v < V; v++) {
            System.out.print(v + ": ");
            for (int u = 0; u < V; u++) {
                //if (adjMatrix[v][u] == 1) {
                //System.out.print(u + " ");
                System.out.print(adjMatrix[v][u] + " ");
                //}
            }
            System.out.println();
        }
    }
}
