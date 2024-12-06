package Arrays;
//import java.*;
class TwoSum {
	
    static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+ nums[j] == target){
                    return new int[] {i,j};
                }
            }
        
        }
        
        
        return new int[]{};
    }
    public static void main(String args[]) {
		int[] nums= {2,3,5,6,7};
		int target= 8;
		int[] arr=twoSum(nums,target);
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
		
	}
}
