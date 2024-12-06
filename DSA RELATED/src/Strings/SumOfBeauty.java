package Strings;
import java.util.*;
public class SumOfBeauty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(beautySum("abcabc"));
	}

    public static int beautySum(String s) {
           int n = s.length();
        int totalBeauty = 0;
        for (int start = 0; start < n; start++) {
            int[] freq = new int[26]; 
            for (int end = start; end < n; end++) {
                
                freq[s.charAt(end) - 'a']++;
                System.out.println(Arrays.toString(freq));
                
               
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;
                for (int count : freq) {
                    if (count > 0) {
                        maxFreq = Math.max(maxFreq, count);
                        minFreq = Math.min(minFreq, count);
                    }
                }
                totalBeauty += maxFreq - minFreq;
            }
        }
        
        return totalBeauty;
    }
}



