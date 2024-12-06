package Strings;
import java.util.*;
public class MaximumSubstringLength {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));

	}
	 public static int lengthOfLongestSubstring(String s) {
	        int left=0;
	        int maxL=0;
	        HashSet<Character> sett= new HashSet<>();
	        for (int right=0;right<s.length();right++){
	            while (sett.contains(s.charAt(right))){
	                sett.remove(s.charAt(left));
	                left++;

	            }
	            sett.add(s.charAt(right));
	            maxL= Math.max(maxL, right-left+1);
	        }
	        return maxL;
	    }

}
