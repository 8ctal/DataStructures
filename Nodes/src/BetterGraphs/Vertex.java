package BetterGraphs;

import java.util.*;
import java.util.stream.*;

public class Vertex<T> implements Comparable<Vertex<T>> {
    private final T data;
    private boolean visited;
    private Set<Vertex<T>> adjacentVertices = new HashSet<>(); // For Kruskal's Algorithm
    private Integer distance = Integer.MAX_VALUE; // For Dijkstra's Algorithm
    private List<Vertex<T>> shortestPath = new LinkedList<>(); // For Dijkstra's Algorithm
    private Map<Vertex<T>, Integer> adjacentVerticesWithWeights = new HashMap<>(); // For Dijkstra's Algorithm
    private List<Neighbor<T>> neighbors = new LinkedList<>(); // For Prim's Algorithm

    public Vertex(T data) {
        this.data = data;
        this.visited = false;
    }

    //GETTERS AND SETTERS
    public T getData() {
        return data;
    }

    public Set<Vertex<T>> getAdjacentVertices() {
        return adjacentVertices;
    }

    public Integer getDistance() {
        return distance;
    }

    public List<Vertex<T>> getShortestPath() {
        return shortestPath;
    }

    public List<Neighbor<T>> getNeighbors() {
        return neighbors;
    }

    public boolean isVisited() {
        return visited;
    }

    public Map<Vertex<T>, Integer> getAdjacentVerticesWithWeights() {
        return adjacentVerticesWithWeights;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setAdjacentVertices(Set<Vertex<T>> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public void setShortestPath(List<Vertex<T>> vertices) {
        this.shortestPath = vertices;
    }

    public void setNeighbors(List<Neighbor<T>> neighbors) {
        this.neighbors = neighbors;
    }

    //Kruskal's Algorithm

    public void addAdjacentVertex(Vertex<T> vertex) {
        adjacentVertices.add(vertex);
    }

    //Dijkstra's Algorithm
    public void addAdjacentVertexWithWeight(Vertex<T> vertex, Integer weight) {
        adjacentVerticesWithWeights.put(vertex, weight);
    }

    //For Dijkstra's Algorithm
    @Override
    //Override the method of Comparable Interface, to sort the vertices by distance
    public int compareTo(Vertex<T> vertex) {
        return Integer.compare(this.distance, vertex.getDistance());
    }

    //Prim's Algorithm
    public void addNeighbor(Vertex<T> vertex, Edge<T> edge) {
        neighbors.add(new Neighbor<T>(vertex, edge));
    }

    @Override
    public String toString() { //For Prim's Algorithm
        return "Vertex " + data + " -> " + neighbors.stream()
                .filter(n -> n.getVertex().isVisited() && n.getEdge().isIncluded())
                .map(n -> n.getVertex().getData() + "|" + n.getEdge().getWeight())
                .collect(Collectors.joining(" - "));
    }


}
