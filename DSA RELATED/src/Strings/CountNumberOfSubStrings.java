package Strings;
import java.util.*;
public class CountNumberOfSubStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(substrCount("abababa",2));

	}
	public static long substrCount (String S, int K) {
        // your code here
		
		return atMostSubString(S,K) - atMostSubString(S,K-1);
        
    }
    
    
    public static long atMostSubString(String S, int K){
        HashMap<Character, Integer> mpp= new HashMap<>();
        int left=0;
        long count=0;
        for (int right=0;right<S.length();right++){
            char current= S.charAt(right);
            mpp.put(current, mpp.getOrDefault(current,0)+1);
            //ababa== a, ab, aba
            while (mpp.size()> K) {
            	char leftChar=S.charAt(left);
            	mpp.put(leftChar, mpp.get(leftChar)-1);
            	
            	if(mpp.get(leftChar)== 0) {
            		mpp.remove(leftChar);
            	}
            	left++;
            	
            }            
            count= count+ right -left +1;
        }
        return count;
    }

}

    
    
