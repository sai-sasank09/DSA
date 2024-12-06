package DP;
import java.util.*;
public class MinimumCostForTickets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] days= {1,4,6,7,8,20};
		int[] costs= {2,7,15};
		// day1 pass // day2 pass // day3 pass
		System.out.println("Minimum Cost for Tickets is "+ mincostTickets(days, costs));
	}
	static HashMap<Integer,Integer> memo= new HashMap<>();
	
	 public static int mincostTickets(int[] days, int[] costs) {
		 	memo.clear();
	        return func(days,costs,0);

	    }
	    static int func(int[] days,int[] costs,int i){
	        if(i>=days.length){
	            return 0;
	        }
	        if (memo.containsKey(i)) {
	        	return memo.get(i);
	        }
	        int cost1=costs[0] + func(days,costs,i+1);
	        int cost7=costs[1]+ func(days,costs,nextDayAfter7Days(days,i));
	        int cost30= costs[2]+ func(days,costs,nextDayAfter30Days(days,i));
	        int result=Math.min(cost1,Math.min(cost7,cost30));
	        memo.put(i, result);
	        return result;
	    }
	   private static int nextDayAfter7Days(int[] days, int i) {
	        int currentDay = days[i];
	        int lastDay = currentDay + 6; 
	        while (i < days.length && days[i] <= lastDay) {
	            i++;
	        }
	        return i; 
	    }
	    private static int nextDayAfter30Days(int[] days, int i) {
	        int currentDay = days[i];
	        int lastDay = currentDay + 29; 
	        while (i < days.length && days[i] <= lastDay) {
	            i++;
	        }
	        return i; 
	    }
	    
	    
	    
	    
	    
	    
	    public static int dp8(int[] days, int[] costs) {
	        int n = days.length;
	        // Create a DP array to store the minimum costs
	        int[] dp = new int[n + 1]; // dp[i] = minimum cost for the first i days

	        // Iterate through each day
	        for (int i = 0; i < n; i++) {
	            // Option 1: Buy a 1-Day Pass
	            dp[i + 1] = dp[i] + costs[0];

	            // Option 2: Buy a 7-Day Pass
	            int j = i;
	            while (j < n && days[j] < days[i] + 7) {
	                j++;
	            }
	            dp[j] = Math.min(dp[j], dp[i] + costs[1]);

	            // Option 3: Buy a 30-Day Pass
	            j = i;
	            while (j < n && days[j] < days[i] + 30) {
	                j++;
	            }
	            dp[j] = Math.min(dp[j], dp[i] + costs[2]);
	        }

	        // The last element in dp array will have the answer for all days
	        return dp[n];
	    }

}
