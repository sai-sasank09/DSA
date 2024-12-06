package Recustion_Strivers;
import java.util.*;
public class CombinationSum_nodup {
///not a efficient method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,1,2,7,6,1,5};
		int tar=8;
		ArrayList<Integer> lst= new ArrayList<Integer>();
		Set<ArrayList<Integer>> val= new HashSet<>();
		ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
		
		combinationSum(arr,0,tar,lst,ans);
		for (ArrayList<Integer> num: ans) {
			Collections.sort(num);
		}
		for (ArrayList<Integer> num: ans) {
			val.add(num);
		}
		System.out.println(val);
	}

	private static void combinationSum(int[] arr, int i, int tar, ArrayList<Integer> lst,ArrayList<ArrayList<Integer>> ans) {
		if(tar ==0) {
//			System.out.println(lst);
			ans.add(new ArrayList<>(lst));
			return;
		}
		if(0 > tar || i>= arr.length ) {
			return;
		}
		
		lst.add(arr[i]);
		combinationSum(arr,i+1,tar-arr[i],lst,ans);
		lst.remove(lst.size()-1);
		combinationSum(arr,i+1,tar,lst,ans);
	}
	

}
