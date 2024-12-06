package Stack;
import java.util.*;

public class NextGreaterElementLeetCode {

    public static void main(String[] args) {
        // Example Input
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        
        // Call the method and print the result
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        
        // Initialize the Next Greater Element (NGE) array with -1
        Arrays.fill(nge, -1);
        
        // Traverse nums2 from right to left and calculate the next greater element
        for (int i = nums2.length - 1; i >= 0; i--) {
            // Pop elements from the stack if they are smaller or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            // If the stack is not empty, the top of the stack is the next greater element
            if (!stack.isEmpty()) {
                nge[i] = stack.peek();
            }
            // Push the current element onto the stack
            stack.push(nums2[i]);
        }
        
        // Prepare the result for nums1 by looking up their positions in nums2
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // Find the index of nums1[i] in nums2
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result[i] = nge[j];  // Use the precomputed NGE for nums2[j]
                    break;
                }
            }
        }
        
        return result;
    }
}
