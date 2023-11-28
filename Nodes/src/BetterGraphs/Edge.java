package BetterGraphs;

public class Edge<T> implements Comparable<Edge<T>> {
    private final Vertex<T> from;
    private final Vertex<T> to;
    private final int weight; // For Kruskal's Algorithm
    private boolean included; // For Prim's Algorithm

    //Constructor for Kruskal's Algorithm
    public Edge(Vertex<T> from, Vertex<T> to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    //Constructor for Prim's Algorithm
    public Edge(int weight) {
        this.from = null;
        this.to = null;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge<T> edge) {
        //Override the method of Comparable Interface, to sort the edges by weight
        return Integer.compare(this.weight, edge.getWeight());
    }

    public Vertex<T> getFrom() {
        return from;
    }

    public Vertex<T> getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isIncluded() {
        return included;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from.getData() +
                ", to=" + to.getData() +
                ", weight=" + weight +
                '}';
    }
}
