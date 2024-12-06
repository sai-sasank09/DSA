package Sliding_2Pointers;
import java.util.*;
public class SubarrayWithKDistinct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,1,2,3};
		int k=2;
		System.out.println(subarraysWithKDistinct(arr,k));

	}
	public static int subarraysWithKDistinct(int[] nums, int k) {

	      return func(nums,k) - func(nums,k-1); 
	        
	    }
	    public static int func(int[] nums, int k){
	         int l=0, r=0;
	        int cnt=0;
	        HashMap<Integer, Integer> mpp = new HashMap<>();
	        while (r< nums.length){

	            mpp.put(nums[r], mpp.getOrDefault(nums[r],0)+1);

	            while (mpp.size() > k){
	                mpp.put(nums[l], mpp.get(nums[l]) -1);
	                if (mpp.get(nums[l])==0){
	                    mpp.remove(nums[l]);
	                }
	                l++;
	            }
	            cnt += (r-l+1);
	            r++;
	        }
	        return cnt;
	    }

}
