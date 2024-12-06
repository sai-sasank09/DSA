package Graphs;
import java.util.*;

public class DetectCycleUnDirected_BFS {

    class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        boolean[] visit = new boolean[v];
        for (int i = 0; i < v; i++) {
            visit[i] = false;
        }
        for (int i = 0; i < v; i++) {
            if (!visit[i]) {
                if (checkForCycle(i, v, adj, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForCycle(int src, int v, ArrayList<ArrayList<Integer>> adj, boolean[] visit) {
        visit[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int prev = q.peek().second;
            q.poll();
            for (int adjNode : adj.get(node)) {
                if (!visit[adjNode]) {
                    visit[adjNode] = true;
                    q.add(new Pair(adjNode, node));
                } else if (prev != adjNode) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 1); // Adding a cycle
        addEdge(adj, 3, 5);
        addEdge(adj, 3, 6);
        addEdge(adj, 6, 7);

        DetectCycleUnDirected_BFS cycleDetector = new DetectCycleUnDirected_BFS();
        if (cycleDetector.isCycle(adj)) {
            System.out.println("Cycle detected");
        } else {
            System.out.println("No cycle detected");
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
