package Stack;
import java.util.*;
public class NextGreaterElement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,1};
		System.out.println(Arrays.toString(nextGreaterElementStack(arr)));
	}
	public int[] nextGreaterElements(int[] a) {
        int[] nge= new int[a.length];
      int n=a.length;
      if (a.length==1) nge[0]=-1;
      for (int i=0;i<n;i++){

              for(int j=i+1;j< i+ n;j++){
                  int ind= j% n;
                  if (a[ind] > a[i]) {
                      nge[i]=a[ind];
                      break;
                  }
                  else{
                      nge[i]=-1;
                  }
              }

      }

      return nge;
  }
	public static int[] nextGreaterElementStack(int[] arr) {
		int[] nge=new int[arr.length];
		Stack<Integer> stk= new Stack<>();
		Arrays.fill(nge, -1);
		for (int i=2*(arr.length-1);i>=0;i--) {
			while (!stk.isEmpty() && stk.peek() <= arr[i%arr.length]) {
				stk.pop();
			}
			if (i<arr.length) {
				nge[i]=stk.empty() ? -1 : stk.peek();
			}
			stk.push(arr[i%arr.length]);
		}
		return nge;
	}
}
