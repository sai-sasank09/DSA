package Sorting;
import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,53,35,4,5};
		bubble(arr);
		System.out.print(Arrays.toString(arr));
	}
	static void bubble(int[] arr) {
		boolean swapped;
		for (int i=0;i<arr.length;i++) {
			swapped=false;
			for (int j=1;j<=arr.length-i-1;j++) {
				if (arr[j] < arr[j-1]) {
					int temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp; 
					swapped=true;
					System.out.println(Arrays.toString(arr));
				}
			}
			if(!swapped) {
				break;
			}
		}
	}

}
