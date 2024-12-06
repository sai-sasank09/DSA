package Graphs;
import java.util.*;
public class BFS_ {
	List<List<Integer>> adjs;
	int vertices;
	
	BFS_(int vertices){
		this.vertices=vertices;
		adjs=new ArrayList<>();
		for (int i=0;i<=vertices;i++) {
			adjs.add(new ArrayList<>());
		}
	}
	public void addEdges(int a, int b) {
		adjs.get(a).add(b);
		adjs.get(b).add(a);
	}
	   public static List<Integer> bfsOfGraph(List<List<Integer>> adj) {
	        // code here
	        ArrayList<Integer> bfs= new ArrayList<>();
	        boolean visited[]= new boolean[adj.size()];
	        Queue<Integer> q= new LinkedList<>();
	        q.add(2);
	        visited[2]=true;
	        while (!q.isEmpty()){
	            Integer node=q.poll();
	            bfs.add(node);
	            for (Integer it: adj.get(node)){ 
	                if (visited[it] == false){
	                    visited[it]=true;
	                    q.add(it);
	                }
	            }
	        }
	        return bfs;
	    }
	   public static void main(String args[]) {
		   BFS_ graph= new BFS_(9);
		   graph.addEdges(1, 2);
		   graph.addEdges(1, 6);
		   graph.addEdges(2, 3);
		   graph.addEdges(2, 4);
		   graph.addEdges(4, 5);
		   graph.addEdges(6, 7);
		   graph.addEdges(7, 8);
		   graph.addEdges(6, 9);
		   System.out.println(graph.adjs);
		   System.out.println("BFS Traversal: " + bfsOfGraph(graph.adjs));
		   
	   }
	
	
}
