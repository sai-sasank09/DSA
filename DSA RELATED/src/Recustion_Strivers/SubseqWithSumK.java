package Recustion_Strivers;
import java.util.*;
public class SubseqWithSumK {

	public static void main(String[] args) {
		int[] arr= {10,1,2,7,6,1,5};
		
		int k=8;
		ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> lst= new ArrayList<Integer>();
		subSeqWithSumK(arr,0,0,k,lst,ans);
		System.out.println(ans);
//		oneSubSeqWithSumK(arr,0,0,k,lst,ans);

	}

	private static void subSeqWithSumK(int[] arr, int i, int sum,int k,ArrayList<Integer> lst,ArrayList<ArrayList<Integer>> ans) {
		if(i>=arr.length) {
			if(sum==k) {
//				System.out.println(lst);
				ans.add(new ArrayList<>(lst));
				
			}
			return;
		}
		lst.add(arr[i]);
		sum += arr[i];
		subSeqWithSumK(arr,i+1,sum,k,lst,ans);
		
		sum -= arr[i];
		lst.remove(lst.size()-1);
		
		subSeqWithSumK(arr,i+1,sum,k,lst,ans);		
	}
	private static boolean oneSubSeqWithSumK(int[] arr, int i, int sum,int k,ArrayList<Integer> lst,ArrayList<ArrayList<Integer>> ans) {
		if(i>=arr.length) {
			if(sum==k) {
				System.out.println(lst);
				
//				ans.add(new ArrayList<>(lst));
				return true;
				
				
			}
			
			else return false;
		}
		lst.add(arr[i]);
		sum += arr[i];
		if(oneSubSeqWithSumK(arr,i+1,sum,k,lst,ans) == true) {
			return true;
		}
		
		sum -= arr[i];
		lst.remove(lst.size()-1);
		
		if(oneSubSeqWithSumK(arr,i+1,sum,k,lst,ans)==true) return true;	
		
		return false;
	}

}
