package Recustion_Strivers;
import java.util.*;
public class Combination3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=3;
		int n=7;
		List<List<Integer>> ans= new ArrayList<>();
		List<Integer> ds= new ArrayList<>();
		findCombinations(1,k,n,ds,ans);
		System.out.println(ans);
	}

	private static void findCombinations(int ind, int k, int n,List<Integer> ds, List<List<Integer>> ans) {
		if(k==0 && n==0) {
//			System.out.println(ds);
			ans.add(new ArrayList<>(ds));
			return;
		}
		if(n<0 || k<0) {
			return;
		}
		
		for (int i=ind;i<=9;i++) {
			ds.add(i);
			findCombinations(i+1,k-1,n-i,ds,ans);
			ds.remove(ds.size()-1);
		}
		
		
	}
	

}
