package Stack;
import java.util.*;
public class RemoveStars {
	 public static String removeStars(String s) {
	        Stack<Character> stk= new Stack<>();
	        for (int i=0;i<s.length();i++){
	            if(s.charAt(i)=='*'){
	                stk.pop();
	                continue;
	            }
	            stk.push(s.charAt(i));
	        }
	        StringBuilder str= new StringBuilder();
	        while (!stk.isEmpty()){
	            str.append(stk.pop());
	        }
	        str.reverse();
	        return str.toString();
	    }
	public static void main(String[] args) {
		System.out.println(removeStars("leet**cod*e"));

	}

}
