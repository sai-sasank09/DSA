package Searching;

public class FloorBS {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,3,4,5,6,7,8,9};
		int ans=Floor(arr,10);
		System.out.print(ans);
	}
	// return the index of greatest no <= target
	static int Floor(int[] arr, int target) {
		
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
		return end;
	}
}
