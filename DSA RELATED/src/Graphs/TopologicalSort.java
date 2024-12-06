package Graphs;
import java.util.*; 
import java.io.*; 

public class TopologicalSort {
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        // Initialize adjacency list for directed graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate adjacency list based on directed edges
        for (ArrayList<Integer> lst : edges) {
            int u = lst.get(0);
            int w = lst.get(1);
            adj.get(u).add(w);  // Correctly add directed edge from u to w
        }

        // Initialize visitation array and stack
        int[] visit = new int[v];
        Stack<Integer> stk = new Stack<>();

        // Perform DFS for each unvisited node
        for (int i = 0; i < v; i++) {
            if (visit[i] == 0) {
                dfs(i, visit, stk, adj);
            }
        }

        // Collect nodes in topological order
        ArrayList<Integer> ans = new ArrayList<>();
        while (!stk.isEmpty()) {
            ans.add(stk.pop());
        }
        return ans;
    }

    // Helper DFS function for topological sorting
    static void dfs(int node, int[] visit, Stack<Integer> stk, ArrayList<ArrayList<Integer>> adj) {
        visit[node] = 1;
        for (int it : adj.get(node)) {
            if (visit[it] == 0) {
                dfs(it, visit, stk, adj);
            }
        }
        stk.push(node);  // Push node to stack after all adjacent nodes are processed
    }
}
