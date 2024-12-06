package Graphs;

import java.util.*;

class Edge {
    int vertex;
    int weight; 

    Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "(" + vertex + ", " + weight + ")";
    }
}

public class WeightedGraph {
    private ArrayList<ArrayList<Edge>> adjList; 

    
    public WeightedGraph(int vertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>()); 
        }
    }

   
    public void addEdge(int from, int to, int weight) {
        adjList.get(from).add(new Edge(to, weight)); 
        adjList.get(to).add(new Edge(from, weight));
    }

    // Method to print the adjacency list
    public void printGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + ": ");
            for (Edge edge : adjList.get(i)) {
                System.out.print(" -> " + edge); // This will call the overridden toString() method
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(5); // Create a graph with 5 vertices

        // Adding edges with weights
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 50);
        graph.addEdge(1, 2, 20);
        graph.addEdge(1, 3, 30);
        graph.addEdge(1, 4, 32);
        graph.addEdge(2, 3, 40);
        graph.addEdge(3, 4, 35);
        
//              10
//        0 --------- 1
//        | \        /| \
//      50|  \30   20 |  \32
//        |   \    /  |   \
//        |    \  /   |    \
//        4 --------- 2     3
//               40     | 
//                      |
//                      35

        // Print the adjacency list directly
        System.out.println(graph.adjList);
        
        // Print the graph in a structured way
        graph.printGraph();
    }
}
