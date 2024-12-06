package Stack;
import java.util.*;
public class PSE_NSE {
	 public static int[] findPSE(int[] arr) {
	        int n = arr.length;
	        int[] pse = new int[n];
	        Stack<Integer> stack = new Stack<>();

	        for (int i = 0; i < n; i++) {
	            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
	                stack.pop();
	            }
	            pse[i] = stack.isEmpty() ? -1 : stack.peek(); // -1 if no smaller element
	            stack.push(i);
	        }
	        return pse;
	    }

	    // Function to find Next Smaller Elements (NSE)
	 public static int[] findNSE(int[] arr) {
	        int n = arr.length;              // Get the length of the array
	        int[] nse = new int[n];          // Create an array to store the NSE results
	        Stack<Integer> stack = new Stack<>(); // Create a stack to store indices

	        // Traverse the array from right to left
	        for (int i = n - 1; i >= 0; i--) {
	            // Pop elements from the stack until we find a smaller element
	            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
	                stack.pop();
	            }
	            // If the stack is empty, there is no smaller element
	            nse[i] = stack.isEmpty() ? -1 : arr[stack.peek()]; // Assign -1 if no smaller element found
	            stack.push(i); // Push the current index onto the stack
	        }
	        return nse; // Return the array containing the next smaller elements
	    }
	    public static void main(String[] abc) {
	    	int[] arr= {3,1,2,4,7,1};
	    	int[] nse=findNSE(arr);
	    	int[] pse= findPSE(arr);
	    	System.out.println("NSE "+Arrays.toString(nse));
	    	System.out.println("PSE "+Arrays.toString(pse));
	    }
}
