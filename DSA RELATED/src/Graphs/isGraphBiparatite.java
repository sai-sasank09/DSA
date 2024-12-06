package Graphs;
import java.util.*;
public class isGraphBiparatite {
	   public static Boolean isBipartite(int n, int edges[][]) {
	       ArrayList<ArrayList<Integer>> adjs= new ArrayList<>();
	       for (int i=0;i<n;i++){
	           adjs.add(new ArrayList<>());
	       }
	       for (int i=0;i<edges.length;i++){
	               int u=edges[i][0];
	               int v=edges[i][1];
	               adjs.get(u).add(v);
	               adjs.get(v).add(u);
	           
	       }
	        // System.out.println(adjs);
	        int[] color = new int[n];
	        Arrays.fill(color,-1);
	        for (int i=0;i<n;i++){
	            if (color[i]==-1){
	                if (check(i, adjs, color)==false) return false;
	            }
	        }

	        return true;

	    }
	    static boolean check(int node, ArrayList<ArrayList<Integer>> adjs,int[] color){
	        Queue<Integer> q= new LinkedList<>();
	        q.add(node);
	        color[node]=0;
	        while(!q.isEmpty()){
	            int curr= q.peek();
	            q.poll();

	            for (int it: adjs.get(curr)){
	                if(color[it]==-1){
	                    color[it]=1-color[curr];
	                    q.add(it);
	                }
	                else if (color[it]==color[curr]){
	                    return false;
	                }
	            }

	        }
	        return true;
	    }
	    public static void main(String[] args) {
	    	int[][] edges= {{0, 1},{0, 3},{1, 2}}; 
	    	System.out.println(isBipartite(4, edges));
	    }
}
