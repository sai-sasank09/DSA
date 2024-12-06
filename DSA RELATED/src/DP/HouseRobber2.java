package DP;
import java.util.*;
public class HouseRobber2 {
	 public static int rob(int[] nums) {
	        int n=nums.length;
	        if (n == 1) return nums[0];
	        return Math.max(robRange(n-2,nums,0),robRange(n-1,nums,1));
	    }
	    private static int robRange(int start,int[] nums, int end) {
	        memo.clear();  
	        return fun(start,nums,end);
	    }
	    static HashMap<Integer,Integer> memo= new HashMap<>();
	    public static int fun(int i,int[] nums,int st){

	        // if(i==0) return nums[i];
	        // if (i<0) return 0;
	        if (i<st) return 0;
	        if(memo.containsKey(i)) return memo.get(i);
	        int take= nums[i]+fun(i-2,nums,st);
	        int not=fun(i-1,nums,st);
	        int res= Math.max(take,not);
	        memo.put(i,res);
	        
	        return res;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
