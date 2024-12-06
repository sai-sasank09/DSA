package Graphs;
import java.util.*;
public class DetectCycleinDirectedGraph {
	
	ArrayList<ArrayList<Integer>> adjs;
	int v;
	public DetectCycleinDirectedGraph(int v) {
		adjs=new ArrayList<>();
		this.v=v;
		for (int i=0;i<=v;i++) {
			adjs.add(new ArrayList<>());
		}
	}
	public void addEdge(int a,int b) {
		adjs.get(a).add(b);
	}
	private boolean isCyclic() {
		int[] vis= new int[v+1];
		int[] pathVis= new int[v+1];
		for(int i=1;i<=v;i++) {
			if(vis[i]==0) {
				if(dfsCheck(i,adjs,vis,pathVis)==true) {
					return true;
				}
			}
		}
		return false;
	}
	 private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adjs, int[] vis, int[] pathVis) {
		vis[node]=1;
		pathVis[node]=1;
		for(int it: adjs.get(node)) {
			if(vis[node]==0) {
				if(dfsCheck(it,adjs,vis,pathVis) ==true) {
					return true;
				}
			}
			
			else if (pathVis[it]==1) {
				return true;
			}
		}
		pathVis[node]=0;
		return false;
	}
	public static void main(String[] args) {
	        DetectCycleinDirectedGraph graph = new DetectCycleinDirectedGraph(10);
	        graph.addEdge(1, 2);
	        graph.addEdge(2, 3);
	        graph.addEdge(3, 4);
	        graph.addEdge(3, 7);
	        graph.addEdge(4, 5);
	        graph.addEdge(5, 6);
	        graph.addEdge(7, 5);
	        graph.addEdge(8, 9);
	        graph.addEdge(9, 10);
	        graph.addEdge(10, 8);
	        graph.addEdge(8, 2);
	        System.out.println(graph.adjs);
	       
	        boolean hasCycle = graph.isCyclic();
	        System.out.println("Does the graph contain a cycle? " + hasCycle);
	        
	    }
	
	
}
