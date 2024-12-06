package GraphMinSpaning_DisJoint;
import java.util.*;
public class MinimumSpanningTree {
	static class Pair{
		int first,second;
		Pair(int first, int second){
			this.first= first;
			this.second= second;
		}
	}
	public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
		//Your code goes here
		ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
		for (int i=0;i<n;i++){
			adj.add(new ArrayList<>());
		}
		for (ArrayList<Integer> edge: edges){
			int u= edge.get(0);
			int v= edge.get(1);
			int wt= edge.get(2);
			adj.get(u).add(new Pair(v,wt));
			adj.get(v).add(new Pair(u,wt));
		}
		return 0;
		
		
	}
}
