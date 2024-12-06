package Graphs;
import java.util.*;
public class DFS {
	List<List<Integer>> adj= new ArrayList<>();
	int vertices;
	DFS(int vertices){
		this.vertices=vertices;
		adj= new ArrayList<>();
		for (int i=0;i<=vertices;i++) {
			adj.add(new ArrayList<>());
		}
	}
	public void addEdge(int a,int b) {
		adj.get(a).add(b);
		adj.get(b).add(a);
	}
	public static List<Integer> dfsGraph(int v,List<List<Integer>> adjs){
		boolean visit[]= new boolean[v+1];
		visit[0]=true;
		List<Integer> lst= new ArrayList<>();
		dfs(1,visit,adjs,lst);
		return lst;
	}
	
	public static void dfs(int node,boolean[] visit, List<List<Integer>> adjs, List<Integer> lst) {
		visit[node]=true;
		lst.add(node);
		for (Integer it : adjs.get(node)) {
			if(visit[it]==false) {
				
				dfs(it,visit,adjs,lst);
			}
		}
	}
	
	public static void main(String args[]) {
		DFS graph= new DFS(8);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2,5);
		graph.addEdge(2,6);
		graph.addEdge(3, 7);
		graph.addEdge(3, 4);
		graph.addEdge(7, 8);
		graph.addEdge(4, 8);
		System.out.println(graph.adj);
		
		System.out.println(dfsGraph(graph.vertices,graph.adj));
	}
}
