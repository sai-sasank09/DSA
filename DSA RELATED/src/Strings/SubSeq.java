package Strings;

import java.util.HashSet;

public class SubSeq {
	//subsequence is for strings
	//subsets is for arrays
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsequence("","abcabcbb");

	}
	static void Subsequence(String p,String up) {
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char ch= up.charAt(0);
		
		Subsequence(p+ch,up.substring(1));
		Subsequence(p,up.substring(1));
		
		
		
	}
	
}
