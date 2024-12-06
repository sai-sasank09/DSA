package Stack;
import java.util.*;
import java.util.Stack;

class SumofRanges {
    // Function to find Previous Smaller Elements (PSE)
    public static int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    // Function to find Next Smaller Elements (NSE)
    public static int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    // Function to find Previous Greater Elements (PGE)
    public  static int[] findPGE(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pge;
    }

    // Function to find Next Greater Elements (NGE)
    public static int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nge;
    }

    // Main function to calculate the sum of subarray ranges
    public static long subArrayRanges(int[] nums) {
        int n = nums.length;
        long totalRangeSum = 0;

        int[] pse = findPSE(nums);
        int[] nse = findNSE(nums);
        int[] pge = findPGE(nums);
        int[] nge = findNGE(nums);

        // Calculate the contribution for the minimums
        for (int i = 0; i < n; i++) {
            long leftCountMin = i - pse[i]; // Count of elements on the left including nums[i]
            long rightCountMin = nse[i] - i; // Count of elements on the right including nums[i]
            totalRangeSum -= nums[i] * leftCountMin * rightCountMin; // Subtract min contribution
        }

        // Calculate the contribution for the maximums
        for (int i = 0; i < n; i++) {
            long leftCountMax = i - pge[i]; // Count of elements on the left including nums[i]
            long rightCountMax = nge[i] - i; // Count of elements on the right including nums[i]
            totalRangeSum += nums[i] * leftCountMax * rightCountMax; // Add max contribution
        }

        return totalRangeSum; // Return the total range sum
    }

    public static void main(String[] args) {

        
        // Test cases
        int[] nums1 = {1, 2, 3};
        System.out.println("Sum of subarray ranges: " + subArrayRanges(nums1)); // Expected: 4
        
        int[] nums2 = {1, 3, 3};
        System.out.println("Sum of subarray ranges: " + subArrayRanges(nums2)); // Expected: 4
        
        int[] nums3 = {4, -2, -3, 4, 1};
        System.out.println("Sum of subarray ranges: " + subArrayRanges(nums3)); // Expected: 59
    }
}

