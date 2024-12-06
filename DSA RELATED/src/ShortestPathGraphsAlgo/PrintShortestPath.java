package ShortestPathGraphsAlgo;
import java.util.*;
//1 to n
public class PrintShortestPath {
    class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        int dist[] = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = (int) (1e9);
            parent[i] = i;
        }
        dist[1] = 0;
        pq.add(new Pair(0, 1));
        while (!pq.isEmpty()) {
            Pair it = pq.peek();
            int dis = it.first;
            int node = it.second;
            pq.poll();
            for (Pair ptr : adj.get(node)) {
                int adjNode = ptr.first;
                int EdWeight = ptr.second;
                if (dis + EdWeight < dist[adjNode]) {
                    dist[adjNode] = dis + EdWeight;
                    pq.add(new Pair(dis + EdWeight, adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if (dist[n] == 1e9) {
            path.add(-1);
            return path;
        }
        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        PrintShortestPath obj = new PrintShortestPath();
        
        // Define the number of nodes (n), number of edges (m), and the edges with weights
        int n = 5; // for example, 5 nodes
        int m = 6; // for example, 6 edges
        int[][] edges = {
            {1, 2, 2},
            {1, 3, 4},
            {2, 4, 7},
            {3, 5, 3},
            {2, 3, 1},
            {4, 5, 1}
        };
        
        List<Integer> path = obj.shortestPath(n, m, edges);
        
        // Print the shortest path from node 1 to node n
        System.out.println("Shortest path from 1 to " + n + ": " + path);
    }
}
