package Strings;
import java.util.*;
public class Isomorphic {

	 public static boolean isIsomorphic(String s, String t) {
	        if (s.length() != t.length()) {
	            return false;
	        }

	        HashMap<Character, Character> mapS2T = new HashMap<>();
	        HashMap<Character, Character> mapT2S = new HashMap<>();

	        for (int i = 0; i < s.length(); i++) {
	            char c1 = s.charAt(i);
	            char c2 = t.charAt(i);

	            if (mapS2T.containsKey(c1)) {
	                if (mapS2T.get(c1) != c2) {
	                    return false;
	                }
	            } else {
	                mapS2T.put(c1, c2);
	            }

	            if (mapT2S.containsKey(c2)) {
	                if (mapT2S.get(c2) != c1) {
	                    return false;
	                }
	            } else {
	                mapT2S.put(c2, c1);
	            }
	        }

	        return true;
	    }

	    public static void main(String[] args) {
	        System.out.println(isIsomorphic("egg", "add")); // Output: true
	        System.out.println(isIsomorphic("foo", "bar")); // Output: false
	        System.out.println(isIsomorphic("paper", "title")); // Output: true
	        System.out.println(isIsomorphic("ab", "aa")); // Output: false
	    }
	}


