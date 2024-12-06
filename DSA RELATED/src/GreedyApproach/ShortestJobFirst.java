package GreedyApproach;
import java.util.*;
public class ShortestJobFirst {
	  static int solve(int bt[] ) {
		    // code here
		    Arrays.sort(bt);
		    int wtTime=0;
		    int jobTime=0;
		    for(int i=0;i<bt.length;i++){
		        wtTime += jobTime;
		        jobTime += bt[i];
		    }
		    return wtTime/bt.length;

		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] bt= {4,3,7,1,2};
		System.out.println(solve(bt));
	}

}
