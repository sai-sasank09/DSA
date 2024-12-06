package DP_2d;
import java.util.*;
public class NinjasTraining {
	 public static int ninjaTraining(int n, int points[][]) {
//	        memo.clear(); // Clear the memoization map for fresh calculations
	        return fun(n - 1, 3, points); // Start from the last day with no task restriction
	}
	 static HashMap<String,Integer> memo= new HashMap<>();
	 static int fun(int day, int last, int[][] points) {
		
		 if(day==0) {
			 int maxi=0;
			 for (int i=0;i<3;i++) {
				 if(i!=last) {
					 maxi=Math.max(points[0][i], maxi);
				 }
			 }
			 return maxi;
		 }
		 String key=day +","+ last;
		 if (memo.containsKey(key)) {
			 return memo.get(key);
		 }
		 int maxi=0;
		 for (int i=0;i<3;i++) {
			 if (i!=last) {
				 int total= points[day][i] + fun(day-1,i,points);
				 maxi= Math.max(maxi, total);
			 }
		 }
		 memo.put(key, maxi);
		 return maxi;
		 
	 }
	 int funcdp(int[][] points){
	      int n=points.length;
       int[][] dp= new int[n][4];
       dp[0][0]=Math.max(dp[0][1], dp[0][2]);
       dp[0][0] = Math.max(points[0][1], points[0][2]);
       dp[0][1] = Math.max(points[0][0], points[0][2]);
       dp[0][2] = Math.max(points[0][0], points[0][1]);
       dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

       for (int day=1;day<n;day++){
           for (int last=0;last<4;last++){
               dp[day][last]=0;
               // int maxi=0;
               for (int i=0;i<3;i++){
                   if(i!=last){
                       int total=points[day][i] + dp[day-1][i];
                       // maxi=Math.max(maxi,total);
                       dp[day][last]=Math.max(total,dp[day][last]);
                   }
               
               }
               // dp[day][last]=maxi;

           }
       }

       return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], Math.max(dp[n - 1][2], dp[n - 1][3])));


	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] points = {
		            {10, 40, 70},
		            {20, 50, 80},
		            {30, 60, 90}
		        };
		        int n = points.length;

		        System.out.println(ninjaTraining(n, points));
		
	}

}
