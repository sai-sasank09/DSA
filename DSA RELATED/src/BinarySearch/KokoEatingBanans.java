package BinarySearch;
import java.util.*;
public class KokoEatingBanans {
	public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
       int maxi=piles[piles.length-1];
       int l=1;
       int r=maxi;
       while (l<=r){
           int mid=l+(r-l)/2;
           if(func(piles,mid,h)){
               r=mid-1;
           }
           else l= mid+1;
       }
       return l;
   }
   static boolean func(int[] piles, int hr,int totalH){
       int tHrs=0;
       for (int i=0;i<piles.length;i++){
           tHrs += Math.ceil((double)piles[i] / (double)hr);
       }
       if (tHrs <= totalH) return true;
       return false;
   }
	public static void main(String[] args) {
		
		System.out.println(minEatingSpeed(new int[] {3,6,7,11},8));

	}

}
