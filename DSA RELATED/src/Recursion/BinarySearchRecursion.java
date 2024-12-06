package Recursion;

public class BinarySearchRecursion {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,3,6,9,17,25};
		int ans= Search(arr,9,0,arr.length-1);
		System.out.println(ans);
	}
	static int Search(int[] arr, int target,int start,int end) {
		
		if (start>end) {
			return -1;
		}
		int mid= start+ (end- start) / 2;
		if (arr[mid] == target) {
			return mid;
		}
		if(arr[mid] > target) {
			return Search(arr,target,start,mid-1);
			
		}
		return Search(arr,target,mid+1,end);
		
		
		
		
//		return -1;
		
	}

}
