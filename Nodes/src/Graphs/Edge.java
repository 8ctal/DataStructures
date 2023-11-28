package Graphs;

public class Edge {
    private int v;
    private int u;

    private int weight;

    public Edge(int v, int u) {
        this.v = v;
        this.u = u;
    }

    public int getV() {
        return v;
    }

    public int getU() {
        return u;
    }
    public int getWeight() {
        return weight;
    }
}
