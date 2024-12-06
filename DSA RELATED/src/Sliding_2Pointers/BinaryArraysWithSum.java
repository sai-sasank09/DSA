package Sliding_2Pointers;

public class BinaryArraysWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {1,0,1,0,1};
		System.out.println(numSubarraysWithSum(nums,2));

	}
	 public static int numSubarraysWithSum(int[] nums, int goal) {
	        return func(nums,goal) - func(nums,goal-1);
	    }
	    public static int func(int[] nums, int goal){
	        if (goal < 0) return 0;
	        int count=0;
	        int l=0, r=0;
	        int sum=0;
	        while (r< nums.length) {
	        	sum += nums[r];
	             while (sum > goal){
	                sum -= nums[l];
	                l++;
	            }
	            count = count + (r-l+1);
	           
	        	r++;
	        }
	        return count;
	    }

}
