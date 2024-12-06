package Stack;
import java.util.*;
public class nextSmallerElement {

	public static void main(String[] args) {
		int[] arr= {5,7,9,6,7,4,5,1,3,7};
		int[] arr1= {2,1,4,3};
		System.out.println(Arrays.toString(nextSmallerElementStack(arr1)));

	}
	public static int[] NextSmaller(int[] arr) {
		int n=arr.length;
		int[] nge=new int[n];
		Arrays.fill(nge, -1);
		for (int i=0;i<n-1;i++) {
			for (int j=i-1 ; j>=0;j--) {
				if(arr[j]<arr[i]) {
					nge[i]=arr[j];
					break;
				}
				else {
					nge[i]=-1;
				}
			}
		}
		return nge;
	}
	public static int[] nextSmallerElementStack(int[] arr) {
		int n=arr.length;
		int[] nge=new int[n];
		Arrays.fill(nge, -1);
		Stack<Integer> stk= new Stack<Integer>();
		for (int i=0;i<n;i++) {
			while (!stk.isEmpty() && stk.peek() >= arr[i]) {
				stk.pop();
			}
			nge[i]= stk.empty() ? arr.length: stk.peek();
			stk.push(arr[i]);
		}
		return nge;
	}

}
