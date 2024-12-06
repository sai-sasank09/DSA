package Sliding_2Pointers;
import java.util.*;

public class MinimumWindowSubString {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int cnt = 0;
        int sIndex = -1;
        int r = 0, l = 0;
        HashMap<Character, Integer> mpp = new HashMap<>();
        
        // Fill the map with characters of t
        for (Character ch : t.toCharArray()) {
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }
        
        int m = t.length();
        int n = s.length();
        
        while (r < s.length()) {
            // If the character at r is in t, reduce its frequency in the map
            if (mpp.containsKey(s.charAt(r))) {
                mpp.put(s.charAt(r), mpp.get(s.charAt(r)) - 1);
                if (mpp.get(s.charAt(r)) >= 0) { // Only increase cnt when we match a character from t
                    cnt++;
                }
            }
            
            // When we've matched all characters in t, try to shrink the window
            while (cnt == m) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }

                // Shrink the window from the left
                if (mpp.containsKey(s.charAt(l))) {
                    mpp.put(s.charAt(l), mpp.get(s.charAt(l)) + 1);
                    if (mpp.get(s.charAt(l)) > 0) {
                        cnt--;
                    }
                }
                l++; // Move left pointer to shrink the window
            }
            r++; // Move right pointer to expand the window
        }

        // If no valid window is found, return an empty string
        if (sIndex == -1) {
            return "";
        }
        
        // Return the minimum window substring
        return s.substring(sIndex, sIndex + minLen);
    }
}
