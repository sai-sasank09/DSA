package Strings;
import java.util.*;
public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("rat","tar"));
	}
	 public static boolean isAnagram(String s, String t) {
	        if (s.length() != t.length()){
	            return false;
	        }
	        int[] arr= new int[26];
//	      
	        for(int i=0;i<s.length();i++){
	            arr[s.charAt(i) - 'a']++;
	        }
	        for (int j=0;j<t.length();j++){
	            arr[t.charAt(j)- 'a']--;
	        }
	        System.out.println(Arrays.toString(arr));
	        for (int c: arr){
	            if (c!= 0){
	                return false;
	            }
	        }
	        return true;

	    }
}
