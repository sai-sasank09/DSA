package Sorting;
import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {36,98,11,2,9};
		Insertion(arr);
		System.out.println(Arrays.toString(arr));

	}
	static void Insertion(int[] arr) {
		
		for (int i=0;i<arr.length;i++) {
			
			
			int key=arr[i];
			int j=i-1;
			while ((j>=0) && (arr[j] > key)) {
				arr[j+1]= arr[j];
				j= j-1;
				
			}
			arr[j+1]= key;
			
			System.out.println(Arrays.toString(arr));
			
		  }
		
		
	}
	
}
