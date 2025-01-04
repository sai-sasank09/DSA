package BinarySearch;
import java.util.*;
class SuccesfulPairsOfPortions {
	 public static  int[] successfulPairs(int[] spells, int[] potions, long success) {
	        int[] ans= new int[spells.length];
	        Arrays.sort(potions);
	        for (int i=0;i<spells.length;i++){
	           int spell= spells[i];
	           int l=0;
	           int r=potions.length-1;
	           while (l<=r){
	            int mid= l+ (r-l)/2;
	            if ((long)spell * potions[mid] >= success){
	                r=mid-1;
	            }
	            else l=mid+1;
	           }
	           ans[i]= potions.length-l;
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] spells= {5,1,3};
		int[] potions= {1,2,3,4,5};
		System.out.println(Arrays.toString(successfulPairs(spells,potions,7)));
	}

}
