package ShortestPathGraphsAlgo;
import java.util.*;

public class FindTheCity {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        
        // Initialize distance matrix with "infinity"
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;  // Distance to itself is 0
        }

        // Fill initial distances from edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // Floyd-Warshall algorithm to compute shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Find the city with the minimum reachable cities within the distance threshold
        int cntMax = n;
        int cityNo = -1;
        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (dist[city][adjCity] <= distanceThreshold) {
                    cnt++;
                }
            }
            if (cnt <= cntMax) {
                cntMax = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }

    public static void main(String[] args) {
        FindTheCity fc = new FindTheCity();
        
        // Sample graph with nodes, edges, and distance threshold
        int n = 4;  // Number of cities (nodes)
        int[][] edges = {
            {0, 1, 3},
            {1, 2, 1},
            {2, 3, 4},
            {0, 3, 7}
        };
        int distanceThreshold = 4;

        int city = fc.findTheCity(n, edges, distanceThreshold);

        System.out.println("The city with the smallest number of neighbors within distance threshold is: " + city);
    }
}
