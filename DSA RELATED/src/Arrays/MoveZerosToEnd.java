package Arrays;
import java.util.*;
public class MoveZerosToEnd {

	public static void main(String[] args) {
		int[] arr= {0,1,0,3,12};
		int[] ans= MoveZerosEnd(arr);
		
		System.out.println(Arrays.toString(ans));

	}

	private static int[] MoveZerosEnd(int[] arr) {
		// TODO Auto-generated method stub
		int[] newArr=new int[arr.length];
		int j=0;
		for (int i=0;i<arr.length;i++) {
			if (arr[i] != 0) {
				newArr[j]= arr[i];
				j++;
			}
		}
		
		return newArr;
	}

}
