package Sorting;
import java.util.*;
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {6,3,2,8,4,1,9,1,10};
		int low=0;
		int high = arr.length-1;
		mergeSort(arr,low,high);
		System.out.println(Arrays.toString(arr));

	}

	private static void mergeSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if(low==high) return;
		
		int mid= (low+ high ) /2;
		mergeSort(arr,low,mid);
		mergeSort(arr,mid+1,high);
		merge(arr,low,mid,high);
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		// TODO Auto-generated method stub
		ArrayList<Integer> temp= new ArrayList<>();
		
		
		int left = low;
		int right= mid+1;
		
		while (left <= mid && right <= high) {
			if(arr[left]< arr[right]) {
				temp.add(arr[left]);
				left++;
			}
			else {
				temp.add(arr[right]);
				right++;
			}
		}
		
		while (left<=mid) {
			temp.add(arr[left]);
			left++;
			
		}
		while (right<=high) {
			temp.add(arr[right]);
			right++;
		}
		
		for (int i=low;i<=high;i++) {
			arr[i]= temp.get(i-low);
		}
	}

}
