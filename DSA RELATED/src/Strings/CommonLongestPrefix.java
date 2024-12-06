package Strings;

public class CommonLongestPrefix {

	  public static void main(String[] args) {
		    String[] strs= {"flower","flow","flight"};
		    System.out.println(longestCommonPrefix(strs));
	}
	  
	  public static String longestCommonPrefix(String[] strs) {
	        String prefix= strs[0];
	        for (int i=1;i<strs.length;i++){
	        	System.out.println(strs[i].indexOf(prefix) !=0);
	            while(strs[i].indexOf(prefix) !=0){
	                prefix= prefix.substring(0,prefix.length()-1);
	            }

	            if (prefix.isEmpty()){
	                return "";
	            }
	        }
	        return prefix;
	    }

}
