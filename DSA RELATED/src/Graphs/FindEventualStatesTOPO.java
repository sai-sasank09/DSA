package Graphs;
import java.util.*;

public class FindEventualStatesTOPO {

    List<Integer> eventualSafeStates(int v, List<List<Integer>> adj) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjRev.add(new ArrayList<>());
        }
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)) {
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }

    public static void main(String[] args) {
        FindEventualStatesTOPO graph = new FindEventualStatesTOPO();
        int v = 5; // number of vertices
        List<List<Integer>> adj = new ArrayList<>();

        // Adjacency list representation of the graph
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph: you can modify edges as needed
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(0);
        adj.get(3).add(4);

        List<Integer> safeNodes = graph.eventualSafeStates(v, adj);
        System.out.println("Safe nodes: " + safeNodes);
    }
}
