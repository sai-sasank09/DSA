package Recustion_Strivers;
import java.util.*;
public class Subset2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,2};
		Arrays.sort(arr);
		ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
		subSets(0,arr,new ArrayList<>(),ans);
		System.out.println(ans);
	}

	private static void subSets(int ind,int[] arr, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ans) {
		// TODO Auto-generated method stub
		ans.add(new ArrayList<>(ds));
		
		for (int i=ind;i<arr.length;i++) {
			if(i!=ind && arr[i-1] == arr[i]) continue;
			ds.add(arr[i]);
			subSets(i+1,arr,ds,ans);
			ds.remove(ds.size()-1);
		}
	}

}
