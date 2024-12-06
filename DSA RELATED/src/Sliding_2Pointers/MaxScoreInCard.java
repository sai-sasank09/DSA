package Sliding_2Pointers;

public class MaxScoreInCard {
	public static int maxScore(int[] arr, int k) {
        int lsum=0;
        int rsum=0;
        for (int i=0;i<= k- 1;i++){
            lsum += arr[i];
        }
        int maxSum= lsum;
        int rind= arr.length-1;
        for (int i=k-1;i>=0;i--){
            lsum -= arr[i];
            rsum += arr[rind];
            rind--;
            maxSum = Math.max(maxSum, lsum + rsum);
        }
        return maxSum;
    }
	public static void main(String args[]) {
		int[] arr= {1,2,3,4,5,6,1};
		System.out.println(maxScore(arr,3));
	}
}
