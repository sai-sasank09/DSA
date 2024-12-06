package ShortestPathGraphsAlgo;

import java.util.*;

public class NetworkDelayTime {
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adjs = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjs.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];
            adjs.get(u).add(new Pair(v, t));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);
        int dist[] = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().first;
            int time = pq.peek().second;
            pq.poll();
            if (time > dist[node]) {
                continue;
            }

            for (Pair it : adjs.get(node)) {
                int adjNode = it.first;
                int edW = it.second;
                if (time + edW < dist[adjNode]) {
                    dist[adjNode] = time + edW;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        int maxTime = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }

    public static void main(String[] args) {
        NetworkDelayTime obj = new NetworkDelayTime();

        // Example graph (times array) and parameters
        int[][] times = {
            {2, 1, 1},
            {2, 3, 1},
            {3, 4, 1}
        };
        int n = 4;  // Number of nodes
        int k = 2;  // Start node

        int result = obj.networkDelayTime(times, n, k);
        System.out.println("The network delay time is: " + result);  // Expected output: 2
    }
}
