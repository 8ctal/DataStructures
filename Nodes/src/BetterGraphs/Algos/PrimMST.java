package BetterGraphs.Algos;

import BetterGraphs.*;

import java.util.*;

import static java.util.Comparator.comparingInt;

public record PrimMST<T>(List<Vertex<T>> graph) {

    public void run() {
        if (!graph.isEmpty()) graph.get(0).setVisited(true); //Start with the first vertex

        //While there are still unvisited vertices
        while (graph.stream().anyMatch(vertex -> !vertex.isVisited())) {
            //For each visited vertex, get the neighbor with the lowest weight
            graph.stream().filter(Vertex::isVisited)
                    .map(Vertex::getNeighbors)
                    .flatMap(Collection::stream)//Get all its neighbors
                    .filter(neighbor -> !neighbor.isVisited())//Filter out the visited ones
                    .min(comparingInt(n -> n.getEdge().getWeight()))//Get the one with the lowest weight
                    .ifPresent(candidate -> {
                        //Mark the vertex and edge as visited/included
                        candidate.getVertex().setVisited(true);
                        candidate.getEdge().setIncluded(true);
                    });
        }
        //Print the MST
        graph.forEach(System.out::println);
    }
}
