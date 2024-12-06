package Recustion_Strivers;

import java.util.ArrayList;
import java.util.List;

public class OptimisedPermu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3};
		
		List<List<Integer>> ans= new ArrayList<>();
		findPermutation(0,arr,ans);
		System.out.println(ans);
	}

	private static void findPermutation(int ind, int[] arr, List<List<Integer>> ans) {
		if(ind==arr.length) {
			  List<Integer> ds = new ArrayList<>();
	            for (int num : arr) {
	                ds.add(num);
	            }
	            ans.add(new ArrayList<>(ds));
	            return;
		}
		
		for(int i=ind;i<arr.length;i++) {
			swap(arr,ind,i);
			findPermutation(ind+1,arr,ans);
			swap(arr,ind,i);
		}
		
	}
	public  static void swap(int[] arr, int a, int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}

}
