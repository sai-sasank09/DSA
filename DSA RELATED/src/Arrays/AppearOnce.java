package Arrays;
import java.util.*;
import java.util.Map;

public class AppearOnce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr= {1,2,2};
		
		 
		 
	       int finalAns=0;
	       
	       Map<Integer,Integer> ans= new HashMap<Integer,Integer>();
	       
	       for (int val: arr) {
	    	   if (ans.containsKey(val)) {
	    		   ans.put(val, ans.get(val)+1);
	    	   }
	    	   else {
	    		   ans.put(val, 1);
	    	   }
	       }
//	       for (int val : arr) {
//	            ans.put(val, ans.getOrDefault(val, 0) + 1);
//	        }
	       for (Map.Entry<Integer,Integer> once: ans.entrySet()) {
	    	   if (once.getValue()==1) {
	    		    finalAns=once.getKey();
	    		    break;
	    	   }
	       }
	       System.out.println(finalAns);
	       
	}

}
