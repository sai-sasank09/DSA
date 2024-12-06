package Recustion_Strivers;
import java.util.*;
public class Combination1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {13,2,3,17};
		int tar=14;
		ArrayList<Integer> lst= new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
		combinationSum(arr,0,tar,lst,ans);
		
		System.out.println(ans);
	}

	private static void combinationSum(int[] arr, int i, int tar, ArrayList<Integer> lst,ArrayList<ArrayList<Integer>> ans) {
		if(tar ==0) {
//			System.out.println(lst);
			Collections.reverse(lst);
			ans.add(new ArrayList<>(lst));
			return;
		}
		if(0 > tar || i>= arr.length) {
			return;
		}
		
		lst.add(arr[i]);
		combinationSum(arr,i,tar-arr[i],lst,ans);
		lst.remove(lst.size()-1);
		combinationSum(arr,i+1,tar,lst,ans);
	}
	

}
