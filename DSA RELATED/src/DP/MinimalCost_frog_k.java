package DP;

import java.util.*;
class MinimalCost_frog_k {

    public static void main(String[] args) {
        // Example input
        int[] arr = {10, 30, 40, 50, 20};
        int k = 2;
        
        // Call the minimizeCost function
        int result = minimizeCost(arr, k);
        
        // Print the result
        System.out.println("Minimum cost to reach the last index: " + result);
    }

    public static int minimizeCost(int arr[], int k) {
        memo.clear();
        // Call the dynamic programming method
        return fun(arr.length - 1, k, arr);
    }

    static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int fun(int ind, int k, int[] arr) {
        if (ind == 0) {
            return 0;
        }
        if (memo.containsKey(ind)) {
            return memo.get(ind);
        }

        int mini = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            if (ind - j >= 0) {
                int jump = fun(ind - j, k, arr) + Math.abs(arr[ind] - arr[ind - j]);
                mini = Math.min(jump, mini);
            }
        }

        memo.put(ind, mini);
        return mini;
    }

    // Uncommented dynamic programming solution
    public static int minimizeCostDP(int arr[], int k) {
        int[] dp = new int[arr.length];
        dp[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            int mini = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    mini = Math.min(mini, jump);
                }
            }
            dp[i] = mini;
        }
        return dp[arr.length - 1];
    }
}

