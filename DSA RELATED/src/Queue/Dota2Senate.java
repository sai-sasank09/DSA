package Queue;
import java.util.*;
public class Dota2Senate {
	 public static String predictPartyVictory(String senate) {
	        Queue<Integer> rad= new LinkedList<>();
	        Queue<Integer> dir= new LinkedList<>();
	        for (int i=0;i<senate.length();i++){
	            if (senate.charAt(i)=='R'){
	                rad.add(i);
	            }
	            else{
	                dir.add(i);
	            }
	        }
	        int n= senate.length();
	        while (!rad.isEmpty()&& !dir.isEmpty()){
	            int radInd=rad.poll();
	            int dirInd= dir.poll();
	            if (radInd> dirInd){
	                dir.add(dirInd+n);
	            }
	            else{
	                rad.add(radInd+n);
	            }
	        }
	        return rad.isEmpty()? "Dire" : "Radiant"; 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(predictPartyVictory("RDDRRD"));

	}

}
