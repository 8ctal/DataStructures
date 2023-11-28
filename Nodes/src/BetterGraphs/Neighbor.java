package BetterGraphs;

public class Neighbor<T> {
    private final Vertex<T> vertex;
    private final Edge<T> edge;

    public Neighbor(Vertex<T> vertex, Edge<T> edge) {
        this.vertex = vertex;
        this.edge = edge;
    }

    public boolean isVisited() {
        return edge.isIncluded() || vertex.isVisited();
    }

    public Edge<T> getEdge() {
        return edge;
    }

    public Vertex<T> getVertex() {
        return vertex;
    }

}
