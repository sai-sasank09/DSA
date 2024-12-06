package Sorting;
import java.util.Arrays;

public class SelectionSort {
	public static void main(String args[]) {
		int[] arr= {1,23,3,232,4,2};
		Selection(arr);
		System.out.println(Arrays.toString(arr));
	}
	static void Selection(int[] arr) {
		for (int i=0;i<arr.length;i++) {
			int last=arr.length-i-1;
			int maxIndex=getMaxIndex(arr,0,last);
			Swap(arr,maxIndex,last);
			System.out.println(Arrays.toString(arr));
			
		}
	}
	static void Swap(int[] arr,int first,int second)
	{
		int temp=arr[first];
		arr[first]=arr[second];
		arr[second]=temp;
	}
	static int getMaxIndex(int[] arr, int start, int end) {
		int max=start;
		for (int i=start;i<=end;i++) {
			if (arr[max]<arr[i]) {
				max=i;
			}
		}
		System.out.println("max: "+ max);
		return max;
		
		
	}
	
}
