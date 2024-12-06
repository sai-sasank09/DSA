package Recustion_Strivers;

import java.util.ArrayList;

public class CountsubSeqwithSumK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count[]= {0};
		ArrayList<Integer> lst= new ArrayList<Integer>();
		
		int[] arr= {1,2,3,4,5,6,7,8,9,10};
		int k=32;
		
//		subSeqWithSumK(arr,0,0,k,lst,count);
//		System.out.println("The count is "+ count[0]);
		System.out.println(oneSubSeqWithSumK(arr,0,0,k, lst));
	}
	public static void subSeqWithSumK(int[] arr, int i, int sum,int k,ArrayList<Integer> lst,int[] count) {
		if(i>=arr.length) {
			if(sum==k) {
				System.out.println(lst);
				count[0]++;
				
			}
			return;
		}
		lst.add(arr[i]);
		subSeqWithSumK(arr,i+1,sum+arr[i],k,lst,count);
		lst.remove(lst.size()-1);
		subSeqWithSumK(arr,i+1,sum,k,lst,count);		
	}
	private static int oneSubSeqWithSumK(int[] arr, int i, int sum,int k,ArrayList<Integer> lst) {
		if(i>=arr.length) {
			if(sum==k) {
//				System.out.println(lst);
				
//				ans.add(new ArrayList<>(lst));
				return 1;
				
				
			}
			
			else return 0;
		}
		lst.add(arr[i]);
		sum += arr[i];
		int left= oneSubSeqWithSumK(arr,i+1,sum,k,lst);
		
		sum -= arr[i];
		lst.remove(lst.size()-1);
		
		int right = oneSubSeqWithSumK(arr,i+1,sum,k,lst);
	
		return left+right;

}
}
