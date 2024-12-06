package ShortestPathGraphsAlgo;
import java.util.*;
public class PrintShortedPathSRCtoDES {
	static class Pair{
		int first, second;
		Pair(int first, int second){
			this.first=first;
			this.second=second;
		}
	}
	public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
		 
	    List<List<Pair>> adj = new ArrayList<>();
	    for (int i = 0; i <= n; i++) {
	        adj.add(new ArrayList<>());
	    }
	    
	   
	    for (int i = 0; i < m; i++) {
	        adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
	        adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
	    }
	    PriorityQueue<Pair> pq= new PriorityQueue<>((x,y) -> x.first- y.first);
	    int[] dist= new int[n+1];
	    int[] parent= new int[n+1];
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    for (int i=1;i<=n;i++) {
	    	parent[i]=1;
	    	
	    }
	    dist[s]=0;
	    pq.add(new Pair(0,s));
	    while (!pq.isEmpty()) {
	    	Pair it= pq.poll();
	    	int distance= it.first;
	    	int node= it.second;
	    	for (Pair ptr: adj.get(node)) {
	    		int adjNode=ptr.first;
	    		int edjWe= ptr.second;
	    		if (distance + edjWe < dist[adjNode]) {
	    			dist[adjNode]=distance+ edjWe;
	    			pq.add(new Pair(dist[adjNode],adjNode));
	    			parent[adjNode]=node;
	    		}
	    	}
	    	
	    }
	    LinkedList<Integer> path= new LinkedList<>();
	    if (dist[t]==Integer.MAX_VALUE) {
	    	path.add(-1);
	    	return path;
	    }
	    int node=t;
	    while (node != parent[node]) {
	    	path.addFirst(node);
	    	node=parent[node];
	    }
	    path.addFirst(s);
	    return path;
	}

    public static void main(String[] args) {
        int n = 5; // Number of nodes
        int m = 6; // Number of edges
        int[][] edges = {
            {1, 2, 2},
            {1, 3, 4},
            {2, 4, 7},
            {3, 5, 3},
            {2, 3, 1},
            {4, 5, 1}
        };
        int source = 1;
        int target = 5;

        LinkedList<Integer> path = shortestPath(edges, n, m, source, target);
        System.out.println("Shortest path from " + source + " to " + target + ": " + path);
    }
}
