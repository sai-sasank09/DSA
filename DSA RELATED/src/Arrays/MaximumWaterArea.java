package Arrays;

public class MaximumWaterArea {

	public static void main(String[] args) {
		int[] height= {1,8,6,9,5,4,8,10,7,11};
		System.out.println(maxArea(height));

	}
	public static int maxArea(int[] height) {
        int left=0;
        int right= height.length-1;
        int max_water=0;
        while(left<right){
            int width= right-left;
            int water= Math.min(height[left], height[right]) * width;
            max_water = Math.max(max_water,water);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
       
        }
        return max_water;
    }
	 


}
