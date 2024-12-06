package DP;

import java.util.HashMap;


class ClimbStairs {
    private static HashMap<Integer, Integer> mem = new HashMap<>();

    // Using memoization approach
    public static int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (mem.containsKey(n)) {
            return mem.get(n);
        }
        int one = climbStairs(n - 1);
        int two = climbStairs(n - 2);
        mem.put(n, one + two);
        return mem.get(n);
    }

    // Using dynamic programming approach
    public static int climbStairsDP(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int oneS = dp[i - 1];
            int twoS = dp[i - 2];
            dp[i] = oneS + twoS;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // Example test cases
        int n1 = 5; // For 5 stairs
        int n2 = 10; // For 10 stairs

        // Using memoization approach
        System.out.println("Using memoization:");
        System.out.println("Number of ways to climb " + n1 + " stairs: " + climbStairs(n1));
        System.out.println("Number of ways to climb " + n2 + " stairs: " + climbStairs(n2));

        // Using dynamic programming approach
        System.out.println("Using dynamic programming:");
        System.out.println("Number of ways to climb " + n1 + " stairs: " + climbStairsDP(n1));
        System.out.println("Number of ways to climb " + n2 + " stairs: " + climbStairsDP(n2));
    }
}
