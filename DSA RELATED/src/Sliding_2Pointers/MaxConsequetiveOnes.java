package Sliding_2Pointers;

public class MaxConsequetiveOnes {
	//better 
	public static int longestOnes(int[] nums, int k) {
	        int l=0;
	        int r=0;
	        int maxLen=0;
	       int zeros=0;
	        while (r< nums.length){
	            if (nums[r]==0){
	            zeros++;
	            }
	            while (zeros>k){
	                if (nums[l]==0) zeros--;
	                l++;
	            }
	            if(zeros <=k){
	               int len=r-l+1;
	                maxLen=Math.max(len,maxLen);
	            }
	            r++;
	        }
	        return maxLen;
	    }
	//optimal
	 public static int longestOnes_optimal(int[] nums, int k) {
		 int l=0;
	        int r=0;
	        int maxLen=0;
	       int zeros=0;
	        while (r< nums.length){
	            if (nums[r]==0){
	            zeros++;
	            }
	            // the l pointer is moving as a window
	            if (zeros>k) {
	                if (nums[l]==0) zeros--;
	                l++;
	            }
	            if(zeros <=k){
	               int len=r-l+1;
	                maxLen=Math.max(len,maxLen);
	            }
	            r++;
	        }
	        return maxLen;
	    }
}
