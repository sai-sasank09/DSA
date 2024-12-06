package Sliding_2Pointers;

public class Count_NiceArrays {
	  public static int numberOfSubarrays(int[] nums, int k) {
	         return func(nums,k) - func(nums,k-1);
		    }
		    public static int func(int[] nums, int goal){
		        if (goal < 0) return 0;
		        int count=0;
		        int l=0, r=0;
		        int sum=0;
		        while (r< nums.length) {
		        	sum += nums[r] % 2;
		             while (sum > goal){
		                sum -= nums[l] % 2;
		                l++;
		            }
		            count = count + (r-l+1);
		           
		        	r++;
		        }
		        return count;
		    }
		    public static void main(String args[]) {
		    	int arr[]= {1,5,1,2,3,1};
		    	int odd_num= 3;
		    	System.out.println(numberOfSubarrays(arr,odd_num));
		    }
}
