package Graphs;

public class TestGraphs {

    public static void main(String[] args) {
        System.out.println("Adjacency Matrix Graphs");
        AdjMatrixGraphs g = new AdjMatrixGraphs(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.print();
        System.out.println("Adjacency List Graphs");
        AdjListGraphs g2 = new AdjListGraphs(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(0, 3);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 3);
        g2.addEdge(3, 4);
        g2.addEdge(2, 4);
        g2.print();
        System.out.println("BFS Traversal");
        g2.traverseBFS(0);
        System.out.println("DFS Traversal");
        g2.traverseDFS(0);
        /*System.out.println("Kruskal's Algorithm");
        g2.kruskalMST();
        System.out.println("Prim's Algorithm");*/
    }
}
