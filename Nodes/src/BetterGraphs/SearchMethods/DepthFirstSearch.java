package BetterGraphs.SearchMethods;

import BetterGraphs.Vertex;

import java.util.*;

public class DepthFirstSearch<T> {

    public void traverse(Vertex<T> root) {
        Deque<Vertex<T>> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Vertex<T> current = stack.pop();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current.getData());
                current.getAdjacentVertices().forEach(stack::push);
            }
        }
    }
}