package ShortestPathGraphsAlgo;
import java.util.*;

public class ShortestPathUnGraphUnitWeight {
    public int[] shortestPath(int[][] edge, int n, int m, int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edge[i][0]).add(edge[i][1]);
            adj.get(edge[i][1]).add(edge[i][0]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : adj.get(node)) {
                if (dist[node] + 1 < dist[neighbor]) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
    	ShortestPathUnGraphUnitWeight sp = new ShortestPathUnGraphUnitWeight();

        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 2},
            {1, 3}
        };
        int n = 4;  // Number of vertices
        int m = edges.length;  // Number of edges
        int src = 0;  // Source node

        int[] shortestDistances = sp.shortestPath(edges, n, m, src);

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + " : " + shortestDistances[i]);
        }
    }
}

