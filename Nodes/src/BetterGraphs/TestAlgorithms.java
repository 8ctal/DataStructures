package BetterGraphs;

import BetterGraphs.Algos.*;

import static BetterGraphs.Algos.FloydWarshall.*;

import java.util.*;
import java.util.stream.*;

public class TestAlgorithms {
    public static void main(String[] args) throws Exception {
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        Vertex<String> e = new Vertex<>("E");
        Vertex<String> f = new Vertex<>("F");

//Kruskal's Algorithm
        /*
        List<Edge<String>> graph = Arrays.asList(
                new Edge<>(a, b, 5),
                new Edge<>(a, c, 2),
                new Edge<>(b, c, 4),
                new Edge<>(b, d, 8),
                new Edge<>(b, e, 7),
                new Edge<>(c, e, 3),
                new Edge<>(d, e, 2)
        );
        new KruskalMST<>(graph).run();

//Dijkstra's Algorithm
        a.addAdjacentVertexWithWeight(b, 2);
        a.addAdjacentVertexWithWeight(c, 4);
        b.addAdjacentVertexWithWeight(c, 3);
        b.addAdjacentVertexWithWeight(d, 1);
        b.addAdjacentVertexWithWeight(e, 5);
        c.addAdjacentVertexWithWeight(d, 2);
        d.addAdjacentVertexWithWeight(e, 1);
        d.addAdjacentVertexWithWeight(f, 4);
        e.addAdjacentVertexWithWeight(f, 2);
        DijkstraSP<String> dijkstra = new DijkstraSP<>();
        dijkstra.calculateShortestPath(a);
        dijkstra.printPaths(List.of(a, b, d, e, f));*/

//Prim's Algorithm
        Edge edgeAB = new Edge<>(4);
        Edge edgeAC = new Edge<>(4);
        Edge edgeBC = new Edge<>(2);
        Edge edgeCD = new Edge<>(3);
        Edge edgeCF = new Edge<>(4);
        Edge edgeCE = new Edge<>(2);
        Edge edgeDF = new Edge<>(3);
        Edge edgeEF = new Edge<>(3);

        a.addNeighbor(b, edgeAB);
        a.addNeighbor(c, edgeAC);
        b.addNeighbor(a, edgeAB);
        b.addNeighbor(c, edgeBC);
        c.addNeighbor(a, edgeAC);
        c.addNeighbor(b, edgeBC);
        c.addNeighbor(e, edgeCE);
        c.addNeighbor(d, edgeCD);
        c.addNeighbor(f, edgeCF);
        d.addNeighbor(c, edgeCD);
        d.addNeighbor(f, edgeDF);
        e.addNeighbor(c, edgeCE);
        e.addNeighbor(f, edgeEF);
        f.addNeighbor(d, edgeDF);
        f.addNeighbor(c, edgeCF);
        f.addNeighbor(e, edgeEF);

        new PrimMST<>(Arrays.asList(a, b, c, d, e, f)).run();

        Integer minimum = Stream.of(edgeAB, edgeAC, edgeBC, edgeCD, edgeCF, edgeCE, edgeDF, edgeEF)
                .filter(Edge::isIncluded).map(Edge::getWeight).reduce(0, Integer::sum);
        System.out.println("Minimum Weight: " + minimum);

        int[][] weightsMatrix = {
                {0, 3, 2, INF, INF},
                {INF, 0, INF, 7, INF},
                {INF, INF, 0, INF, 4},
                {INF, INF, INF, 0, 6},
                {INF, 4, 5, INF, 0}
        };
        String[][] successorsMatrix = {
                {"-", "B", "C", "-", "-"},
                {"-", "-", "-", "D", "-"},
                {"-", "-", "-", "-", "E"},
                {"-", "-", "-", "-", "E"},
                {"-", "B", "C", "-", "-"}
        };
        new FloydWarshall(weightsMatrix, successorsMatrix).run();
    }
}
