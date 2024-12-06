package Arrays;
import java.util.*;
public class MaximuProductExceptItself {
	
	public static void main(String args[]) {
		
	
	int[] arr= {1,2,3,4};
	int ans[]= maxProduct(arr);
	System.out.println(Arrays.toString(ans));
	
	}
	
	static int[] maxProduct(int[] arr) {
		int[] pref= new int[arr.length];
		int ans[]=new int[5];
		pref[0]=1;
		for (int i=1;i<arr.length;i++) {
			
			pref[i]= arr[i-1] * pref[i-1];
			
		}
		
		int[] suff= new int[arr.length];
		suff[arr.length-1]=1;
		
		for (int j=arr.length-2;j>=0 ;j--) {
			suff[j]= suff[j+1] * arr[j+1];
		}
		
		for (int i=0;i<arr.length;i++) {
			ans[i]= pref[i] * suff[i];
		}
		
		return ans;
	}
}	

