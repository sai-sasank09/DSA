package Strings;
import java.util.*;
public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("XIX"));
	}
	 public static int romanToInt(String s) {
	        HashMap<Character, Integer> romInt= new HashMap<>();
	        romInt.put('I',1);
	        romInt.put('V',5);
	        romInt.put('X',10);
	        romInt.put('L',50);
	        romInt.put('C',100);
	        romInt.put('D',500);
	        romInt.put('M',1000);
	        System.out.println(romInt);
	        char[] arr= s.toCharArray();
	        System.out.println(Arrays.toString(arr));
	       
	        int sum=0;
	        for (int i=0;i<s.length();i++) {
	        	if (i<s.length()-1 && romInt.get(arr[i])< romInt.get(arr[i+1])) {
	        		sum -= romInt.get(arr[i]);
	        		System.out.println(sum);
	        	}
	        	else {
	        		sum += romInt.get(arr[i]);
	        		
	        	}
	        	
	        	
	        
	        }
	        
	        
	        
	        
	        return sum;
	        
	        
	        
	        
	        
	        
	        
	        
	    }

}
