package Graphs;

import java.util.LinkedList;
import java.util.List;

class ListRepresentation {
    private List<List<Integer>> adjacencyList;
    private int vertices;

    public ListRepresentation(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList<>();

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjacencyList.get(src).add(dest);
        adjacencyList.get(dest).add(src); // For undirected graph, comment out for directed graph
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer neighbor : adjacencyList.get(i)) {
                System.out.print(" -> " + neighbor);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ListRepresentation graph = new ListRepresentation(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        graph.printGraph();
    }
}

