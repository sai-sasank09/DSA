package DP;
import java.util.HashMap;
public class FrogJump {
	    static HashMap<Integer, Integer> memo = new HashMap<>();

	    public static int frogJump(int n, int heights[]) {
	        // Using dynamic programming approach
	        int[] dp = new int[n];
	        dp[0] = 0; // Base case: cost to reach the first step is 0
	        for (int i = 1; i < n; i++) {
	            int fs = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
	            int sc = Integer.MAX_VALUE;
	            if (i >= 2) {
	                sc = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
	            }
	            dp[i] = Math.min(fs, sc);
	        }
	        return dp[n - 1];
	    }

	    public static int func(int i, int[] heights) {
	        if (i <= 0) {
	            return 0;
	        }

	        if (memo.containsKey(i)) {
	            return memo.get(i);
	        }

	        int firstStep = func(i - 1, heights) + Math.abs(heights[i] - heights[i - 1]);

	        int secondStep = Integer.MAX_VALUE;
	        if (i >= 2) {
	            secondStep = func(i - 2, heights) + Math.abs(heights[i] - heights[i - 2]);
	        }
	        int result = Math.min(firstStep, secondStep);
	        memo.put(i, result);
	        return result;
	    }

	    public static void main(String[] args) {
	        // Example test case
	        int[] heights = {10,20,30,10}; // Heights of the steps
	        int n = heights.length; // Number of steps

	        // Call frogJump using dynamic programming approach
	        System.out.println("Using dynamic programming approach:");
	        System.out.println("Minimum cost to reach the last step: " + frogJump(n, heights));

	        // Call func using memoization approach
	        memo.clear(); // Clear memoization map before starting
	        System.out.println("Using memoization approach:");
	        System.out.println("Minimum cost to reach the last step: " + func(n - 1, heights));
	    }
	

}
