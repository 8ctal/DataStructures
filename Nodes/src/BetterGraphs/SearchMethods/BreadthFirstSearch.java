package BetterGraphs.SearchMethods;

import BetterGraphs.Vertex;

import java.util.*;

public class BreadthFirstSearch<T> {
    private final Vertex<T> root;

    public BreadthFirstSearch(Vertex<T> root) {
        this.root = root;
    }

    public void traverse() {
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current.getData());
                queue.addAll(current.getAdjacentVertices());
            }
        }
    }
}
