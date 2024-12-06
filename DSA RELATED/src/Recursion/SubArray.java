package Recursion;
import java.util.Arrays;
public class SubArray {

	private static int count;

	public SubArray() {
		count=0;
		
	}

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,9};
		CountSubArrayRecursion(arr,0,0,11);
		System.out.println(count);
	}

	private static void CountSubArrayRecursion(int[] arr,int sum, int i, int k) {
		
		if (sum== k) {
			count++;
			System.out.println(i+ " "+ sum);
			return;
		}
		if (i >= arr.length || sum > k) {
			return;
		}
		
		CountSubArrayRecursion(arr,sum+arr[i], i+1, k);
		CountSubArrayRecursion(arr, sum, i+1, k);
		
		
	}

}
