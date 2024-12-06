package Stack;
import java.util.*;
public class AsteroidCollision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,7,1,1,2,-3,-7,17,15,-16};;
//		int[] arr= {8,-8};
		
		System.out.println(Arrays.toString(asteroid(arr)));

	}

	private static int[] asteroid(int[] arr) {
		Stack<Integer> stk= new Stack<>();
		for (int i=0;i<arr.length;i++) {
			if (arr[i]>0) {
				stk.push(arr[i]);	
			}
			else  {
				while (!stk.isEmpty() && stk.peek()>0 && stk.peek() < Math.abs(arr[i])) {
					stk.pop();
				}
				if (stk.isEmpty() || stk.peek() < 0) {
                    stk.push(arr[i]);
				}
				 else if (stk.peek() == Math.abs(arr[i])) {     
	                    stk.pop();
				 }	
			}	
		}
//		System.out.println(stk);
		int[] res=new int[stk.size()];
		 for (int i = stk.size() - 1; i >= 0; i--) {
	            res[i] = stk.pop();
	        }
		return res;
	}

}
