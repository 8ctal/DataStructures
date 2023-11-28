package BetterGraphs.Algos;

import BetterGraphs.*;

import java.util.*;
import java.util.stream.Stream;

public class KruskalMST<T> {
    private final PriorityQueue<Edge<T>> graph; //PriorityQueue for a natural order of the Edges, using the method compareTo
    private final List<Vertex<T>> vertices; //List of the vertices in the graph
    private final int numVertices;

    public KruskalMST(List<Edge<T>> graph) {
        this.graph = new PriorityQueue<>(graph); //PriorityQueue for a natural order of the Edges
        //Can't use the vertices from the graph, because they don't have the adjacentVertices
        this.vertices = getVerticesInGraph();
        this.numVertices = vertices.size();
    }

    private List<Vertex<T>> getVerticesInGraph() {
        return Stream.concat( //Concatenate the Stream of the from vertices with the Stream of the to vertices
                graph.stream().map(Edge::getFrom),
                graph.stream().map(Edge::getTo)
        ).distinct().toList(); //Get the distinct vertices
    }

    public void run() {
        List<Edge<T>> mst = new ArrayList<>();
        do {
            Edge<T> edge = graph.poll(); //Get the edge with the minimum weight
            resetTree(Stream.concat(mst.stream(), Stream.of(edge)).toList()); //Reset the tree with the edges in the MST
            if (!new CycleDetection<T>().hasCycle(vertices)) { //If the edge doesn't create a cycle
                mst.add(edge);
            }
        } while (mst.size() < numVertices - 1); //The MST has numVertices - 1 edges
        printMST(mst);
    }

    private void resetTree(List<Edge<T>> mst) {
        vertices.forEach(vertex -> { //Set all the vertices as unvisited and without adjacent vertices
            vertex.setVisited(false);
            vertex.setAdjacentVertices(new HashSet<>());
        });
        mst.forEach(edge -> { //Add the adjacent vertices
            edge.getFrom().addAdjacentVertex(edge.getTo());
            edge.getTo().addAdjacentVertex(edge.getFrom());
        });
    }

    private void printMST(List<Edge<T>> mst) {
        Integer minCost = mst.stream() //Get the sum of the weights of the edges in the MST
                .map(Edge::getWeight)
                .reduce(0, Integer::sum);
        mst.forEach(System.out::println);
        System.out.println("Minimum Spanning Tree Weight:" + minCost);
    }
}
