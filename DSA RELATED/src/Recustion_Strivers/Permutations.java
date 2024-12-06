package Recustion_Strivers;
import java.util.*;
public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3};
		List<Integer> ds= new ArrayList<>();
		List<List<Integer>> ans= new ArrayList<>();
		boolean[] map=new boolean[arr.length];
		findPermutation(arr,ds,ans,map);
//		System.out.println(ans);
	}

	private static void findPermutation(int[] arr, List<Integer> ds, List<List<Integer>> ans,boolean[] map) {
		// TODO Auto-generated method stub
		if(ds.size()==arr.length) {
//			System.out.println(ds);
			ans.add(new ArrayList<>(ds));
			return;
		}
		
		
		for(int i=0;i<arr.length;i++) {
			if(!map[i]) {
				map[i]=true;
				ds.add(arr[i]);
				findPermutation(arr,ds,ans,map);
				ds.remove(ds.size()-1);
				map[i]=false;
			}
		}
		
		
	}

}
