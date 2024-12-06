package Graphs;
import java.util.*;
public class FindEventualSafeNodeDFS {
	 public List<Integer> eventualSafeNodes(int[][] graph) {
	        int v= graph.length;
	        int[] visit= new int[v];
	        int[] pathVisit= new int[v];
	        int[] check= new int[v];
	        for (int i=0;i<v;i++){
	            if (visit[i]==0){
	                dfs(i,graph,visit,pathVisit,check);
	            }
	        }
	        List<Integer> safeNodes= new ArrayList<>();
	        for (int i=0;i<v;i++){
	            if (check[i]==1){
	                safeNodes.add(i);
	            }
	        }
	        return safeNodes;
	    }
	    boolean dfs(int node, int[][] graph, int[] visit, int[] pathVis, int[] check){
	        visit[node]=1;
	        pathVis[node]=1;
	        check[node]=0;
	        for (int it:graph[node]){
	            if (visit[it]==0){
	               if( dfs(it,graph,visit,pathVis,check)){
	                return true;
	               }
	            }
	            else if (pathVis[it]==1){
	                return true;
	            }
	        }
	        check[node]=1;
	        pathVis[node]=0;
	        return false;
	    }
}
