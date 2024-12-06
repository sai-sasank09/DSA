package ShortestPathGraphsAlgo;
import java.util.*;

public class CheapestFlight {
	class Pair {
		int first;
		int second;
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	class Tuple {
		int first, second, third;
		Tuple(int first, int second, int third) {
			this.first = first;
			this.second = second;
			this.third = third;
		}
	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		int m = flights.length;
		for (int i = 0; i < m; i++) {
			adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
		}

		Queue<Tuple> q = new LinkedList<>();
		int dist[] = new int[n];
		Arrays.fill(dist, (int) 1e9);
		dist[src] = 0;
		q.add(new Tuple(0, src, 0));

		while (!q.isEmpty()) {
			int stops = q.peek().first;
			int node = q.peek().second;
			int cost = q.peek().third;
			q.poll();
			if (stops > k) continue;
			for (Pair it : adj.get(node)) {
				int adjNode = it.first;
				int adjCost = it.second;

				if (cost + adjCost < dist[adjNode] && stops <= k) {
					dist[adjNode] = adjCost + cost;
					q.add(new Tuple(stops + 1, adjNode, dist[adjNode]));
				}
			}
		}
		return dist[dst] == (int) 1e9 ? -1 : dist[dst];
	}

	public static void main(String[] args) {
		CheapestFlight solver = new CheapestFlight();
		int n = 4;  // Number of nodes (cities)
		int[][] flights = {
			{0, 1, 100}, 
			{1, 2, 100}, 
			{2, 3, 100}, 
			{0, 3, 500}
		};
		int src = 0;   // Starting city
		int dst = 3;   // Destination city
		int k = 1;     // Maximum stops allowed

		int cheapestPrice = solver.findCheapestPrice(n, flights, src, dst, k);
		System.out.println("The cheapest price is: " + cheapestPrice);
	}
}
