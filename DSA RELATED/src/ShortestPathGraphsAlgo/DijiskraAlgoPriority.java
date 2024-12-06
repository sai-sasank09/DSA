package ShortestPathGraphsAlgo;

import java.util.*;
public class DijiskraAlgoPriority {
			
	//It doesnt work in - - -  Negative Weight & negative Cycle    
	static class Pairr {
        int first, second;

        Pairr(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> vec, int n, int m, int source) {
        // Create adjacency list
        ArrayList<ArrayList<Pairr>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list
        for (ArrayList<Integer> arr : vec) {
            int u = arr.get(0);
            int v = arr.get(1);
            int weight = arr.get(2);
            adj.get(u).add(new Pairr(v, weight));
            adj.get(v).add(new Pairr(u, weight)); // For undirected graph
        }

        // Priority queue for Dijkstra's algorithm
        PriorityQueue<Pairr> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        int[] dist = new int[n];

        // Initialize distance array
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        pq.add(new Pairr(0, source));

        while (!pq.isEmpty()) {
            Pairr it = pq.poll();
            int node = it.second;
            int dis = it.first;

            for (Pairr iter : adj.get(node)) {
                int adjNode = iter.first;
                int edgeWeight = iter.second;

                // Relaxation step
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pairr(dist[adjNode], adjNode));
                }
            }
        }

        // Create an ArrayList from the dist array and return it
        ArrayList<Integer> shortestDistances = new ArrayList<>();
        for (int distance : dist) {
            shortestDistances.add(distance);
        }

        return shortestDistances;
    }

    public static void main(String[] args) {
        // Hardcoded input
        int n = 5; // Number of vertices
        int m = 7; // Number of edges
        ArrayList<ArrayList<Integer>> vec = new ArrayList<>();

        // Edges in the format: [u, v, weight]
        vec.add(new ArrayList<>(Arrays.asList(0, 1, 7)));
        vec.add(new ArrayList<>(Arrays.asList(0, 2, 1)));
        vec.add(new ArrayList<>(Arrays.asList(0, 3, 2)));
        vec.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        vec.add(new ArrayList<>(Arrays.asList(1, 3, 5)));
        vec.add(new ArrayList<>(Arrays.asList(1, 4, 1)));
        vec.add(new ArrayList<>(Arrays.asList(3, 4, 7)));

        // Get shortest path distances from the source node (0)
        ArrayList<Integer> result = dijkstra(vec, n, m, 0);
        
        // Print distances
        for (int dist : result) {
            System.out.print(dist + " ");
        }
        System.out.println(); // New line for better output formatting
    }
}
