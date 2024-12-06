package Graphs;
import java.util.*;

public class DetectCycleMatrix {
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static String cycleDetection(int[][] edges, int n, int m) {
        boolean[] visited = new boolean[n + 1]; // Correctly initializes visited array
        
       
        int[][] adjMatrix = new int[n + 1][n + 1];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjMatrix[u][v] = 1; // Undirected graph
            adjMatrix[v][u] = 1; // Undirected graph
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
               
                if (checkCycle(i, adjMatrix, visited, n)) {
                    return "Yes"; 
                }
            }
        }
        return "No"; 
    }

    public static boolean checkCycle(int src, int[][] edges, boolean[] visited, int n) {
        visited[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int prev = q.peek().second;
            q.poll();

            for (int adjNode = 1; adjNode <= n; adjNode++) { // Iterates correctly over 1-based index
                if (edges[node][adjNode] == 1) {
                    if (!visited[adjNode]) {
                        visited[adjNode] = true;
                        q.add(new Pair(adjNode, node));
                    } else if (prev != adjNode) {
                        return true; // Cycle detected
                    }
                }
            }
        }
        return false; // No cycle detected
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Number of test cases
        
     
             // Output: "Yes" or "No"
        
        int[][] edges= {{1,2},{2,3}};
        int n=3;
        int m=2;
        System.out.println(cycleDetection(edges, n, m));
        scanner.close();
    }
}
