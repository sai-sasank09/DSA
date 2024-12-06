package CollegePractice;
import java.util.*;
public class ZohoExamp {

	public static void main(String[] args) {
		int n=15;
		int[] arr=new int[20];
		int ind;
		int itr=2;
		arr[0]=3;
		arr[1]=4;
		for (ind=0;itr<=n;ind++) {
			arr[itr++]= arr[ind] * 10 + 3;
			arr[itr++]= arr[ind]* 10 +4;
		}
		System.out.println(Arrays.toString(arr));
	}

	

}
