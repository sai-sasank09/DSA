package Stack;
import java.util.*;
public class NextGreaterNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {7,12,1,0};
		int n=4;
		System.out.println(Arrays.toString(nextGreaterElement(arr,n)));

	}
	 public static int[] nextGreaterElement(int[] arr, int n) {
	        // Write your code here.

	        Stack<Integer> stk= new Stack<>();
	        int[] nge= new int[arr.length];
	           Arrays.fill(nge, -1);
	        for (int i=n-1;i>=0;i--){
	            while (!stk.isEmpty() && arr[i] >= stk.peek()){
	                stk.pop();
	            }
	            if(stk.isEmpty()) nge[i]=-1;
	            else{
	                nge[i]=stk.peek();
	            }
	            stk.push(arr[i]);
	        }

	    
	        return nge;

	    }

}
