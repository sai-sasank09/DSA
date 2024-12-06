package Graphs;

import java.util.ArrayList;

public class DFS_detectCycle {
	 public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
		 int v= adj.size();
		 boolean visit[]= new boolean[v];
		 for (int i=0;i<v;i++) {
			 if(!visit[i]) {
				if(dfs(i,-1,v,adj,visit)) {
					return true;
				}
			 }
		 }
		 return false;
	 }

	private boolean dfs(int node, int prev, int v, ArrayList<ArrayList<Integer>> adj, boolean[] visit) {
		visit[node]=true;
		for (int adjNode : adj.get(node)) {
			if(!visit[adjNode])
			{
				if(dfs(adjNode,node,v,adj,visit)) {
					return true;
				}
				else if(prev != adjNode) {
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
