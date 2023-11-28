package BetterGraphs;

import java.util.*;

public class CycleDetection<T> {

    // This method works like a main method for disconnected graphs
    public boolean hasCycle(List<Vertex<T>> vertices) {
        for (Vertex<T> vertex : vertices) {
            if (!vertex.isVisited() && hasCycle(vertex, null)) {
                // If the vertex is not visited and has a cycle, return true
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle(Vertex<T> current, Vertex<T> parent) {
        current.setVisited(true); // Mark the current vertex as visited
        for (Vertex<T> adjacentVertex : current.getAdjacentVertices()) {
            // If the adjacent vertex is not visited, visit it and check if it has a cycle
            if (!adjacentVertex.isVisited()) {
                // If the adjacent vertex has a cycle, return true
                if (hasCycle(adjacentVertex, current)) {
                    return true;
                }
            } else if (!adjacentVertex.equals(parent)) {
                // If the adjacent vertex is visited and not is the parent, return true
                return true;
            }
        }
        return false; // If no cycle is found, return false
    }
}
