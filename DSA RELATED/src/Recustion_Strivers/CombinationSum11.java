package Recustion_Strivers;
import java.util.*;
public class CombinationSum11 {

	public static void main(String[] args) {
		 int[] arr= {10,1,2,7,6,1,5};
		 ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
		 ArrayList<Integer> ds = new ArrayList<>();
		 int target=8;
		 Arrays.sort(arr);
		 findCombinations(0,arr,target,ds,ans);
		 System.out.println(ans);
	}
	
	public static void findCombinations(int ind,int[] arr,int target,ArrayList<Integer> ds,ArrayList<ArrayList<Integer>> ans) {
		
		if(target==0) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		
		
		for (int i=ind;i<arr.length;i++) {
			if(i>ind && arr[i]==arr[i-1]) continue;
			if(arr[i]>target) break;
			ds.add(arr[i]);
			findCombinations(i+1,arr,target-arr[i],ds,ans);
			ds.remove(ds.size()-1);
		}
		
		
		
	}
	

}
