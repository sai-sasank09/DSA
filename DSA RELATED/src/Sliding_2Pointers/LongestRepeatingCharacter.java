package Sliding_2Pointers;
import java.util.*;
public class LongestRepeatingCharacter {
	 public static int characterReplacement(String s, int k) {
		 int maxLen=0;
		 HashMap<Character, Integer> mpp = new HashMap<>();
		 int l=0;
		 int r=0;
         int maxF=0;
		 while (r< s.length()) {
			 
			 mpp.put(s.charAt(r), mpp.getOrDefault(s.charAt(r), 0)+1);
			 maxF = Math.max(maxF, mpp.get(s.charAt(r)));
			 if ((r-l+1) - maxF > k) {
				 mpp.put(s.charAt(l), mpp.get(s.charAt(l))-1);
				 if (mpp.get(s.charAt(l))==0) {
					 mpp.remove(s.charAt(l));
				 }
				//  maxF--;
				 l++;
			 }
			 maxLen= Math.max(maxLen, r-l+1);
			 r++;
			 
		 }
		 return maxLen; 
		 
	 }
}
