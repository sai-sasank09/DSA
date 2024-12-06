package Searching;

public class FirstndLastPos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result=searchRange(new int[] {1,2,3,4,5,5,5,5,7},5);
		System.out.println("First and Last Positions: [" + result[0] + ", " + result[1] + "]");
	}
	 public static int[] searchRange(int[] nums, int target) {
		 int[] ans= {-1,-1};
		  ans[0]=search(nums,target,true);
		  if (ans[0] != -1) {
			  ans[1]=search(nums,target,false);
		  }
//		  ans[1]=search(nums,target,false);
		 
		 return ans;
			
	    }
	 //function just returns the index value of target
	 static int search(int[] nums,int target,boolean findStartIndex) {
		 int ans= -1;
		 int start=0;
		 int end=nums.length -1;
		 while(start<=end) {
//				int mid=(start+end)/2;
				int mid= start + (end-start )/2;
				
				if (target< nums[mid]) {
					end=mid-1; 
				}
				else if(target > nums[mid]) {
					start=mid+1;	
				}
				else {
					ans= mid;
					if (findStartIndex) {
						end=mid-1;
					}
					else {
						start=mid+1;
						
					}
				}
			}
		 return ans;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
