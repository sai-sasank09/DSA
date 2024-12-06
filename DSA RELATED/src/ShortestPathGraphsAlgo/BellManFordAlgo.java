package ShortestPathGraphsAlgo;

import java.util.*;

public class BellManFordAlgo {
    public static int[] bellmanFord(int n, int m, int src, List<List<Integer>> edges) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e8);  // Initialize distances to "infinity"
        dist[src] = 0;  // Set the source distance to zero

        // Relax edges n-1 times
        for (int i = 1; i < n; i++) {
            for (List<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);

                // Update dist[v] if a shorter path from src to v is found
                if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Check for negative-weight cycles
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);

            if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                return new int[]{-1};  // Negative cycle detected
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 5;  // Number of nodes
        int m = 8;  // Number of edges
        int src = 1;  // Source node

        List<List<Integer>> edges = new ArrayList<>();
        
        // Sample edges (u, v, weight)
        edges.add(Arrays.asList(1, 2, -1));
        edges.add(Arrays.asList(1, 3, 4));
        edges.add(Arrays.asList(2, 3, 3));
        edges.add(Arrays.asList(2, 4, 2));
        edges.add(Arrays.asList(2, 5, 2));
        edges.add(Arrays.asList(4, 2, 1));
        edges.add(Arrays.asList(4, 3, 5));
        edges.add(Arrays.asList(5, 4, -3));

        // Run Bellman-Ford algorithm
        int[] distances = bellmanFord(n, m, src, edges);

        // Print results
        if (distances.length == 1 && distances[0] == -1) {
            System.out.println("Graph contains a negative-weight cycle.");
        } else {
            System.out.println("Shortest distances from source " + src + ":");
            for (int i = 1; i <= n; i++) {
                System.out.println("Node " + i + " : " + (distances[i] == (int)1e8 ? "INF" : distances[i]));
            }
        }
    }
}
