package Arrays;
public class LongestSubArrayWithSum
{
     // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        int sum=0;
        int maxy=0;
        for (int i=0;i<N;i++){
            for (int j=i;j<N;j++){
                long s=0;
             for (int k=i;k<=j;k++){
                 s += A[k];
             }
             if (s==K){
                 maxy=Math.max(maxy,j-i+1);
             }
            }
          return maxy; 
        }  
        return -1;
    }
    
	public static void main(String[] args) {
		   int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = lenOfLongSubarr(a,5,10);
        System.out.println("The length of the longest subarray is: " + len);
	}
}