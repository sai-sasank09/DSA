package Searching;

public class CeilingN {

	public static void main(String[] args) {
		
		int[] arr= {2,3,4,5,6,7,8,9};
		int ans=CeilingBs(arr,10);
		System.out.print(ans);
	}
	//return the index of smallest no >= target
	static int CeilingBs(int[] arr, int target) {
		// but what if the target is greater than the greatest number in array
		if (target>arr[arr.length-1]) {
			return -1;
		}
		
		int start=0;
		int end=arr.length-1;
		
		while(start<=end) {
//			int mid=(start+end)/2;
			int mid= start + (end-start )/2;
			
			if (target< arr[mid]) {
				end=mid-1;
			}
			else if(target > arr[mid]) {
				start=mid+1;	
			}
			else {
				return mid;
			}
		}
		return start;
	}
}
