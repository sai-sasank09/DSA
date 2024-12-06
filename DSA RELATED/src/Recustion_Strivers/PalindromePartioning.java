package Recustion_Strivers;
import java.util.*;
public class PalindromePartioning {
	  public static List<List<String>> partition(String s) {

	        // Write your code here.
	       List<List<String>> ans= new ArrayList<>();
	       ans.clear();
	       List<String> store= new ArrayList<>();
	       func(0,s,ans,store);
	       return ans;
	    }
	    static void func(int ind, String s, List<List<String>> ans, List<String> store){
	        if (ind>=s.length()){
	            ans.add(new ArrayList<>(store));
	            return;
	        }
	        for (int i=ind;i<s.length();i++){
	            if(isPali(s,ind,i)){
	                store.add(s.substring(ind,i+1));
	                func(i+1,s,ans,store);
	                store.remove(store.size()-1);

	            }

	        }

	    }
	   static boolean isPali(String s, int l, int r){
	        while (l<=r){
	            if (s.charAt(l) != s.charAt(r)){
	                return false;
	            }
	            l++;
	            r--;
	        }
	        return true;
	    }
	   public static void main(String args[]) {
		   System.out.println(partition("aabb"));
	   }
}
