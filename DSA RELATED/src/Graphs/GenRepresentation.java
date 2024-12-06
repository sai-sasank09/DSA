	package Graphs;
import java.util.*;
public class GenRepresentation {

	public static void main(String[] args) {
		int n=3;
		int v=3;
		int[][] adj= new int[n+1][n+1];
		//undirected graph :)
		//edge 1--2
		adj[1][2]=1;
		adj[2][1]=1;
		//edge 2--3
		adj[2][3]=1;
		adj[3][2]=1;
		//edge 3--1
		adj[3][1]=1;
		adj[1][3]=1;
		
		//Method 2 using lists this is efficient 
		List<List<Integer>> adjs= new ArrayList<>();
		for (int i=0;i<=n;i++) {
			adjs.add(new ArrayList<Integer>());
		}
		//edge 1--2
		adjs.get(1).add(2);
		adjs.get(2).add(1);
		//edge 2--3
		adjs.get(2).add(3);
		adjs.get(3).add(2);
//		System.out.println(adjs);
		for (int i=1;i<n;i++) {
			for (int j=0;j<adjs.get(i).size();j++) {
				System.out.print(adjs.get(i).get(j)+" ");
				
			}
		}
	}

}
