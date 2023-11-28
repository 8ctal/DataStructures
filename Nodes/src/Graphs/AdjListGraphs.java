package Graphs;

import java.util.*;

public class AdjListGraphs {
    private int V; // number of vertices
    private int E; // number of edges
    private LinkedList<Integer>[] adjList;

    public AdjListGraphs(int vertices) {
        this.V = vertices;
        this.E = 0;
        this.adjList = new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adjList[v] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int u) {
        if (v < 0 || v >= V || u < 0 || u >= V) {
            throw new IllegalArgumentException();
        }
        adjList[v].add(u);
        adjList[u].add(v);
        E++;
    }

    public void print() {
        System.out.println("V = " + V + ", E = " + E);
        for (int v = 0; v < V; v++) {
            System.out.print(v + ": ");
            for (int u : adjList[v]) {
                System.out.print(u + " ");
            }
            System.out.println();
        }
    }

    public void traverseBFS(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int u : adjList[v]) {
                if (!visited[u]) {
                    visited[u] = true;
                    queue.add(u);
                }
            }
        }
        System.out.println();
    }
    public void traverseDFS(int s) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        visited[s] = true;
        stack.push(s);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            System.out.print(v + " ");
            for (int u : adjList[v]) {
                if (!visited[u]) {
                    visited[u] = true;
                    stack.push(u);
                }
            }
        }
        System.out.println();
    }

    public void kruskalMST() {  // Minimum Spanning Tree
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int v = 0; v < V; v++) {
            for (int u : adjList[v]) {
                pq.add(new Edge(v, u));
            }
        }
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        int count = 0;
        while (!pq.isEmpty() && count < V - 1) {
            Edge e = pq.poll();
            int v = e.getV();
            int u = e.getU();
            int pv = find(parent, v);
            int pu = find(parent, u);
            if (pv != pu) {
                parent[pv] = pu;
                System.out.println(v + " - " + u);
                count++;
            }
        }
    }
    public int find(int[] parent, int v) {
        if (parent[v] == v) {
            return v;
        }
        return find(parent, parent[v]);
    }
}
