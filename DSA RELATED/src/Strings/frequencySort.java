package Strings;
import java.util.*;
public class frequencySort {

	public static void main(String[] args) {
		System.out.println(frequencySortt("gireesh"));
	}
	public static String frequencySortt(String s) {
        HashMap<Character,Integer> table= new HashMap<>();
        char[] arr=s.toCharArray();
        for (char c: arr){ 
                table.put(c, table.getOrDefault(c,0)+1);
               
           }
        PriorityQueue<Character> store= new PriorityQueue<>(
        (a,b) -> table.get(b) - table.get(a) 
        );
        store.addAll(table.keySet());
       
           
    StringBuilder result= new StringBuilder();
    System.out.println(store);
    
    while (!store.isEmpty()) {
    	char current=store.remove();
//    	System.out.println(current);
    	int count= table.get(current);
    	
    	for (int i=0;i<count;i++) {
    		result.append(current);
    	}
    }
        
    return result.toString();
    }
}
