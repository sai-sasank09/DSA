package Sliding_2Pointers;
import java.util.*;
public class LongestSubStringAtMostKCharacters {
	// brute way bro
	public static int kDistinctChars(int k, String str) {
		// Write your code here
		int maxLen=0;
		Map<Character,Integer> mpp = new HashMap<>();
		for (int i=0;i<str.length();i++){
			mpp.clear();
			for (int j=i;j<str.length();j++){
				mpp.put(str.charAt(j), mpp.getOrDefault(str.charAt(j), 0)+1);
				if (mpp.size() <= k){
					maxLen= Math.max(maxLen, j-i+1);
				}
				else {
					break;
				}
			}
		}
		return maxLen;
	}
	public static int kDistinctChars_better(int k, String str) {
		// Write your code here
		int maxLen=0;
		Map<Character,Integer> mpp = new HashMap<>();
		int l=0;
		int r=0;
		while (r< str.length()){
			mpp.put(str.charAt(r), mpp.getOrDefault(str.charAt(r), 0)+1);
			if (mpp.size() > k){
				mpp.put(str.charAt(l),mpp.get(str.charAt(l))-1);
				if (mpp.get(str.charAt(l))==0){
					mpp.remove(str.charAt(l));
				}
				l++;
			}
			maxLen= Math.max(maxLen, r-l+1);
			r++;
		}
		return maxLen;
	}
	public static void main(String args[]) {
		System.out.println(kDistinctChars(2,"abbbbbbc"));
	}
}
