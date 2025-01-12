package DP_Strings;
import java.util.*;
public class LongestCommonSubsequence {

	public static int longestCommonSubsequence(String s1, String s2) {
        
        int n=s1.length();
        int m=s2.length();
        int[][] dp= new int[n+1][m+1];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
             
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
              
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m];
    //    return lcs(n,m,text1,text2,dp);
    }
    public static int lcs(int i1,int i2,String str1,String str2,int[][] dp){
        if(i1<0 || i2<0) return 0;
        if(dp[i1][i2] != 0) return dp[i1][i2];
        if(str1.charAt(i1)==str2.charAt(i2)){
            int res=1+lcs(i1-1,i2-1,str1,str2,dp);
            dp[i1][i2]=res;
            return res;
        }
        int res= Math.max(lcs(i1-1,i2,str1,str2,dp),lcs(i1,i2-1,str1,str2,dp));
        dp[i1][i2]=res;
        return res;
    }	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestCommonSubsequence("abcde","ace"));
	}

}
