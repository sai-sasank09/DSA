package Arrays;
import java.util.*;

public class Union {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int m=5;
		int[] arr1= {1,2,3,4,5};
		int[] arr2= {1,2,3,6,7};
		Set<Integer> ans=UnionOfArrays(arr1,arr2);
		System.out.println(ans);
	}

	private static Set<Integer> UnionOfArrays(int[] arr1, int[] arr2) {
		Set<Integer> ans= new HashSet<Integer>();
		for (int val : arr1) {
			ans.add(val);
		}
		for (int val1: arr2) {
			ans.add(val1);
		}
		return ans;
	}

}
