package ShortestPathGraphsAlgo;
import java.util.*;;

public class NumberOfWaysToArriveDestination {
	 class Pair {
	        long first;
	        int second;
	        
	        Pair(long first, int second) {
	            this.first = first;
	            this.second = second;
	        }
	    }

	    public int countPaths(int n, int[][] roads) {
	        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            adj.add(new ArrayList<>());
	        }

	        int m = roads.length;
	        for (int i = 0; i < m; i++) {
	            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
	            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
	        }

	        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.first, y.first));
	        int mod = (int) (1e9 + 7);
	        long[] dist = new long[n];
	        int[] ways = new int[n];

	        Arrays.fill(dist, Long.MAX_VALUE);
	        dist[0] = 0;
	        ways[0] = 1;
	        pq.add(new Pair(0, 0));

	        while (!pq.isEmpty()) {
	            long distance = pq.peek().first;
	            int node = pq.peek().second;
	            pq.poll();

	            for (Pair it : adj.get(node)) {
	                int adjNode = (int) it.first;
	                long edgeWeight = it.second;

	                if (distance + edgeWeight < dist[adjNode]) {
	                    dist[adjNode] = distance + edgeWeight;
	                    pq.add(new Pair(dist[adjNode], adjNode));
	                    ways[adjNode] = ways[node];
	                } else if (distance + edgeWeight == dist[adjNode]) {
	                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
	                }
	            }
	        }

	        return ways[n - 1];
	    }
	    public static void main(String[] args) {
	        NumberOfWaysToArriveDestination solution = new NumberOfWaysToArriveDestination();

	        // Example input
	        int n = 5; // Number of nodes
	        int[][] roads = {
	            {0, 1, 10}, 
	            {0, 2, 5}, 
	            {1, 2, 2}, 
	            {1, 3, 1}, 
	            {2, 3, 9}, 
	            {2, 4, 2}, 
	            {3, 4, 4}
	        };

	        // Calling countPaths method and printing the result
	        int result = solution.countPaths(n, roads);
	        System.out.println("Number of ways to reach destination: " + result);
	    }


}
