package ShortestPathGraphsAlgo;
import java.util.*;

public class ShortestPathinDAG {
    static class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
       for (int i = 0; i < n; i++) {
           adj.add(new ArrayList<>());
       }
       for (int i = 0; i < m; i++) {
           int a = edges[i][0];
           int b = edges[i][1];
           int wt = edges[i][2];
           adj.get(a).add(new Pair(b, wt));
       }
       int[] visit = new int[n];
       Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (visit[i] == 0) {
                toposort(i, adj, stk, visit);
            }
        }
        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) 1e9;
        }
        dist[0] = 0;
        while (!stk.isEmpty()) {
            int node = stk.pop();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;
                if (dist[node] + wt < dist[v]) {
                    dist[v] = wt + dist[node];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    static void toposort(int node, ArrayList<ArrayList<Pair>> adj, Stack<Integer> stk, int[] vis) {
        vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).first;
            if (vis[v] == 0) {
                toposort(v, adj, stk, vis);
            }
        }
        stk.add(node);
    }

    public static void main(String[] args) {
        int n = 6; // Number of nodes
        int m = 7; // Number of edges
        int[][] edges = { {0, 1, 2}, {0, 4, 1}, {1, 2, 3}, {4, 2, 2}, {4, 5, 4}, {2, 3, 6}, {5, 3, 1} };
        
        int[] shortestPaths = shortestPathInDAG(n, m, edges);

        System.out.println("Shortest path distances from source node 0:");
        for (int i = 0; i < shortestPaths.length; i++) {
            System.out.println("Node " + i + ": " + shortestPaths[i]);
        }
    }
}
