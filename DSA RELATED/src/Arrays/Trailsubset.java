package Arrays;

import java.util.ArrayList;
import java.util.*;

public class Trailsubset {

	public static void main(String[] args) {
		
		int[] nums= {1,2,3};
		int[] numsD= {1,2,2};
		System.out.println(subsets(nums));
//		System.out.println(subsetsDuplicate(numsD));

	}

	
	 public static List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // Start with an empty subset

        for (int num:nums) {
            int size = result.size();
           
            for (int i = 0; i < size; i++) {
            	
                List<Integer> newSubset = new ArrayList<>(result.get(i));
//                System.out.println(num);
                newSubset.add(num);
                
                result.add(newSubset);
                System.out.println(num+ " " +i+ " "+result);

//               
            }
        }

        return result;
    }
	 public static List<List<Integer>> subsetsDuplicate(int[] nums) {
		 Arrays.sort(nums);
         List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // Start with an empty subset
        int start=0;
        int end=0;
        for(int i=0;i<nums.length;i++) {
        	start=0;
        	if(i>0 && nums[i]== nums[i-1]) {
        		start=end+1;
        	}
        	end=result.size()-1;
            int size = result.size();
            for (int j = start; j < size; j++) {
                List<Integer> newSubset = new ArrayList<>(result.get(j));
                
                newSubset.add(nums[i]);
                
                result.add(newSubset);
        }
        }
        return result;
    }
	 
}
