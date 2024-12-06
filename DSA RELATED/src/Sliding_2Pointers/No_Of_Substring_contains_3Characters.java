package Sliding_2Pointers;
import java.util.*;
public class No_Of_Substring_contains_3Characters {
	 public static int numberOfSubstrings(String s) {
	        Map<Character, Integer> mpp = new HashMap<>();
	        int count = 0;
	        int l = 0; // Left pointer of the sliding window

	        for (int r = 0; r < s.length(); r++) {
	            // Add the current character to the map
	            mpp.put(s.charAt(r), mpp.getOrDefault(s.charAt(r), 0) + 1);

	            // Check if the window contains all three characters
	            while (mpp.size() == 3) {
	                // Count all substrings starting from 'l' to 'r'
	                count += s.length() - r;

	                // Shrink the window from the left
	                mpp.put(s.charAt(l), mpp.get(s.charAt(l)) - 1);
	                if (mpp.get(s.charAt(l)) == 0) {
	                    mpp.remove(s.charAt(l)); // Remove the character if its count is 0
	                }
	                l++;
	            }
	        }

	        return count;
	    }
	 public static void main(String args[]) {
		 String s= "abcabc";
		 System.out.println(numberOfSubstrings(s));
	 }
}
