package Arrays;
import java.util.Arrays;

class LongestConsecutiveNum {
	
	public static void main(String[] args) {
		int[] nums= {2,4,8,1,3,5,7,6,99};
		int ans=longestConsecutive(nums);
		System.out.println(ans);

	}
    static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        int current=1;
        int longCurrent=1;
        if (nums.length == 0){
        return 0;}

        for (int i=1;i<nums.length;i++){
            int ans=nums[i] - nums[i-1];
            if (nums[i] != nums[i-1]){
                if (ans==1){
                    current++;
                }
                else if (ans>1){
                    longCurrent=Math.max(current,longCurrent);
                    current=1;
                }

            }
            longCurrent= Math.max(longCurrent,current);
            
        }
        return longCurrent;
    }
}





	


