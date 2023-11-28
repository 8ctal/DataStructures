package BetterGraphs.Algos;

import java.util.stream.IntStream;

public class FloydWarshall {
    private final int nbrOfVertices;
    private final int[][] weightsMatrix;
    private final String[][] successorsMatrix;
    public final static int INF = Integer.MAX_VALUE; //Static int to represent the "∞" inf value

    public FloydWarshall(int[][] weightsMatrix, String[][] successorsMatrix) {
        this.weightsMatrix = weightsMatrix;
        this.successorsMatrix = successorsMatrix;
        //Get the number of vertices from the weights matrix
        nbrOfVertices = weightsMatrix[0].length;
    }

    public void run() throws Exception { //Throws exception if graph has a negative cycle
        IntStream.range(0, nbrOfVertices).forEach(intermediate ->
                IntStream.range(0, nbrOfVertices).forEach(start ->
                        IntStream.range(0, nbrOfVertices).forEach(end -> {
                            //Get the weight of the path from start to end via the intermediate node
                            int weight = getWeightViaInterNode(weightsMatrix, start, intermediate, end);
                            //If the weight is less than the current weight, update the weight and the successor
                            if (weight < weightsMatrix[start][end]) {
                                weightsMatrix[start][end] = weight;
                                successorsMatrix[start][end] = successorsMatrix[start][intermediate];
                            }
                        })
                )
        );
        for (int i = 0; i < nbrOfVertices; i++) {
            //If the weight of one element of the diagonal is negative, there is a negative cycle
            if (weightsMatrix[i][i] < 0) {
                throw new Exception("Graph has a negative cycle!!");
            }
        }
        print(weightsMatrix);
        print(successorsMatrix);
    }

    private int getWeightViaInterNode(int[][] matrix, int start, int intermediate, int end) {
        //If either of the weights is "∞", return "∞"
        return matrix[start][intermediate] == INF || matrix[intermediate][end] == INF
                ? INF : matrix[start][intermediate] + matrix[intermediate][end]; //Else return the sum of the weights
    }

    public void print(int[][] matrix) {
        System.out.println("Weights Matrix:");
        IntStream.range(0, nbrOfVertices).forEach(i -> {
            IntStream.range(0, nbrOfVertices).forEach(j ->
                    System.out.print(matrix[i][j] == INF ? "∞  " : matrix[i][j] + "  ")
            );
            System.out.println();
        });
        System.out.println();
    }

    public void print(String[][] matrix) {
        System.out.println("Successors Matrix:");
        IntStream.range(0, nbrOfVertices).forEach(i -> {
            IntStream.range(0, nbrOfVertices).forEach(j ->
                    System.out.print(matrix[i][j] + "  ")
            );
            System.out.println();
        });
        System.out.println();
    }
}

