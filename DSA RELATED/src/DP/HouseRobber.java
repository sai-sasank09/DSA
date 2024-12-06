package DP;
import java.util.*;
public class HouseRobber {
	static HashMap<Integer,Integer> memo=new HashMap<>();

	public static int maxMoneyLooted(int[] houses) {
		memo.clear();
		return func(houses.length-1,houses);
	}
	public static int func(int i, int[] houses){
		// if (i==0){
		// 	return houses[i];
		// }
		// if (i<0){
		// 	return 0;
		// }
		// if (memo.containsKey(i)){
		// 	return memo.get(i);
		// }
		// int take= houses[i]+ func(i-2,houses);
		// int nottake= func(i-1,houses);
		// int ans= Math.max(take,nottake);
		// memo.put(i,ans);
		// return ans;
		int n=houses.length;
        int[] dp= new int[n];
        dp[0]=houses[0];
        for (int j=1;j<n;j++){

            int takes= houses[j];
            if (j>1){
            takes += dp[j-2];
            }
            int notts=dp[j-1];
            dp[j]=Math.max(takes,notts);
        }
        return dp[n-1];
	}
	public static void main(String args[]) {
		int[] houses= {10,2,3,11};
		System.out.println(maxMoneyLooted(houses));
	}
}
