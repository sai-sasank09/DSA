package GraphMinSpaning_DisJoint;
import java.util.*;

public class PrismsAlgo {
    static class Pair {
        int node, distance;
        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    
    public static int Prime_MST(ArrayList<ArrayList<Integer>> edges, int n) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] vis = new int[n];
        pq.add(new Pair(0, 0)); // Start from node 0 with distance 0
        int sum = 0;
        
        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int wt = pq.peek().distance;
            pq.poll();
            
            if (vis[node] == 1) continue;
            
            vis[node] = 1;
            sum += wt;
            
            for (Pair iter : adj.get(node)) {
                int adjNode = iter.node;
                int edW = iter.distance;
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(adjNode, edW));
                }
            }
        }
        
        return sum;
    }
    public static ArrayList<ArrayList<Integer>> getMSTEdges(ArrayList<ArrayList<Integer>> edges, int n) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] vis = new int[n];
        pq.add(new Pair(0, 0)); // Start from node 0 with distance 0
        
        ArrayList<ArrayList<Integer>> mstEdges = new ArrayList<>();
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int wt = pq.peek().distance;
            pq.poll();
            
            if (vis[node] == 1) continue;
            
            vis[node] = 1;
            
            if (parent[node] != -1) {
                ArrayList<Integer> mstEdge = new ArrayList<>(Arrays.asList(parent[node], node, wt));
                mstEdges.add(mstEdge);
            }
            
            for (Pair iter : adj.get(node)) {
                int adjNode = iter.node;
                int edW = iter.distance;
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(adjNode, edW));
                    parent[adjNode] = node;
                }
            }
        }
        System.out.println(Arrays.toString(parent));
        return mstEdges;
    }
    
    public static void main(String[] args) {
        // Example usage
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        int n = 5; // Number of nodes in the graph

        // Adding edges in the format {u, v, weight}
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 2)));
        edges.add(new ArrayList<>(Arrays.asList(0, 3, 6)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        edges.add(new ArrayList<>(Arrays.asList(1, 3, 8)));
        edges.add(new ArrayList<>(Arrays.asList(1, 4, 5)));
        edges.add(new ArrayList<>(Arrays.asList(2, 4, 7)));
        
        int mstWeight = Prime_MST(edges, n);
        ArrayList<ArrayList<Integer>> mstEdges = getMSTEdges(edges, n);
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (ArrayList<Integer> edge : mstEdges) {
            System.out.println("Edge from " + edge.get(0) + " to " + edge.get(1) + " with weight " + edge.get(2));
        }
        System.out.println("Total weight of the Minimum Spanning Tree: " + mstWeight);
    }
}
