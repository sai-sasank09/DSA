package Sliding_2Pointers;
import java.util.*;
public class LenOfSubStringWithoutRepeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
	public static int lengthOfLongestSubstring(String s) {
		HashMap<Character,Integer> mpp = new HashMap<>();
		int l=0;
		int r=0;
		int maxLen=0;
		while (r< s.length()){
			if (mpp.containsKey(s.charAt(r))){
				l=Math.max(mpp.get(s.charAt(r)) + 1, l);
			}
			mpp.put(s.charAt(r),r);
			maxLen= Math.max(maxLen, r-l+1);
			r++;
			
		}
		return maxLen;

	}

}
