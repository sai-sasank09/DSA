package GreedyApproach;
import java.util.*;
public class AssignCookies {
	 public static int findContentChildren(int[] g, int[] s) {
	        Arrays.sort(g);
	        Arrays.sort(s);
	        int r=0;
	        int l=0;
	       while (l <s.length && r < g.length){
	        if (s[l] >= g[r]){
	            r++;
	        }
	        l++;
	       }
	       return r;
	 }
	 public static void main(String[] args) {
		int[] g = {1,2,3};
		int[] s = {1,1};
		System.out.println(findContentChildren(g,s));
	 }
}
