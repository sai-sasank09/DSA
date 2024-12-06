package DP;
import java.util.*;
public class TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] nums= {1,1,1,1,1};
			int target=3;
			System.out.println("Ways: "+findTargetSumWays(nums,target));
	}
	 public static int findTargetSumWays(int[] nums, int target) {
	      mpp.clear();
	       return func(0,0,nums,target);
	    }
	   static  HashMap<String,Integer> mpp= new HashMap<>();
	    public static int func(int i,int curr, int[] nums, int target){
	        if (i>=nums.length){
	            return curr==target ? 1: 0;
	        }
	        String str= i+ ","+curr;
	        if(mpp.containsKey(str)){
	            return mpp.get(str);
	        }
	        int left= func(i+1,curr+ nums[i],nums,target);
	        int second= func(i+1,curr-nums[i],nums,target);
	        int ans=left+second;
	        mpp.put(str,ans);
	        return ans;
	    }

}
