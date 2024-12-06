package Sliding_2Pointers;
import java.util.*;
public class Fruits_Basket {
	public static int totalFruit(int[] fruits) {
        int maxLen=0;
        for (int i=0;i<fruits.length;i++){
            Set<Integer> stt= new HashSet<>();
            for (int j=i;j<fruits.length;j++){
                stt.add(fruits[j]);
                if (stt.size() <=2){
                    maxLen= Math.max(maxLen, j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return maxLen;
    }
	public static int totalFruit_better(int[] arr) {
		  Map<Integer,Integer> mpp = new HashMap<>();
	      int l=0;
	      int r=0;
	      int maxLen = 0;
	      while (r< arr.length) {
	    	  mpp.put(arr[r], mpp.getOrDefault(arr[r], 0)+1);
	    	 
	    		  if (mpp.size() > 2) {
	    			 mpp.put(arr[l], mpp.get(arr[l])-1);
	    			 if (mpp.get(arr[l])==0) {
	       			  mpp.remove(arr[l]);
	       		  	}
	    			 l++;
	    		  }
	    		  maxLen = Math.max(r-l+1, maxLen);
	    		  r++;	 
	    	  
	      }
	          return maxLen;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,2,2};
		System.out.println(totalFruit_better(arr));

	}

}
